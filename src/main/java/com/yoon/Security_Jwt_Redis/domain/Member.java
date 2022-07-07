package com.yoon.Security_Jwt_Redis.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Entity
@Table(name="member")
@NoArgsConstructor
@AllArgsConstructor(access= AccessLevel.PRIVATE)
@Builder
public class Member implements Serializable {

	@Id
	private String id;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private boolean enabled;
	
	private String dname;
	
}
