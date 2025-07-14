/*
실행 중인 java 프로그램에서 디스크의 파일을 접근하여 데이터를 읽고, 프로그램으로 불러들여 출력해보자
*/
package gui.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileLoader{
	public static void main(String[] args){
		// 실행중인 프로그램이 파일 등의 자원의 데이터를 읽어들이기 위해서는 스트림 객체가 필요함
		/*
		Stream이란? 현실에서는 물줄기, 물의 흐름을 의미함
							전산에서는 그 대상이 물이 아닌 데이터
		흐름의 방향 (두 가지 유형)
		IO(입출력)
			1) 실행 중인 프로그램으로 들어오는 흐름 : Input(입력)
			2) 실행 중인 프로그램에서 빠져나가는 흐름 : Output(출력)
		*/
		
		// 파일을 대상으로 한 입력 객체(파일을 읽어들일 수 있는 객체)
		String name = "E:/Lecture_workspace/back_workspace/java_workspace/guiproject/res/memo.txt";
		// 디스크에 있는 파일에 스트림이 생성되는 순간임
		
		// 문법상엔 문제 없지만, 프로그램 코드 상의 문제 외의 문제 대문에 프로그램이 정상 수행이 될 수 없는 상황이 닥칠 수 있음
		// 이 상황을 방지하기 위해 컴파일러 차원에서 컴파일 거부 중
		FileInputStream fis=null; // 지역변수는 반드시 초기화가 필요함
		try{
			fis = new FileInputStream(name);	
			int data;
			
			while(true){
				data=fis.read(); // 1byte 읽어들임
				if(data==-1)break;
				System.out.print((char)data);
			}
			// DB와 스트림은 다 쓰고 난 후에 반드시 닫아야 함
			// fis.close(); // 스트림 닫기 → 오류가 났을 경우 while문을 미처 끝마치지 못하고 catch문으로 가기 때문에 문제가 생김
		}catch(FileNotFoundException e){ // catch문의 소괄호 안에 에러의 원인이 되는 객체의 인스턴스를 생성하여 전달해준다.
			// 만약 파일이 없다면 파일을 복구하지 못하므로, 원인 등을 알려주거나 로그를 남기는 등의 처리가 필요함...
			System.out.println("파일을 찾을 수 없습니다.");
		}catch(IOException e){
			System.out.println("입출력 도중 에러가 발생했습니다.");
		}finally{
			// 실행부가 try문을 수행하든, catch문을 수행하든 즉, 어느 쪽을 수행하든지 반드시 거쳐 나가는 영역
			// 1) try 성공 시 → finally / 2) catch문 접근 시 → finally
			if(fis !=null){
				try{
					fis.close();
				}catch(IOException e){
				// 일반 유저가 아닌 개발자를 위한 로그 출력 (스택구조로 출력하겠다)
					e.printStackTrace();
				}
			}
		}
	}
}