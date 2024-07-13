package org.i2kgroups.appserver.entities;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 16)
public abstract class Partner {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Long companyId;
	@Column(length =20)
	private String countyCode;
	@Column(length =50,nullable = false)
	private String phoneNumber;
	@Column(length =50)
    private String email;
	@Column(length =50,nullable = false)
	private String firstName;
	@Column(length =50,nullable = false)
	private String lastName;
	private boolean active;
}
