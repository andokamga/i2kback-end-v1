package org.i2kgroups.appserver.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@Entity
@Data 
@AllArgsConstructor 
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue("ACTIONNAIRE")
@Builder
public class Actionnaire extends Partner {
	private int actionNb;
	private double TotalAmount;
	@Default
	@OneToMany(mappedBy = "Actionnaire",cascade = CascadeType.REMOVE)
	private List<Dividend> dividends = new ArrayList<>();
}
