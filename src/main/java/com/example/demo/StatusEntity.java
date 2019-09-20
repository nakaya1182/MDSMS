package com.example.demo;

import java.io.Serializable;

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
@Table(name="statuses")
@Where(clause = " flag = 0")
public class StatusEntity implements Serializable{
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="customer_id")
	private String 	customerId;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="display_order")
	private String displayOrder;
	@Column(name="flag")
	private Integer flag=0;
}
