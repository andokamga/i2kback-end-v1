package org.i2kgroups.appserver.repository;

import java.util.List;

import org.i2kgroups.appserver.entities.DailyReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyReportRepository extends JpaRepository<DailyReport, Long>{
	
	List<DailyReport> findByCompanyId(Long id);
	List<DailyReport>findByCompanyIdAndSendReport(Long id,boolean report);

}
