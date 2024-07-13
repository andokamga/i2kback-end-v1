package org.i2kgroups.appserver.repository;

import java.util.List;

import org.i2kgroups.appserver.entities.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long>{
	
	Page<Company> findBy(Pageable page);
	List<Company> findByNameContains(String name);

}
