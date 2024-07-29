package hello.core.singleton;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fasterxml.jackson.databind.introspect.AnnotatedAndMetadata;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;

public class ConfiGurationTest {

	
	@Test
	void configurationTest() {
		AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberServiceImpl memberServiceImpl = ac.getBean("memberService",MemberServiceImpl.class);
		OrderServiceImpl orderServiceImpl =ac.getBean("orderService",OrderServiceImpl.class);
		
		MemberRepository memberRepository3 = ac.getBean("memberRepository",MemberRepository.class);
		MemberRepository memberRepository = memberServiceImpl.getNMemberRepository();
		MemberRepository memberRepository2 = orderServiceImpl.getMemberRepository();
		
		System.out.println("memberService - > memberRepository="+memberRepository);
		System.out.println("orderService - > memberRepository= "+memberRepository2);
		System.out.println("memberRespository="+memberRepository3);
		
	}
	
	@Test
	void configurationDeep() {
		AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
AppConfig bean=		ac.getBean(AppConfig.class);
		System.out.println("bean="+bean.getClass());
		//bean=class hello.core.AppConfig$$SpringCGLIB$$0
		
		//내가만든클래스가 아니라 스프링이 Cglib라는 바이트 코드조작 라이브러리를 사용해서 AppConfig를 상속받은 임의의 다른 클래스를 만들고 그 다른 클래스를 스프링빈으로 등록한것이다 .
		
		//에를 들어 appconfig를 상속받은 AppConfig@CGLIB는 메서드들을 오버라이드 해서 이미 컨테이너에 있으면 그 빈을 반환하고 없 으면 기존로직을 호출해서 스프링컨테이너에 등록할 것이다 .
		
		
	}
}
