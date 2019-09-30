package com.example.demo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ItemCustomerStatusEntity {
	@Id
    private Integer id;
	private Integer customerId;
	private String sNumber;
	private String title;
	private Integer quantity;
	private String quantityUnit;
	private String orderDate;
	private String deliveryDate;
	private String dueDate;
	private String billingDate;
	private String estimatedAmount;
	private String orderAmount;
	private Integer statusId;
	private String note;
	private Date createdAt;
	private Date updatedAt;
	private Date deletedAt;

	private String 	customerName;
	private String name;
}
