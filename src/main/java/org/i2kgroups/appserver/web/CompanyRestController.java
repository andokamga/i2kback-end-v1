package org.i2kgroups.appserver.web;

import org.i2kgroups.appserver.services.production.IProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/Company")
public class CompanyRestController {

	@Autowired
	private IProductionService iProductionService;
}
