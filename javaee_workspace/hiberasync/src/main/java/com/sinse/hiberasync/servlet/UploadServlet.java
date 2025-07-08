package com.sinse.hiberasync.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UploadServlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(getClass());
	String uploadPath;
	
	//이 서블릿의 인스턴스가 생성될 때, 서블릿의 초기화를 담당하는 메서드인 init()을 이용하면, 개발자가 이 서블릿의 원하는 정보를 전달할 수 있으며, 필터와 동일하다.
	@Override
	public void init(ServletConfig config) throws ServletException {
		uploadPath=config.getServletContext().getRealPath(config.getInitParameter("uploadPath"));
	}
	
	public UploadServlet() {
		uploadPath="/data";
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// String uploadPath = this.getServletContext().getRealPath("/data"); // jsp 내장 객체(request, response, out, session, application)
		logger.debug("저장할 실제 경로는 "+uploadPath);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		
		// 클라이언트의 요청을 분석 (파싱)
		try {
			List<FileItem> list = servletFileUpload.parseRequest(request); // form태그의 컴포넌트 중 전송 컴포넌트들을 FileItem이라고 부름 
			logger.debug("전송된 컴포넌트의 수는 " +list.size());
			
			for(FileItem item : list) { // <input type="text">, <input type="file">
				if(item.isFormField()) {
					logger.debug(item.getString("utf-8"));
				} else {
					logger.debug(("파일명은 "+item.getName()));
					item.write(new File(uploadPath, item.getName()));
					
					// 세션은 웹컨테이너가 생성하므로, 개발자가 new할 수 없다. 단 이미 생성된 것만 얻어올 수 있다.
					HttpSession session = request.getSession();
					session.setAttribute("img", item.getName());
				}
			}
			
			// 클라이언트의 브라우저로 하여금, 이미지를 볼 수 있는 jsp를 재요청하게 만들자
			response.sendRedirect("/gallery/result.jsp"); // 지정된 url로 클라이언트의 브라우저가 재요청하게 만든다.
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
