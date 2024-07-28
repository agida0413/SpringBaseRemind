package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
	
	@Autowired// 의존주입 
	public MemberServiceImpl(MemberRepository memberRepository) {
		super();
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(Member member) {
		// TODO Auto-generated method stub
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		// TODO Auto-generated method stub
		return memberRepository.findById(memberId);
	}
	
	//테스트 용도 
	
	public MemberRepository getNMemberRepository() {
		return memberRepository;
	}

}
