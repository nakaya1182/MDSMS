package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ItemCustomerStatusRepository extends PagingAndSortingRepository<ItemCustomerStatusEntity, Integer>{
	@Query(value="SELECT o.id as id, o.customer_id as customer_id, o.s_number as s_number, o.title as title, o.quantity as quantity, o.quantity_unit as quantity_unit, o.order_date as order_date, o.delivery_date as delivery_date, o.due_date as due_date, o.billing_date as billing_date, o.estimated_amount as estimated_amount, o.order_amount as order_amount, o.status_id as status_id, o.note as note, o.created_at as created_at, o.updated_at as updated_at, o.deleted_at as deleted_at, c.customer_name as customer_name, s.name as name  FROM order_matter o JOIN customers c on o.customer_id = c.id JOIN statuses s on o.status_id = s.id WHERE o.deleted_at is null ORDER by o.customer_id  asc , s.display_order asc ",
			countQuery = "SELECT count(*) FROM order_matter o WHERE o.deleted_at is null",
			nativeQuery=true)
	Page<ItemCustomerStatusEntity> findAll(Pageable pageable);

	@Query(value="SELECT o.id as id, o.customer_id as customer_id, o.s_number as s_number, o.title as title, o.quantity as quantity, o.quantity_unit as quantity_unit, o.order_date as order_date, o.delivery_date as delivery_date, o.due_date as due_date, o.billing_date as billing_date, o.estimated_amount as estimated_amount, o.order_amount as order_amount, o.status_id as status_id, o.note as note, o.created_at as created_at, o.updated_at as updated_at, o.deleted_at as deleted_at, c.customer_name as customer_name, s.name as name  FROM order_matter o JOIN customers c on o.customer_id = c.id JOIN statuses s on o.status_id = s.id WHERE o.deleted_at is null and o.customer_id = :customerId and o.status_id = :statusId AND o.title LIKE %:Search%  ORDER by o.customer_id  asc , s.display_order asc ",
			countQuery = "SELECT o.id as id, o.customer_id as customer_id, o.s_number as s_number, o.title as title, o.quantity as quantity, o.quantity_unit as quantity_unit, o.order_date as order_date, o.delivery_date as delivery_date, o.due_date as due_date, o.billing_date as billing_date, o.estimated_amount as estimated_amount, o.order_amount as order_amount, o.status_id as status_id, o.note as note, o.created_at as created_at, o.updated_at as updated_at, o.deleted_at as deleted_at, c.customer_name as customer_name, s.name as name  FROM order_matter o JOIN customers c on o.customer_id = c.id JOIN statuses s on o.status_id = s.id WHERE o.deleted_at is null and o.customer_id = :customerId and o.status_id = :statusId AND o.title LIKE %:Search%  ORDER by o.customer_id  asc , s.display_order asc",
			nativeQuery=true)
	Page<ItemCustomerStatusEntity> searchCS(Pageable pageable,@Param("Search")String Search,@Param("customerId")Integer customerId, @Param("statusId")Integer statusId);

	@Query(value="SELECT o.id as id, o.customer_id as customer_id, o.s_number as s_number, o.title as title, o.quantity as quantity, o.quantity_unit as quantity_unit, o.order_date as order_date, o.delivery_date as delivery_date, o.due_date as due_date, o.billing_date as billing_date, o.estimated_amount as estimated_amount, o.order_amount as order_amount, o.status_id as status_id, o.note as note, o.created_at as created_at, o.updated_at as updated_at, o.deleted_at as deleted_at, c.customer_name as customer_name, s.name as name  FROM order_matter o JOIN customers c on o.customer_id = c.id JOIN statuses s on o.status_id = s.id WHERE o.deleted_at is null and o.customer_id = :customerId AND o.title LIKE %:Search%  ORDER by o.customer_id  asc , s.display_order asc ",
			countQuery = "SELECT o.id as id, o.customer_id as customer_id, o.s_number as s_number, o.title as title, o.quantity as quantity, o.quantity_unit as quantity_unit, o.order_date as order_date, o.delivery_date as delivery_date, o.due_date as due_date, o.billing_date as billing_date, o.estimated_amount as estimated_amount, o.order_amount as order_amount, o.status_id as status_id, o.note as note, o.created_at as created_at, o.updated_at as updated_at, o.deleted_at as deleted_at, c.customer_name as customer_name, s.name as name  FROM order_matter o JOIN customers c on o.customer_id = c.id JOIN statuses s on o.status_id = s.id WHERE o.deleted_at is null and o.customer_id = :customerId AND o.title LIKE %:Search%  ORDER by o.customer_id  asc , s.display_order asc",
			nativeQuery=true)
	Page<ItemCustomerStatusEntity> searchC(Pageable pageable,@Param("Search")String Search,@Param("customerId")Integer customerId);

	@Query(value="SELECT o.id as id, o.customer_id as customer_id, o.s_number as s_number, o.title as title, o.quantity as quantity, o.quantity_unit as quantity_unit, o.order_date as order_date, o.delivery_date as delivery_date, o.due_date as due_date, o.billing_date as billing_date, o.estimated_amount as estimated_amount, o.order_amount as order_amount, o.status_id as status_id, o.note as note, o.created_at as created_at, o.updated_at as updated_at, o.deleted_at as deleted_at, c.customer_name as customer_name, s.name as name  FROM order_matter o JOIN customers c on o.customer_id = c.id JOIN statuses s on o.status_id = s.id WHERE o.deleted_at is null and o.status_id = :statusId AND o.title LIKE %:Search%  ORDER by o.customer_id  asc , s.display_order asc ",
			countQuery = "SELECT o.id as id, o.customer_id as customer_id, o.s_number as s_number, o.title as title, o.quantity as quantity, o.quantity_unit as quantity_unit, o.order_date as order_date, o.delivery_date as delivery_date, o.due_date as due_date, o.billing_date as billing_date, o.estimated_amount as estimated_amount, o.order_amount as order_amount, o.status_id as status_id, o.note as note, o.created_at as created_at, o.updated_at as updated_at, o.deleted_at as deleted_at, c.customer_name as customer_name, s.name as name  FROM order_matter o JOIN customers c on o.customer_id = c.id JOIN statuses s on o.status_id = s.id WHERE o.deleted_at is null and o.status_id = :statusId AND o.title LIKE %:Search%  ORDER by o.customer_id  asc , s.display_order asc",
			nativeQuery=true)
	Page<ItemCustomerStatusEntity> searchS(Pageable pageable,@Param("Search")String Search, @Param("statusId")Integer statusId);

	@Query(value="SELECT o.id as id, o.customer_id as customer_id, o.s_number as s_number, o.title as title, o.quantity as quantity, o.quantity_unit as quantity_unit, o.order_date as order_date, o.delivery_date as delivery_date, o.due_date as due_date, o.billing_date as billing_date, o.estimated_amount as estimated_amount, o.order_amount as order_amount, o.status_id as status_id, o.note as note, o.created_at as created_at, o.updated_at as updated_at, o.deleted_at as deleted_at, c.customer_name as customer_name, s.name as name  FROM order_matter o JOIN customers c on o.customer_id = c.id JOIN statuses s on o.status_id = s.id WHERE o.deleted_at is null  AND o.title LIKE %:Search%  ORDER by o.customer_id  asc , s.display_order asc ",
			countQuery = "SELECT o.id as id, o.customer_id as customer_id, o.s_number as s_number, o.title as title, o.quantity as quantity, o.quantity_unit as quantity_unit, o.order_date as order_date, o.delivery_date as delivery_date, o.due_date as due_date, o.billing_date as billing_date, o.estimated_amount as estimated_amount, o.order_amount as order_amount, o.status_id as status_id, o.note as note, o.created_at as created_at, o.updated_at as updated_at, o.deleted_at as deleted_at, c.customer_name as customer_name, s.name as name  FROM order_matter o JOIN customers c on o.customer_id = c.id JOIN statuses s on o.status_id = s.id WHERE o.deleted_at is null AND o.title LIKE %:Search%  ORDER by o.customer_id  asc , s.display_order asc",
			nativeQuery=true)
	Page<ItemCustomerStatusEntity> search(Pageable pageable,@Param("Search")String Search);


}
