package org.i2kgroups.appserver.repository;

import java.util.List;

import org.i2kgroups.appserver.entities.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long>{
	
	Page<AppUser> findBy(Pageable page);
	AppUser findByUsername(String username);
	AppUser findByEmail(String email);
	AppUser findByPhoneNumber(String Phone);
	AppUser findByUsernameOrEmailOrPhoneNumber(String username,String email,String Phone);
	List<AppUser> findByUsernameContainsOrEmailContainsOrPhoneNumberContains(String username,String email,String Phone,Pageable page);

}
