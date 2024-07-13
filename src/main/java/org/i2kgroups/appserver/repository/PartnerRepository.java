package org.i2kgroups.appserver.repository;

import org.springframework.data.domain.Pageable;

import java.util.List;

import org.i2kgroups.appserver.entities.Client;
import org.i2kgroups.appserver.entities.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
	List<Client> findByCompanyIdAndLastNameContainsOrPhoneNumberContains(Long id, String lastName,String Phone,Pageable page);
	List<Partner> findByCompanyId(Long id);
}
