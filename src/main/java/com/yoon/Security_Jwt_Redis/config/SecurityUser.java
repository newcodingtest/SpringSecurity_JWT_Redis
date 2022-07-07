package com.yoon.Security_Jwt_Redis.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.yoon.Security_Jwt_Redis.domain.Member;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SecurityUser extends User {

	private String dname;
	private Member member;
	
	public SecurityUser(Member member) {
		super(member.getId(), member.getPassword(), AuthorityUtils.createAuthorityList( member.getRole().toString()));
		
		this.member = member;
	}

}
