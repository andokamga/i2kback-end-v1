package org.i2kgroups.appserver.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@Entity 
@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class DailyReport {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long companyId;
	private Long userId;
	private Date createAt;
	private boolean sendReport;
	private double totaux;
	private double creance;
	@Default
	@OneToMany(mappedBy = "dailyReport",cascade = CascadeType.REMOVE)
	private List<ItemProduct> itemProducts = new ArrayList<>();
	@Default
	@OneToMany(mappedBy = "dailyReport",cascade = CascadeType.REMOVE)
	private List< ClientBill> clientBills = new ArrayList<>();

}
