package com.futureengineers.restapi.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

//	private String login;
//	private String email;
//	private String password;
//	private String type;
}
