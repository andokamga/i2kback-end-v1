package org.i2kgroups.appserver.dtos;

import java.util.Date;
import java.util.List;

import org.i2kgroups.appserver.enums.EnumBillStatus;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClientBillDTO {

	private Long id;
	@NotBlank(message = "role Id shouldn't be blank")
	@Min(value = 0,message = "user Id must be positive")
	@NotNull(message = "user Id shouldn't be null")
	private Long userId;
	private double price;
	private Date createAt;
	private Date paidAt;
	private String ref;
	private String company;
	private EnumBillStatus status;
	private List<ItemProductDTO> itemProductDTO;
}
