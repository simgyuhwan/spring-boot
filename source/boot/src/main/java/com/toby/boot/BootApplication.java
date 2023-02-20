package com.toby.boot;

//import org.springframework.boot.SpringApplication;

import com.toby.boot.controller.IndexController;
import com.toby.boot.service.IndexService;
import com.toby.boot.service.SimpleIndexService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
public class BootApplication {

	public static void main(String[] args) {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();

				ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
				WebServer webServer = serverFactory.getWebServer(servletContext ->
						servletContext.addServlet("dispatcherServlet",
								new DispatcherServlet(this)
						).addMapping("/*")
				);
				webServer.start();
			}
		};

		// Configuration 이 붙은 구성 클래스를 등록
		applicationContext.register(BootApplication.class);
		applicationContext.refresh();
	}
}
