package com.example.demo;

import java.sql.Timestamp;

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
@Table(name="order_matter")
@Where(clause = " deleted_at is NULL")
public class ItemEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="customer_id")
	private Integer customerId;

	@Column(name="s_number")
	private String sNumber;

	@Column(name="title")
	private String title;

	@Column(name="quantity")
	private Integer quantity;

	@Column(name="quantity_unit")
	private String quantityUnit;

	@Column(name="order_date")
	private String orderDate;

	@Column(name="delivery_date")
	private String deliveryDate;

	@Column(name="due_date")
	private String dueDate;

	@Column(name="billing_date")
	private String billingDate;

	@Column(name="estimated_amount")
	private Integer estimatedAmount;

	@Column(name="order_amount")
	private Integer orderAmount;

	@Column(name="status_id")
	private Integer statusId;

	@Column(name="note")
	private String note;


	@Column(name="created_at")
	private Timestamp createdAt;



	@Column(name="updated_at")
	private Timestamp updatedAt;



	@Column(name="deleted_at")
	private Timestamp deletedAt;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
