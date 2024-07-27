package com.sist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sist.AOP.TimeTraceAop;
import com.sist.respository.MemberRepository;
import com.sist.respository.MemoryMemberRepository;
import com.sist.service.MemberService;

@Configuration
public class SpringConfig {
// 
	@Bean
	public MemberService memberService() {
	
		return new MemberService(memberRepository());
	
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
//	@Bean
//	public TimeTraceAop timeTraceAop() {
//		return new TimeTraceAop();
//	}
//	
}
