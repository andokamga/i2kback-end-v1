package org.i2kgroups.appserver.dtos;

import org.i2kgroups.appserver.enums.EnumAccounting;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AccountingDTO {

	private Long id;
	@NotBlank(message = "Accounting Number shouldn't be blank")
	@NotNull(message = "Accounting Number shouldn't be null")
	private int accountingNumber;
	@NotBlank(message = "Accounting name shouldn't be blank")
	@NotNull(message = "Accounting name shouldn't be null")
	@Size(min=3, max=50, message = "Accounting name must between 2 and 50 caracters")
	private String name;
	private EnumAccounting grouping;
	
}
