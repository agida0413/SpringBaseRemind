package com.sist.scope;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class SingletonWithPrototypeTest1 {

	
	@Test
	void prototypeFind() {
		AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(prototypeBean.class);
		prototypeBean prototypeBean1 = ac.getBean(prototypeBean.class);
		prototypeBean1.addCount();
		assertThat(prototypeBean1.getCount()).isEqualTo(1);
		
		prototypeBean prototypeBean2 = ac.getBean(prototypeBean.class);
		prototypeBean2.addCount();
		assertThat(prototypeBean1.getCount()).isEqualTo(1);
	}
	
	@Scope("prototype")
	static class prototypeBean{
		private int count = 0;
		
		public void addCount() {
			count++;
		}
		
		public int getCount() {
			return count;
		}
		
		@PostConstruct
		public void init() {
			System.out.println("prototypeBean.init"+this);
		}
		
		@PreDestroy
		public void destroy() {
			System.out.println("prototypeBean.destory");
		}
	}
	
	@Test
	void singletonClientusePrototype() {
		AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(ClitenBean.class,prototypeBean.class);
		ClitenBean clientBean1 = ac.getBean(ClitenBean.class);
		int count1 = clientBean1.logic();
		assertThat(count1).isEqualTo(1);
		
		ClitenBean clientBean2 = ac.getBean(ClitenBean.class);
		int count2 = clientBean1.logic();
		assertThat(count2).isEqualTo(1);
	}
	
	static class ClitenBean{
		
		//싱글톤 빈이 프로토타입을 포함하 고 있을떄 
		
		//private final prototypeBean prototypebean; //생성시점에 주입 , 같은것을 사용 

			@Autowired
			private ObjectProvider<prototypeBean> provider;//DL DEPENDENCY LOOKCUP 을 도와줌 
			
			
		
		
		public int logic() {
			prototypeBean prototypebean = provider.getObject();//DL DEPENDENCY LOOKCUP 을 도와줌 
			prototypebean.addCount();
		return	prototypebean.getCount();
		}
		
		
		
	}
}
