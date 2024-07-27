package hello.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicyTest {

	RateDiscountPolicy rateDiscountPolicy=new RateDiscountPolicy();
	
	@Test
	@DisplayName("VIP 10%할인")
	 void vip_o() {
	Member member=	new Member(1L, "memberVIP", Grade.VIP);
	int discount = rateDiscountPolicy.discount(member, 20000);
	
	Assertions.assertThat(discount).isEqualTo(2000);
	
	}
	@Test
	@DisplayName("VIP가 아니며 할인이 적용되지 않아야한다.")
	void vip_x() {
		Member member=	new Member(1L, "memberVIP", Grade.BASIC);
		int discount = rateDiscountPolicy.discount(member, 20000);
		
		Assertions.assertThat(discount).isEqualTo(0);
		
		}
	}

