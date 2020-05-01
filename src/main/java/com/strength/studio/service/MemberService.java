package com.strength.studio.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.strength.studio.model.Member;
import com.strength.studio.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	public ResponseEntity<Member> findById(Long memberId) {
		Member member = memberRepository.findById(memberId)
				.orElseThrow(() -> new ResourceNotFoundException("Member not found for this id :: " + memberId));
		return ResponseEntity.ok().body(member);
	}

	public Member save(@Valid Member member) {
		return memberRepository.saveAndFlush(member);
	}

	public ResponseEntity<Member> update(Long memberId,@Valid Member memberDetails) {
//		Member member = memberRepository.findById(memberId)
//				.orElseThrow(() -> new ResourceNotFoundException("Member not found for this id :: " + memberId));

//		member.setEmailId(memberDetails.getEmail());
//		member.setLastName(memberDetails.getName());
//		member.setFirstName(memberDetails.getMobile());
		final Member updatedMember = memberRepository.save(memberDetails);
		return ResponseEntity.ok(updatedMember);
	}

	public Map<String, Boolean> delete(Long memberId) {
		Member member = memberRepository.findById(memberId)
				.orElseThrow(() -> new ResourceNotFoundException("Member not found for this id :: " + memberId));
		memberRepository.delete(member);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
