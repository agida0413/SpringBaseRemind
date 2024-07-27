package com.sist.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sist.domain.Member;
import com.sist.respository.MemoryMemberRepository;

class MemberServiceTest {
MemberService memberService;
MemoryMemberRepository memberRepository;

@BeforeEach
public void beforeEach() {
	memberRepository=new MemoryMemberRepository();
	memberService=new MemberService(memberRepository);
}
@AfterEach
public void clear() {
	memberRepository.clearstore();
}
	
	@Test
	void 회원가입() {
		//given
		Member member=new Member();
		member.setName("hello");
		
		//when
		Long saveId= memberService.join(member);
		
		
		//then
		Member findMember=memberService.findOne(saveId).get();
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
		
		
	}
	@Test
	public void 중복회원예외() {
		//given 
		Member m1=new Member();
		m1.setName("spring");
		Member m2=new Member();
		m2.setName("spring");
		//when
		memberService.join(m1);
	IllegalStateException e=assertThrows(IllegalStateException.class, ()->memberService.join(m2));
	assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
	
//		try {
//			memberService.join(m2);
//			fail();
//		} catch (Exception e) {
//			// TODO: handle exception
//		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//		}
		
		//then
	}
	@Test
	void testFindMembers() {
		
	}

	@Test
	void testFindOne() {
		
	}

}
