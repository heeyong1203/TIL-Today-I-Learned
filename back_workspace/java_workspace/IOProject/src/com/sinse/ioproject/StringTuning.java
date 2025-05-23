package com.sinse.ioproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// 대량의 데이터를 읽어보자
public class StringTuning {
	
	FileInputStream fis; // 바이트기반의 입력 스트림
	String name="E:/lecture_workspace/back_workspace/java_workspace/IOProject/res/memo.txt";
			
	public StringTuning() {
		
		try {
			fis=new FileInputStream(name);
			
			int data=-1;
			int count=0;
			
			while(true) {
					data=fis.read();
					if(data==-1)break;
					count++;
					System.out.print((char)data);
			}
			System.out.println("총 읽은 횟수는 " +count);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis !=null) {
				try {
					fis.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new StringTuning();
	}
}
