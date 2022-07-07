package com.yoon.Security_Jwt_Redis.repository;

import org.springframework.data.repository.CrudRepository;

import com.yoon.Security_Jwt_Redis.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
