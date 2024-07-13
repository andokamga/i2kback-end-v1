package org.i2kgroups.appserver.repository;

import java.util.List;

import org.i2kgroups.appserver.entities.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>{
	
	List<Review> findByCompanyId(Long id);
	List<Review>findByCompanyIdAndLast(Long id,boolean last);

}
