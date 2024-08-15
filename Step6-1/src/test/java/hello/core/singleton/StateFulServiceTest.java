package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class StateFulServiceTest {

	@Test
	void stateFulServiceSingleton() {
		AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(TestConfig.class);
StateFulService stateFulService1 = ac.getBean(StateFulService.class);
StateFulService stateFulService2 =ac.getBean(StateFulService.class);

	//Thread1 : A사용자 10000원 주문 
int userAprice = stateFulService1.order("userA", 10000);
//Thread2 : B사용자 20000원 주문 
int userAprice2 =  stateFulService1.order("userB", 20000); // 인스턴스를 공유하기 때문에 값이 바뀐다 .
		

//Thread A : 사용자 A주문 금액 조회 


System.out.println("price="+userAprice);//기대값 :10000 결과값 :20000



	}
	
	
	@Configuration
	static class TestConfig {
		
		@Bean
		public StateFulService stateFulService() {
			return new StateFulService();
		}
	}
}
