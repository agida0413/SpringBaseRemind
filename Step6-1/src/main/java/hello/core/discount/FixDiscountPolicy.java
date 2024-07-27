package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

	
	private int discountFixAmout=1000;//1000원 할인 
	
	@Override
	public int discount(Member member, int price) {
		// TODO Auto-generated method stub
		
		if(member.getGrade()==Grade.VIP) {//ENUM ==
			return discountFixAmout;
		}else{
			return 0;
		}
		
	}

}
