package com.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class HelloController {
	@GetMapping("hello")
	public String Hello(Model model) {
		
		
		/*웹브라우저 = > localhost:8080/hello = > 내장톰캣서버  => helloController =>model 데이터 가공 - > 랜더링 될 html 문자열 리턴
		 * => 뷰리졸버가 화면을 찾음 (viewname 매핑) viewname + .html  
		 * 
		 * 
		 * 메이븐 빌드 = > 실행 방법 
		 * 
		 * 메이븐.jar 파일 생성 = > cmd jar 경로로이동 java -jar Stpe1-0.0.1-SNAPSHOT.jar 실행
		 * 
		 *	정적 컨텐츠 반환 순서 1. hello-static.html 관련 컨트롤러가 있는지 탐색 , 없으면 = > 정적html찾아보고 있으면 반환
		 *
		 *
		 *
		 *
		 *
		 *
		 *
		 */
		model.addAttribute("data","hello!!");
		return "hello";
	}
	
	@GetMapping("hello-mvc")
	public String hellMvc(@RequestParam("name") String  name, Model model) {// ?name= 값 model에 담 아 전송
		model.addAttribute("name", name);
		return "hello-template";
	}
	
	@GetMapping("hello-string")
	@ResponseBody
	public String helloString(@RequestParam("name") String name) {
		return "hello " +name;
	}
	
	
	@GetMapping("hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name) {
		
		
		/*
		 * Api 방식 :
		 * json 형태로 데이터를 내보낼때 
		 * @ResponseBody 혹은 @RestController 가있으면 Json방식으로 반환 해준다. 
		 * =>viewResolver 가 동작하지않고 HttpMessageConverter 가 동작하고 문자이면 StringConvertrt , 객체면 JsonConverter가 작동해서 
		 * Json으로 반환해준다 .
		 * 
		 * 
		 */
		Hello hello =new Hello();
		hello.setName(name);
		
		return hello;
		
	
	}
	
	static class Hello{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	
	
}
