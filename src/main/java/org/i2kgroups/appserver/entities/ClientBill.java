package org.i2kgroups.appserver.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.i2kgroups.appserver.enums.EnumBillStatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class ClientBill {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long userId;
	private double price;
	private Date createAt;
	private Date paidAt;
	@Column(length =100)
	private String ref;
	@Column(length =50)
	private String company;
    @Enumerated(EnumType.STRING)
	private EnumBillStatus status;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Client client;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private DailyReport dailyReport;
	@Default
	@OneToMany(mappedBy = "clientBill",cascade = CascadeType.REMOVE)
	private List<ItemProduct> itemProduct = new ArrayList<>();

}
