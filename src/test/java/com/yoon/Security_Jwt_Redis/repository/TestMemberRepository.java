package com.yoon.Security_Jwt_Redis.repository;

import org.junit.jupiter.api.MethodOrderer; 
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;

import com.yoon.Security_Jwt_Redis.domain.Member;
import com.yoon.Security_Jwt_Redis.domain.Role;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@ActiveProfiles("test") //테스트에 적용할 설정파일 적용
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //테스트 순서 적용 어노테이션
public class TestMemberRepository {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	@Order(1)
	@Commit
	public void A001_사용자_등록() {
		//Given
		Member admin = Member.builder()
				.id("admin")
				.password(passwordEncoder.encode("admin"))
				.dname("admin 부서")
				.enabled(true)
				.role(Role.ROLE_ADMIN)
				.build();
		
		Member manager = Member.builder()
				.id("manager")
				.password(passwordEncoder.encode("manager"))
				.dname("manager 부서")
				.enabled(true)
				.role(Role.ROLE_MANAGER)
				.build();
		
		Member member = Member.builder()
				.id("member")
				.password(passwordEncoder.encode("member"))
				.dname("member 부서")
				.enabled(true)
				.role(Role.ROLE_MEMBER)
				.build();
		
		//When-Then
		memberRepository.save(admin);
		memberRepository.save(manager);
		memberRepository.save(member);
		
	}

}
