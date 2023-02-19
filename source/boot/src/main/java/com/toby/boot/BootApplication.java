package com.toby.boot;

//import org.springframework.boot.SpringApplication;

import com.toby.boot.controller.IndexController;
import com.toby.boot.service.SimpleIndexService;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) {
		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
		applicationContext.registerBean(IndexController.class);
		// DI를 위한 구현체 빈 등록
		applicationContext.registerBean(SimpleIndexService.class);

		applicationContext.refresh();

		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext ->
				servletContext.addServlet("dispatcherServlet",
					new DispatcherServlet(applicationContext)
				).addMapping("/*")
		);

		webServer.start();
	}
}
