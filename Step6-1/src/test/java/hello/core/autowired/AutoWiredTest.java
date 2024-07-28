package hello.core.autowired;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Member;
import io.micrometer.common.lang.Nullable;

public class AutoWiredTest {

	
	@Test
	void AutowiredTest() {
		AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(TestBean.class);
		
	}
	
	static class TestBean {
		@Autowired(required = false) //메서드 자체가 호출이안됌 
		public void setNoBean1(Member noBean1) {
			System.out.println("nobeam="+noBean1);
		}
		
		@Autowired
		public void setNoBean2(@Nullable Member noBean2) { //호출은 되고 , null로 리턴된다 .
			System.out.println("nobeam="+noBean2);
		}
		
		@Autowired
		public void setNoBean2(Optional<Member> noBean3) {//Optional.empty 리턴 
			System.out.println("nobeam="+noBean3);
		}
		
	}
}
