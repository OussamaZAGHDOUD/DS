package com.OZ.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter@NoArgsConstructor
public class User {
	@Id
	private Integer id;
	private String password;
	private String userName;
	private boolean active;
	@ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
	private List<Role> roles;
}
