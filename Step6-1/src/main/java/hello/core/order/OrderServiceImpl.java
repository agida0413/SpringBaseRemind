package hello.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy; 
	
//	@Autowired
//	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//		super();
//		this.memberRepository = memberRepository;
//		this.discountPolicy = discountPolicy;
//	}
	// 추상클래스에만 의존하므로 dip 성립 ,하지만 인터페이스 구현체가 생성되지않으므로 여전히 문제 
	//해결방안 
	// 누군가가 클라이언트인 orderserviceImpl에 discountPolicy 구현객체를 대신생성해주고 주입해주어야 한다 .
	
//	private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
	//private final DiscountPolicy discountPolicy = new FixDiscountPolicyy();
	/*
	 * 문제점 
	 * 할인정책을 변경하려면 orderserviceimpl을 고쳐야한다 . (new)
	 * DIP, OCP 위반 
	 * 추상의존: DiscountPolicy
	 * 구체 클래스 :  fixdiscountpoli... , rated....
	 * 
	 * orderserviceImpl 이 discountpolicy 뿐만아니라 fixdiscountpolicy도 의존하고있다. (DIP 위반 항상 추상에 의존하라 )
	 *  = > 구현체를 갈아끼우려면 orderserviceImPL 의 코드도 변경해야한다 .(OCP 위반)
	 *  
	 *  로미오와 줄리엣 공연을 한다고 하면 각각의 배우의 역할을 인터페이스라고 보고 , 줄리엣역할에 특정배우( xx) , 로미오 역할에 레오나르도 디카프리오를 구현체라고 볼수있다 .
	 *  우리가 new를 통한 생성은 책임자인 개발자가 직접 배우를 섭외하는 것과 같다 . 그렇게 되면 할 일이 너무 많아진다 . 그렇기 떄문에 기획자라는 역할이 필요하고 책임자와 기획자의 역할을 분리해야한다 . 
	 *  
	 * 
	 */
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		// TODO Auto-generated method stub
		
		Member member= memberRepository.findById(memberId);
		int discountPrice =discountPolicy.discount(member, itemPrice);
		
		
		return new Order(memberId,itemName,itemPrice,discountPrice);
	}
	
	
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}
