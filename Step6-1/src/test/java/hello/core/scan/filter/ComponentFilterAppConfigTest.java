package hello.core.scan.filter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {

	@Test
	void filterScan() {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
	
	BeanA beanA = ac.getBean("BeanA",BeanA.class);
	
	assertThat(beanA).isNotNull();
	
BeanB beanB=	ac.getBean("BeanB",BeanB.class);
//등록안됌 (제외)
	}
	
	
	@Configuration
	@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = MyIncludeComponent.class),
				excludeFilters = @ComponentScan.Filter(type=FilterType.ANNOTATION,classes = MyExcludeComponent.class)
			)
	static class ComponentFilterAppConfig{
		
	}
}
