package org.i2kgroups.appserver.repository;

import org.i2kgroups.appserver.entities.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
	
	Configuration findByActiveVersion(boolean active);
}
