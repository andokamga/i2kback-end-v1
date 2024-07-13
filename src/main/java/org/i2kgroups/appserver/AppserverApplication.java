package org.i2kgroups.appserver;

import org.i2kgroups.appserver.services.IAppInitDataService;
import org.i2kgroups.appserver.services.production.IProductionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AppserverApplication implements CommandLineRunner{
	@Autowired
	private IAppInitDataService iAppInitDataService;
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(AppserverApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//PageRequest pageRequest = PageRequest.of( 0,20);
		iAppInitDataService.initTown();
		iAppInitDataService.initCompany();
		iAppInitDataService.initRole();
		iAppInitDataService.initUser();
		iAppInitDataService.initCategory();
		iAppInitDataService.initProduct();
		iAppInitDataService.initAccounting();
		iAppInitDataService.initDailyReport();
		iAppInitDataService.initOpration();
		iAppInitDataService.initBalance();
		iAppInitDataService.initReview();
		iAppInitDataService.initUpateReview();
		iAppInitDataService.initActionnaire();
		iAppInitDataService.initEmploye();
		iAppInitDataService.initModification();
		
	}
	

}
