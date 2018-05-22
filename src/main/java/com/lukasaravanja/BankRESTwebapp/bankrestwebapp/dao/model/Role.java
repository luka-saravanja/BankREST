package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = " role ")
@EntityListeners(AuditingEntityListener.class)
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id",updatable= false,nullable=false)
	private Long roleId;
	
	@Column(name = " name ")
	private String name;
	
	@ManyToMany(mappedBy ="roles")
	private Set<User> users;

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Long getRoleId() {
		return roleId;
	}

	public String getName() {
		return name;
	}

	@JsonIgnore
	public Set<User> getUsers() {
		return users;
	}
	
	
}
