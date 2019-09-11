package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Data
@Table(name="user")
@Where(clause = " flag = 0")
public class UserEntity {
	@Id

	@Column(name="employee_number")
	private Integer employee_number;

	@Column(name="name")
	private String name;

	@Column(name="birthday")
	private String birthday;

	@Column(name="sex")
	private String sex;

	@Column(name="mail_address")
	private String mail_address;

	@Column(name="address")
	private String address;

	@Column(name="tel")
	private String tel;

	@Column(name="flag")
	private String flag;

	public Integer getId() {
		return employee_number;
	}
	public void setId(Integer employee_number) {
		this.employee_number = employee_number;
	}
}
