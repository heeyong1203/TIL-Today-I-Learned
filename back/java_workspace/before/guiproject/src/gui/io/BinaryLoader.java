/*
메모장과 같은 텍스트 파일이 아닌, 이미지나 동영상과 같은 바이너리 파일을 읽어보자
*/
package gui.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class BinaryLoader{
	FileInputStream fis; // 파일을 대상으로 한 입력 스트림
	String name = "E:/Lecture_workspace/back_workspace/java_workspace/guiproject/res/bg.png";
	FileOutputStream fos; // 파일을 대상으로 한 출력 스트림
	String target = "E:/Lecture_workspace/back_workspace/java_workspace/guiproject/res/bg_copy.png";
		
	public BinaryLoader(){
		// 컴파일 시 예외처리를 강요하는 예외방식을 가리켜 '강제 예외'라고 함
		try{
			fis = new FileInputStream(name);
			fos = new FileOutputStream(target);
			int data;
			while(true){
				data = fis.read(); // 1 byte 읽어들임. 호출 시 마다 다음 데이터로 접근함
				if (data==-1)break;
				System.out.println(data);
				// 읽어들인 바이트 데이터를 내뱉는 빨대를 이용하여 출력해보자
				fos.write(data);
			}
		}catch(FileNotFoundException e){
			System.out.println("파일이 존재하지 않습니다. 파일명을 확인해주세요.");
		}catch(IOException e){
			System.out.println("입출력 시 오류가 발생하였습니다.");
		}finally{
			if(fis !=null){
				try{
					fis.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
				
			if(fos !=null){
				try{
					fos.close();
				}catch(IOException e){
					e.printStackTrace();
				}	
			}
		}
	}
	
	public static void main(String[] args){
		// 실행중인 프로그램으로 데이터를 읽어들여야 하므로, 입력스트림 객체가 필요함
		new BinaryLoader();
	}
}