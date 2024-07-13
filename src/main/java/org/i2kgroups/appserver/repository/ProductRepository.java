package org.i2kgroups.appserver.repository;

import java.util.List;

import org.i2kgroups.appserver.entities.Product;
import org.i2kgroups.appserver.enums.EnumTypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByCompanyIdAndType(Long id, EnumTypeProduct type);
	List<Product> findByCompanyIdAndNameContains(Long id, String name);

}
