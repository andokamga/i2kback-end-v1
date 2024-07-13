package org.i2kgroups.appserver.repository;

import java.util.List;

import org.i2kgroups.appserver.entities.Balance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, Long>{
	
	List<Balance> findByCompanyId(Long id);
	List<Balance>findByCompanyIdAndSendReview(Long id,Boolean balance);

}
