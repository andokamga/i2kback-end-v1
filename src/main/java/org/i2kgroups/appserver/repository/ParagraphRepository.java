package org.i2kgroups.appserver.repository;

import java.util.List;

import org.i2kgroups.appserver.entities.Paragraph;
import org.i2kgroups.appserver.entities.Product;
import org.i2kgroups.appserver.entities.paragraphList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParagraphRepository extends JpaRepository<Paragraph, Long>{
	Paragraph findByProductAndLevel(Product product, int level);
	List<Paragraph> findByParagraphAndLevel(Paragraph paragraph, int level);
	List<Paragraph> findByProductId(Long id);
	List<Paragraph> findByCompanyId(Long id);
}
