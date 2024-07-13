package org.i2kgroups.appserver.repository;

import java.util.List;

import org.i2kgroups.appserver.entities.Town;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TownRepository extends JpaRepository<Town, Long>{
	
	List<Town> findByLevel(int Number);
	List<Town> findByNameContains(String name);
}
