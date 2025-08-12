package com.sinse.foodapp.controller;

import java.net.URI;
import java.net.URLEncoder;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinse.foodapp.model.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FoodController {
    private String serviceKey="Eprp%2BjiYP%2B%2FGnJUJLZwxdloQ2pHT6NsX5vcs0rbYTKHKhNnEJmFC4aKv0TSOjALJNjOBhJ%2B3iQAbEFNYgcfOdQ%3D%3D";

    /*
    예전 방식 (HttpURLConnection... 동작은 하지만 최신의 방식은 아니다.)
    */
    /*
    @GetMapping("/stores")
    public Object getList(String store_name) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6430000/cbRecreationalFoodInfoService/getRecreationalFoodInfo");   //URL
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey);                                                                   //Service Key
        urlBuilder.append("&" + URLEncoder.encode("currentPage","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));                                   //페이지 번호
        urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));                                       //한 페이지 결과 수
        // urlBuilder.append("&" + URLEncoder.encode("CMPNM","UTF-8") + "=" + URLEncoder.encode(store_name, "UTF-8"));                           //상호명
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

        // JSON 문자열 → Map 변환
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap = mapper.readValue(sb.toString(), new TypeReference<Map<String, Object>>(){});

        return jsonMap; // Spring이 자동으로 JSON 직렬화
    }
    */

    @GetMapping("/stores")
    public ApiResponse getStores(String store_name) throws IOException, InterruptedException {
        String baseUrl="http://apis.data.go.kr/6430000/cbRecreationalFoodInfoService/getRecreationalFoodInfo";

        //if(store_name.length()<1)store_name="";

        //파라미터 설정
        String url=baseUrl+"?"+
                "serviceKey="+serviceKey+
                "&currentPage="+URLEncoder.encode("1", StandardCharsets.UTF_8)+
                "&perPage="+URLEncoder.encode("10", StandardCharsets.UTF_8)+
                "&CMPNM="+URLEncoder.encode(store_name, StandardCharsets.UTF_8);

        //HttpURLConnection보다 개선된 객체
        HttpClient client = HttpClient.newHttpClient();

        //요청 정보 객체 (OpenAPI 서버에 요청)
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        //OpenAPI 서버에 요청 시도
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        //String 자체를 클라이언트에게 전송해버리면 클라이언트가 문자열을 Json으로 파싱해야하는 번거로움이 있으므로 권장되지 않는 방식이다.
        //따라서 지금부터 Open API의 String 결과물을 Java의 클래스로 매핑시키되, jackson을 이용하여 자동화시킨다.
        //클라이언트에게 보낼 응답정보로 사용할 수 있을 뿐 아니라, 객체화 되어 있어 서버에서도 활용할 수 있다.
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(response.body(), ApiResponse.class); // Spring이 자동으로 JSON 직렬화
    }
}