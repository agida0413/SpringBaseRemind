package com.sist.respository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;import javax.sound.midi.Sequence;

import com.sist.domain.Member;

public class MemoryMemberRepository implements MemberRepository{

	public static Map<Long, Member> store=new HashMap<>();
	private static Long squence =0L;
	
	
	@Override
	public Member save(Member member) {
		// TODO Auto-generated method stub
		member.setId(++squence);
		store.put(member.getId(), member);
		
		return member; 
	}

	@Override
	public Optional<Member> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public Optional<Member> findByName(String name) {
		// TODO Auto-generated method stub
		
		
		
		return store.values().stream()
				.filter(member ->member.getName().equals(name))
				.findAny();
	}

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
	
		
		return new ArrayList<>(store.values());
	}
	
	public void clearstore() {
		store.clear();
	}

}
