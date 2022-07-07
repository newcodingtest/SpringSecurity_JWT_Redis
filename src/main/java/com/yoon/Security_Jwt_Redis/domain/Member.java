package com.yoon.Security_Jwt_Redis.domain;

import java.io.Serializable;

import javax.persistence.Column;
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
@Table(name="loginmember")
@NoArgsConstructor
@AllArgsConstructor(access= AccessLevel.PRIVATE)
@Builder
public class Member{

	@Id
	@Column(nullable=false)
	private String id;
	
	@Column
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	@Column
	private boolean enabled;
	@Column
	private String dname;
	
}
