package com.sinse.mall.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.stereotype.Component;

import com.sinse.mall.exception.PasswordEncryptException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PasswordUtil {
	
	//Salt를 생성한다.
	public static String generateSalt() {
		//보안에 사용할 난수 생성기
		SecureRandom sr = new SecureRandom();
		byte[] salt = new byte[16]; //16바이트 배열 (128비트)
		sr.nextBytes(salt);
		log.debug("salt 배열값은 " + salt);
		
		//배열 자체는 사용할 수 없으므로 문자열로 바꾼다.
		return Base64.getEncoder().encodeToString(salt);
	}
	
	//Salt와 Password를 조합한 hash를 생성한다.
	public static String hashPassword(String password, String salt) throws PasswordEncryptException {
		//hash 함수 사용객체로 문자열을 일정 길이의 고정된 해시값으로 바꿔주는 객체
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(salt.getBytes("UTF-8")); //salt를 digest에 추가하는 방식, 즉 해시의 대상이 될 값을 추가할 때 사용한다.
			byte[] hashedByte = md.digest(password.getBytes("UTF-8")); //지금까지 md에 누적된 데이터를 대상으로 암호화 즉, 해시화한다.
			
			return Base64.getEncoder().encodeToString(hashedByte);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PasswordEncryptException("암호화 실패", e);
		} 
	}
	
	public static void main(String[] args) {
		String salt = generateSalt();
		log.debug("문자열로 변경된 salt는 " + salt);
		
		String password="q!w@e#r$";
		String result = hashPassword(password, salt);
		log.debug("result is " + result);
		log.debug("result's length is " + result.length());
	}
}
