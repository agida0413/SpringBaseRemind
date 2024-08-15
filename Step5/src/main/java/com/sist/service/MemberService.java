package com.sist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.domain.Member;
import com.sist.respository.MemberRepository;
import com.sist.respository.MemoryMemberRepository;
//@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	//@Autowired
	public MemberService(MemberRepository memberRepository) {
		
		this.memberRepository = memberRepository;
	}
<<<<<<< HEAD
	
	

	public Long join(Member member) {
		
		long start = System.currentTimeMillis();//로그 기록은 핵심로직이아니다 .
		//공통 관심사항이다 . 공통관심사항 = crosscutting  핵심관심사항 = core concern
		
		try {
			validateDuplicateMember(member);//중복회원 검증 
			memberRepository.save(member);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			long finish = System.currentTimeMillis();
			long timeMs=finish-start;
			System.out.println("join="+timeMs+"ms");
			}
		
		return member.getId();
		//같은 이름이 있는 중복 회원 불가 
		
	}
	
	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName()).
		ifPresent(m->{
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}
	
	/**
	 * 전체회원조회
	 * 
	 * 
	 */
	public List<Member> findMembers(){
		long start= System.currentTimeMillis();
		
	try {
		
		return	memberRepository.findAll();
	} finally {
		long finish=System.currentTimeMillis();
		System.out.println(finish-start +"ms");
	}
		
	 
=======

	public Long join(Member member) {
		//같은 이름이 있는 중복 회원 불가 
		validateDuplicateMember(member);//중복회원 검증 
		memberRepository.save(member);
		return member.getId();
	}
	
	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName()).
		ifPresent(m->{
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}
	
	/**
	 * 전체회원조회
	 * 
	 * 
	 */
	public List<Member> findMembers(){
	 return	memberRepository.findAll();
>>>>>>> refs/remotes/origin/master
	}
	
	public Optional<Member> findOne(Long memberId){
		return memberRepository.findById(memberId);
	}
	
}
