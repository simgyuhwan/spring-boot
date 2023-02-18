package com.toby.boot;

//import org.springframework.boot.SpringApplication;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

//@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BootApplication.class, args);
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();

		// servlet 컨테이너를 만든다
		WebServer webServer = serverFactory.getWebServer();

		webServer.start();
	}

}
