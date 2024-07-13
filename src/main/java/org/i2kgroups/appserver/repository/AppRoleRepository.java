package org.i2kgroups.appserver.repository;

import java.util.List;

import org.i2kgroups.appserver.entities.AppRole;
import org.i2kgroups.appserver.enums.EnumRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long>{
	
	Page<AppRole> findBy(Pageable page);
	List<AppRole> findByNameContains(String name);

}
