package com.OZ.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Role {
	@Id
	private Integer id;
	@Column(unique = true)
	private String role;
	@ManyToMany
	@JoinTable(name = "role_user",
	joinColumns = {@JoinColumn(name="role_id")},
	inverseJoinColumns = {@JoinColumn(name="user_id")})
	private List<User> users;
}
