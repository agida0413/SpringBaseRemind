package com.sist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Stpe1Application {
	//라이브러리
	//spring -boot -starter: 톰캣 내장
	//spring-webmvc: 스프링웹 mvc
	//공통 : 부트+코어+로깅
	public static void main(String[] args) {
		SpringApplication.run(Stpe1Application.class, args);
	}

}
