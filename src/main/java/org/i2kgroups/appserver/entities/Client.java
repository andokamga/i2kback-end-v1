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
@DiscriminatorValue("CLIENT")
@Builder
public class Client extends Partner {
	private boolean loyal; 
	@Default
	@OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE)
	private List<ClientBill> clientBill = new ArrayList<>();
}
