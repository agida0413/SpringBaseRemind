package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {//구현객체 관리 ,설정 

	
	//Appconfig는 공연 기획자이다.
	/*
	 * 제어의 역전이란? 개발자가 코드를 호출하는것이 아니라 프레임워크가 담당한다 .
	 * 
	 * 기존 흐름(제어 )  : 개발자가 필요하면 객체를 생성하고 , 만든다 . 
	 * 제어의 역전 : 실행할 인터페이스는 호출하지만 그 인터페이스가 어떤 구현객체를 가질지 모른다. 
	 * OrderServiceImpl 즉 구현체는 OrderService의 구현체이고 전자는 자신 말고 다른 구현체로 대체될 가능성도 모른체 묵묵히 자신의 로직을 수행할 뿐이다.
	 * 
	 * 
	 * 프레임워크 :  내가 제어권이 없다 . 내가 작성한코드를 제어하고 실행한다 . 
	 * 라이브러리 :  내가 직접 제어와 흐름을 담당한다 .
	 * 
	 * 
	 * 
	 * ********DI***************
	 * 의존관계는 정적인 클래스 의존관계와 ,실행시점에 결정되는 동적인 객체의존관계 둘을 분리해서  생각
	 * 
	 * 
	 * 실행시점(런타임) 에 외부에서 실제구현객체를 생성하고 ,클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결되는것을 의존관계 주입이라고 한다 .
	 * 
	 * IOC 컨테이너 (DI컨테이너)
	 * AppConfig 처럼 객체를 생성하고 관리하면서 의존관계를 연결해준다 .
	 * 
	 * 
	 */
	@Bean
	public MemberService memberService() { //키
		return new MemberServiceImpl( memberRepository());//밸류 로 컨테이너에 등록 
	}
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(),discountPolicy());
	}
	@Bean
	public DiscountPolicy discountPolicy() {
		return new FixDiscountPolicy();
		//return new RateDiscountPolicy(); 갈아끼우기
	}
}
