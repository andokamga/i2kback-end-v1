package org.i2kgroups.appserver.repository;


import org.i2kgroups.appserver.entities.Accounting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AccountingRepository extends JpaRepository<Accounting, Long>{
	
	Accounting findByAccountingNumber(int Number);

}
