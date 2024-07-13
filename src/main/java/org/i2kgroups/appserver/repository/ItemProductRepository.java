package org.i2kgroups.appserver.repository;

import org.i2kgroups.appserver.entities.ItemProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemProductRepository extends JpaRepository<ItemProduct, Long>{

	//Page<ItemProduct> findByCompanyId(Long id, Pageable page);
}
