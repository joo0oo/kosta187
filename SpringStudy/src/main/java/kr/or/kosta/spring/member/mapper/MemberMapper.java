package kr.or.kosta.spring.member.mapper;

import kr.or.kosta.spring.member.domain.Member;

public interface MemberMapper {
	
	public Member read(String userid);	

	/*
	<resultMap type="kr.or.kosta.spring.member.domain.Auth" id="authMap">
	
	<select id="read" resultMap="memberMap">
	*/
}
