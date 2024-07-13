package org.i2kgroups.appserver.repository;

import org.i2kgroups.appserver.entities.AccountingOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountingOperationRepository extends JpaRepository<AccountingOperation, Long>{

}
