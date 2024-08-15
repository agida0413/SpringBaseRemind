package com.sist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.domain.Member;
import com.sist.service.MemberService;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.RequestParam;


@Controller//component 스캔은 최상위 부트시작하는 com.sist. 폴더 하위에 있어야 빈 등록이 된다. 기본이 싱글톤
public class MemberController {

	private final MemberService memberService;
	
	@Autowired //di
	public MemberController(MemberService memberService) {
		
		this.memberService = memberService;
	}
	@GetMapping("/member/new")
	public String createForm() {
		return "members/createMemberForm";
	}
	
	@PostMapping("/members/new")
	public String create(MemberForm form) {
		Member member=new Member();
		member.setName(form.getName());
		
		memberService.join(member);
		
		return "redirect:/";
	}
	
	@GetMapping("/members")
	public String list(org.springframework.ui.Model model) {
		
		List<Member> list =memberService.findMembers();
		model.addAttribute("members",list);
		return "members/memberList";
	}
	
	
}
