package org.i2kgroups.appserver.repository;

import org.i2kgroups.appserver.entities.ClientBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientBillRepository extends JpaRepository<ClientBill, Long>{
	
	//Page<ClientBill> findByCompanyId(Long id, Pageable page);
	//Page<ClientBill> findByLastNameContainsOrPhoneNumberContains(String company,String lastName,String Phone,Pageable page);

}
