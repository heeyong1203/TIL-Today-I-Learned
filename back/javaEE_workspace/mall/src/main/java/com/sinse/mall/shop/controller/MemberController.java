package com.sinse.mall.shop.controller;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sinse.mall.domain.Member;
import com.sinse.mall.model.member.MemberService;
import com.sinse.mall.model.member.SnsProviderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	@Autowired
	private OAuth20Service googleAuthService;
	
	@Autowired
	private OAuth20Service naverAuthService;
	
	@Autowired
	private OAuth20Service kakaoAuthService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private SnsProviderService snsProviderService;
	
	//로그인 폼 요청 처리
	@GetMapping("/member/loginform")
	public String getForm() {	
		return "shop/member/login";
	}
	
	//로그아웃 요청 처리
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		//세션을 제거할 수는 없다. 단 세션을 무효화시킬 수 있다.
		session.invalidate(); //현재 사용중인 세션 무효화 따라서 이 시점부터 기존 세션을 참조할 수 없다.
		return "redirect:/shop/main";
	}
	
	/*------------------------------------------------------------------------
		Google 로그인 처리
	------------------------------------------------------------------------*/	
	//인증 동의화면 요청 처리
	@GetMapping("/member/google/authurl")
	@ResponseBody
	public String getGoogleAuthUrl() {
		return googleAuthService.getAuthorizationUrl();
	}
	
	//구글에 등록해 놓은 콜백 주소로 전송되는 콜백 요청 처리
	@GetMapping("/callback/sns/google")
	public String googleCallback(@RequestParam("code") String code, HttpSession session) throws IOException, InterruptedException, ExecutionException {
		
		//아 토큰 좀 달라고
		//googleAuthService는 Bean등록 시 이미 ID와 Secret을 할당한 상황이기 때문에 
		//token 요청 시에는 Authorization code 정보만 추가적으로 받으면 된다. 
		OAuth2AccessToken accessToken=googleAuthService.getAccessToken(code); 
		
		log.debug("구글이 전송해준 인증 코드는 "+code);
		log.debug("구글이 전송해준 토큰은 "+accessToken);
		
		//토큰을 받았다! 이제 언제든 Resource Owner의 개인정보에 접근 가능
		OAuthRequest request = new OAuthRequest(Verb.GET, "https://www.googleapis.com/oauth2/v2/userinfo");
		googleAuthService.signRequest(accessToken, request); //요청 시 사용할 토큰 지정
		Response response = googleAuthService.execute(request); //사용자 정보 요청 시도
		
		//json 파싱
		JsonObject json = JsonParser.parseString(response.getBody()).getAsJsonObject();
		
		//필요한 개인정보를 key값으로 조회하여 가져오기
		String email = json.get("email").getAsString();
		String name = json.get("name").getAsString();
		String openid = json.get("id").getAsString(); //sns provider가 회원을 구분하기 위한 내부 식별 id일 뿐 회원이 직접 생성한 id가 아님
		log.debug("사용자의 이메일은 " + email);
		log.debug("사용자명은 " + name); //실제 이름이 아닌 nickname이 날아옴
		log.debug("openid는 " + openid);
		
		//토큰을 통해 얻은 회원정보가 쇼핑몰에 등록되어 있는지(회원가입여부) 체크
		Member member = null;
		
		try {
			//가입이 되어있지 않다면 가입 시킨 후 로그인 완료해주면 된다. 
			//회원 등록
			member = new Member();
			member.setSnsProvider(snsProviderService.selectByName("google"));
			member.setId(openid);
			member.setEmail(email);
			member.setName(name);
			memberService.regist(member);			
		} catch (Exception e) {
			e.printStackTrace();
			//가입되어 있다면 로그인 완료해주면 된다.
			member = memberService.selectById(openid);
		}
		//로그인 처리			
		session.setAttribute("member", member); //세션이 살아있는 한 Member를 사용할 수 있다.
		
		return "redirect:/shop/product/list"; //로그인 완료 후 메인페이지 이동
	}
	
	/*------------------------------------------------------------------------
		Naver 로그인 처리
	------------------------------------------------------------------------*/
	//인증 동의화면 요청 처리
	@GetMapping("/member/naver/authurl")
	@ResponseBody
	public String getNaverAuthUrl() {
		return naverAuthService.getAuthorizationUrl();
	}
		
	//naver에 등록해놓은 콜백 주소로 전송되는 콜백 요청 처리
	@GetMapping("/callback/sns/naver")
	public String naverCallback(@RequestParam("code") String naverCode, @RequestParam("state") String state, HttpSession session) throws IOException, InterruptedException, ExecutionException  { //수동 매핑 방법도 있다.
		
		//IDP가 전송한 code와 client Id, client Secret을 조합하여 토큰을 요청하자.
		//client ID, client Secret은 빈 등록 시 이미 등록한 것들을 사용한다. 
		OAuth2AccessToken accessToken = naverAuthService.getAccessToken(naverCode);
		
		log.debug("Naver에서 발급받은 Token은 " + accessToken);
		
		//발급받은 토큰을 이용하여 회원정보 조회
		OAuthRequest request = new OAuthRequest(Verb.GET, "https://openapi.naver.com/v1/nid/me");
		naverAuthService.signRequest(accessToken, request);
		Response response = naverAuthService.execute(request); //요청 후 그 결과를 받자
		
		JsonObject responseJson = JsonParser.parseString(response.getBody()).getAsJsonObject();
		
		log.debug("responseJson= " + responseJson);
		JsonObject userJson = responseJson.getAsJsonObject("response");
		
		String id = userJson.get("id").getAsString();
		String email = userJson.get("email").getAsString();
		String name = userJson.get("name").getAsString();
		
		//토큰을 통해 얻은 회원정보가 쇼핑몰에 등록되어 있는지(회원가입여부) 체크
				Member member = null;
				
				try {
					//가입이 되어있지 않다면 가입 시킨 후 로그인 완료해주면 된다. 
					//회원 등록
					member = new Member();
					member.setSnsProvider(snsProviderService.selectByName("naver"));
					member.setId(id);
					member.setEmail(email);
					member.setName(name);
					memberService.regist(member);			
				} catch (Exception e) {
					e.printStackTrace();
					//가입되어 있다면 로그인 완료해주면 된다.
					member = memberService.selectById(id);
				}
				//로그인 처리			
				session.setAttribute("member", member); //세션이 살아있는 한 Member를 사용할 수 있다.
				
		return "redirect:/shop/product/list";
	}
	
	/*------------------------------------------------------------------------
		Naver 로그인 처리
	------------------------------------------------------------------------*/
	//인증 동의화면 요청 처리
	@GetMapping("/member/kakao/authurl")
	@ResponseBody
	public String getKakaoAuthUrl() {
		return kakaoAuthService.getAuthorizationUrl();
	}
	
	//kakao에 등록해놓은 콜백 주소로 전송되는 콜백 요청 처리
	@GetMapping("/callback/sns/kakao")
	public String kakaoCallback(@RequestParam("code") String code, HttpSession session) throws IOException, InterruptedException, ExecutionException {
		
		//IDP가 전송한 code와 client Id, client Secret을 조합하여 토큰을 요청하자.
		//client ID, client Secret은 빈 등록 시 이미 등록한 것들을 사용한다. 
		OAuth2AccessToken accessToken = kakaoAuthService.getAccessToken(code);
		
		log.debug("Kakao에서 발급받은 Token은 " + accessToken);
		
		//발급받은 토큰을 이용하여 회원정보 조회
		OAuthRequest request = new OAuthRequest(Verb.GET, "https://kapi.kakao.com/v2/user/me");
		kakaoAuthService.signRequest(accessToken, request);
		Response response = kakaoAuthService.execute(request); //요청 후 그 결과를 받자
		
		JsonObject responseJson = JsonParser.parseString(response.getBody()).getAsJsonObject();
		
		log.debug("responseJson= " + responseJson);
		JsonObject userJson = responseJson.getAsJsonObject("response");
		
		String id = userJson.get("id").getAsString();
		String email = userJson.get("email").getAsString();
		String name = userJson.get("name").getAsString();
		
		return null;
	}
}
