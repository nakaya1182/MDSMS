package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemCustomerStatusRepository extends PagingAndSortingRepository<ItemCustomerStatusEntity, Integer>{
	@Query(value="SELECT o.id as id, o.customer_id as customer_id, o.s_number as s_number, o.title as title, o.quantity as quantity, o.quantity_unit as quantity_unit, o.order_date as order_date, o.delivery_date as delivery_date, o.due_date as due_date, o.billing_date as billing_date, o.estimated_amount as estimated_amount, o.order_amount as order_amount, o.status_id as status_id, o.note as note, o.created_at as created_at, o.updated_at as updated_at, o.deleted_at as deleted_at, c.customer_name as customer_name, s.name as name  FROM order_matter o JOIN customers c on o.customer_id = c.id JOIN statuses s on o.status_id = s.id WHERE o.deleted_at is null ORDER by o.customer_id  asc , s.display_order asc ",
			countQuery = "SELECT count(*) FROM order_matter o WHERE o.deleted_at is null",
			nativeQuery=true)
	Page<ItemCustomerStatusEntity> findAll(Pageable pageable);

	//Page<ItemCustomerStatusEntity> findByAddressContaining(Pageable pageable,String customerName);
}
