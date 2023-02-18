package com.toby.boot;

//import org.springframework.boot.SpringApplication;
import com.toby.boot.controller.IndexController;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BootApplication.class, args);
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();

		// servlet 컨테이너를 만든다
		WebServer webServer = serverFactory.getWebServer(servletContext ->
				servletContext.addServlet("hello", new HttpServlet() {
					@Override
					protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
						// 요청 값 추출
						String name = req.getParameter("name");

						// 응답 설정
						res.setStatus(HttpStatus.OK.value());
						res.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
						res.getWriter().println("Hello " + name);
						super.service(req, res);
					}
				}).addMapping("/hello")
		);

		webServer.start();
	}
}
