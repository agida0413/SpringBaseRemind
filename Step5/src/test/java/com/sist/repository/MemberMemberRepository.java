package com.sist.repository;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sist.domain.Member;
import com.sist.respository.MemberRepository;
import com.sist.respository.MemoryMemberRepository;

public class MemberMemberRepository {
MemoryMemberRepository repository= new MemoryMemberRepository();
@AfterEach
public void afterEach() {
	repository.clearstore();
	//테스트는 각각 의존관계없이 실행이 되어야한다.
	//하나의 테스트가 끝날떄마다 static 이나 공용데이터를 지워줘야한다.
}

@Test
public void save() {
	Member member=new Member();

	member.setName("spring");
	repository.save(member);
	
Member result=	repository.findById(member.getId()).get();
	

org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);

}

@Test
public void findByname() {
	Member member1 =new Member();
	member1.setName("spring1");
	repository.save(member1);
	
	Member member2=new Member();
	member2.setName("spring2");
	repository.save(member2);
	
	Member result=repository.findByName("spring1").get();
	assertThat(result).isEqualTo(member1);
}

@Test
public void findAll() {
	Member member1 =new Member();
	member1.setName("spring1");
	repository.save(member1);
	
	Member member2=new Member();
	member2.setName("spring2");
	repository.save(member2);
	
List<Member> result=	repository.findAll();
assertThat(result.size()).isEqualTo(2);

}



}
