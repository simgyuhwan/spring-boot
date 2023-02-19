package com.toby.boot;

//import org.springframework.boot.SpringApplication;
import com.toby.boot.controller.IndexController;
import com.toby.boot.service.SimpleIndexService;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
		GenericApplicationContext applicationContext = new GenericApplicationContext();
		applicationContext.registerBean(IndexController.class);
		// DI를 위한 구현체 빈 등록
		applicationContext.registerBean(SimpleIndexService.class);

		applicationContext.refresh();

		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext ->
				servletContext.addServlet("frontcontroller", new HttpServlet() {
					@Override
					protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
						if(req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
							String name = req.getParameter("name");

							IndexController indexController = applicationContext.getBean(IndexController.class);
							String ret = indexController.hello(name);

							res.setContentType(MediaType.TEXT_PLAIN_VALUE);
							res.getWriter().println(ret);
						} else {
							res.setStatus(HttpStatus.NOT_FOUND.value());
						}
					}
				}).addMapping("/*")
		);

		webServer.start();
	}
}
