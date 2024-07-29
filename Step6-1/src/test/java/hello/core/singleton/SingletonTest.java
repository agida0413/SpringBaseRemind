package hello.core.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;

public class SingletonTest {

	@Test
	@DisplayName("스프링 없는 순수di컨테이너 ")
	void pureContainer() {
		AppConfig appConfig =new AppConfig();
		
		MemberService memberService1 = appConfig.memberService();
		
		MemberService memberService2 = appConfig.memberService();
		
		System.out.println("memberservice1 = "+ memberService1);
		System.out.println("memberservice2 = "+memberService2);
		
		//계속 다른 인스턴스가 생성된다 = >메모리 낭비 
		
		//memberservice1 != memberservice2 
		Assertions.assertThat(memberService1).isNotSameAs(memberService2);
		
	}
	
	/*
	 * 싱글톤 패턴은 인스턴스가 1개만 생성되는 것을 보장한다 . 
	 * 
	 */
	
	
	@Test
	@DisplayName("싱글턴 패턴을 이용한 객체사용")
	void singleTontest() {
		
	SingletonService singletonService1=	SingletonService.getInstance();
	SingletonService singletonService2=	SingletonService.getInstance();
	
	System.out.println("memberservice1 = "+ singletonService1);
	System.out.println("memberservice2 = "+singletonService2);
	
	assertThat(singletonService1).isSameAs(singletonService2);
	//same   == 참조비교
	//equal  값비교 
	
	}
	
	
	
	
	
	
	@Test
	@DisplayName("스프링 컨테이너와 싱글톤")
	void SpringContainer() {
	//AppConfig appConfig =new AppConfig();
		AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService1 = ac.getBean("memberService",MemberService.class);
		
		MemberService memberService2 = ac.getBean("memberService",MemberService.class);
		
		System.out.println("memberservice1 = "+ memberService1);
		System.out.println("memberservice2 = "+memberService2);
		
		
		Assertions.assertThat(memberService1).isSameAs(memberService2);
	}
}
