package org.i2kgroups.appserver.repository;

import org.i2kgroups.appserver.entities.Dividend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DividendRepository extends JpaRepository<Dividend, Long> {

}
