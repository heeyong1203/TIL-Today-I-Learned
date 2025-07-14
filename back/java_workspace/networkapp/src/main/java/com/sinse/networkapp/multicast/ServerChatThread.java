package com.sinse.networkapp.multicast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

// 접속자가 감지되었을 때, 소켓을 넘겨받아 그 소켓과 연결된 클라이언트와 끝없는 메시지를 주고 받자
public class ServerChatThread extends Thread {
	Socket socket; // 서버로부터 넘겨받은 소켓... 스트림을 뽑을수 있기에..
	BufferedReader buffr;
	BufferedWriter buffw;
	Thread thread;
	GUIServer guiServer;
	
	public ServerChatThread(GUIServer guiServer, Socket socket) {
		this.socket = socket;
		this.guiServer = guiServer;
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		thread.start();
	}
	
	public void run() {
		while(true) {
			listen();			
		}
	}
	
	// 듣기
	public void listen() {
		String msg = null;
		try {
			msg = buffr.readLine(); // 클라이언트가 전송한 메세지 청취
			guiServer.area.append(msg+"\n");
			
			send(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 말하기
	public void send(String msg) {
		try {
			buffw.write(msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
