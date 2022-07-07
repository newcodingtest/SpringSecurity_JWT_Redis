package com.yoon.Security_Jwt_Redis.config;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.yoon.Security_Jwt_Redis.domain.Member;
import com.yoon.Security_Jwt_Redis.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class UserDetailServiceImpl implements UserDetailsService{
	
	private final MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Member> user = memberRepository.findById(username);
		
		if(!user.isPresent()) {
			throw new UsernameNotFoundException("사용자 없음");
		}
		
		Member member = user.get();
		
		return new SecurityUser(member);
	}

}
