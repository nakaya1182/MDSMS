package com.example.demo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface StatusRepository extends PagingAndSortingRepository<StatusEntity, String>{
	Page<StatusEntity> findAll(Pageable pageable);
	List<StatusEntity> findAll();
	StatusEntity findById(Integer id);

	List<StatusEntity> findByCustomerId(Integer customerId);

	void save(List<StatusEntity> statusEntity);

	@Modifying
	@Query(value="UPDATE statuses SET display_order =  null WHERE  customer_id = :customerId", nativeQuery=true)
	void SortReset(@Param("customerId")Integer customerId);

	@Modifying
	@Query(value="UPDATE statuses SET display_order =  :i WHERE  id = :id", nativeQuery=true)
	void Sorting(@Param("id")Integer id, @Param("i")int i);
}
