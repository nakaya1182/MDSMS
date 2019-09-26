package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StatusCustomerEntity {
	@Id
    private Integer id;
	private String 	customerId;
	private String customerName;
	private String name;
	private String description;
	private String displayOrder;
	private Integer flag=0;
}
