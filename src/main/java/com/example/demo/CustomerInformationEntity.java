package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Data
@Table(name="customers")
@Where(clause = " flag = 0")
public class CustomerInformationEntity {
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="customer_name")
	private String 	customerName;
	@Column(name="industry")
	private String industry;
	@Column(name="representative")
	private String representative;
	@Column(name="address")
	private String address;
	@Column(name="tel")
	private String 	tel;
	@Column(name="	fax_number")
	private String 	fax_number;
	@Column(name="flag")
	private Integer flag=0;
}
