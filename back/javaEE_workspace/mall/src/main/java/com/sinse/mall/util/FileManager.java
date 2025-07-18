package com.sinse.mall.util;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.sinse.mall.exception.UploadException;

import lombok.extern.slf4j.Slf4j;

//이 객체의 존재가 없다면, 컨트롤러가 '업로드'라는 모델 영역의 업무를 수행하게 되므로, 업로드 수행을 전담할 수 있는 모델 객체를 정의한다.
//이 객체는 DAO, Service 모두 아니며, Controller 역시 아니다. 스프링의 기본 컴포넌트 이외의 컴포넌트로 등록하면 된다.
//Controller의 업무 overwarpping을 방지하기 위한 클래스
@Slf4j
@Component //ComponentScan의 대상이 될 수 있고, 대상이 되면 자동으로 인스턴스가 생성된다.
public class FileManager {
	
	public void save(MultipartFile photo, String savePath, String filename) throws UploadException {
		//메모리에 올라온 이미지 정보를 디스크에 저장
		//파일의 경로를 개발자가 정해두지 말고, 애플리케이션으로부터 경로를 동적으로 얻어오는 방법
		
		//확장자 꺼내기
		filename.lastIndexOf("."); //마지막 점의 위치
		String ext = filename.substring(filename.lastIndexOf(".")+1, filename.length());
		log.debug("확장자" +ext);
		
		//파일명의 유일성을 고정하기 위한 방법
		//해시값, 현재날짜, db의 PK값
		long time = System.currentTimeMillis();
		String newName = time+"."+ext;
		
		File file = new File(savePath, newName); //저장된 파일 (경로, 파일명)
		try {
			photo.transferTo(file);
			log.debug(file.getAbsolutePath()); //업로드된 결과 디렉토리
		} catch (Exception e) {
			e.printStackTrace();
			throw new UploadException("파일 저장 실패", e);
		}
	}
}
