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
@DiscriminatorValue("EMPLOYE")
@Builder
public class Employe extends Partner{
	private int salary;
	private String category;
	private String work;
	@Default
	@OneToMany(mappedBy = "employe",cascade = CascadeType.REMOVE)
	private List<Paid> paids = new ArrayList<>();
}
