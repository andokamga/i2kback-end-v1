package org.i2kgroups.appserver.repository;

import java.util.List;

import org.i2kgroups.appserver.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {

	List<Operation> findByCompanyId(Long id);
	List<Operation>findByCompanyIdAndSendOperation(Long id,boolean operation);
}
