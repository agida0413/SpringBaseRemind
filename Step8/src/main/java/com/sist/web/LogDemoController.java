package com.sist.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sist.common.MyLogger;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

	private final LogDemoService logDemoService;
	//private final MyLogger myLogger; //myLogger를 스프링 시작시에 주입 받아야하는데 scope가 request이므로 고객요청이 없기때문에 오류가난다.
	//DL :  시작시에 주입받는게아니라 찾는것 ObjectProvider
	private final MyLogger myLogger;// provider가 동작하는거 처럼  proxyMode = ScopedProxyMode.TARGET_CLASS 를 해주면 기존 의존성 주입시 값이 없어 오류가 나는 부분을 프록시 껍데기를 컨테이너에 넣어주고 실제 요청이 있을떄 주입을 해준다.
	//지연 처리 .... http요청이 있을때 까지 버틴다 .
	
	@RequestMapping("log-demo")
	@ResponseBody
	public String logDem(HttpServletRequest request) {
		
	String requestUrl=	request.getRequestURL().toString();
	myLogger.setRequsetUrl(requestUrl);
	
	myLogger.log("controller test");
	logDemoService.logic("testId");
	
	return "OK";
	
	}
}
