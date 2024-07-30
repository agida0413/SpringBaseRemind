package com.sist.common;

import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope(value="request",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

	private String uuid;
	private String requestUrl; 
	
	public void setRequsetUrl(String requestUrl) {
		this.requestUrl = requestUrl;
		
	}
	
	public void log(String message) {
		System.out.println("["+ uuid+"]"+"["+requestUrl+"]"+"["+message+"]");
	
	
	}

@PostConstruct
public void init() {
	uuid=UUID.randomUUID().toString();
	System.out.println("["+ uuid+"] request scope bean create "+this);

}

@PreDestroy
public void close() {
	System.out.println("["+ uuid+"] request scope bean close "+this);
}
}
