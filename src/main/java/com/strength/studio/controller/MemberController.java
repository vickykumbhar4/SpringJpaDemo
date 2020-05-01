package com.strength.studio.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.strength.studio.exception.ResourceNotFoundException;
import com.strength.studio.model.Member;
import com.strength.studio.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// u can see APIs on swagger-ui.html

@RestController
@RequestMapping("/api/v1/members")
@Api( value = "Member API Controller")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping
	public List<Member> getAllMembers() {
		return memberService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Member> getMemberById(@PathVariable(value = "id") Long memberId)
			throws ResourceNotFoundException {		
		return memberService.findById(memberId);
	}

	@PostMapping
	@ApiOperation( value = "Add new Member")
	public Member createMember(@RequestBody Member member) {
		return memberService.save(member);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Member> updateMember(@PathVariable(value = "id") Long memberId,
			 @RequestBody Member memberDetails) throws ResourceNotFoundException {		
		return memberService.update(memberId, memberDetails);
	}

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteMember(@PathVariable(value = "id") Long memberId)
			throws ResourceNotFoundException {
		return memberService.delete(memberId);		
	}
}
