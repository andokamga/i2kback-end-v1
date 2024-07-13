package org.i2kgroups.appserver.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data 
public class CategoryDTO {

	private Long id;
	@NotNull(message = "Category Name shouldn't be null")
	@NotBlank(message = "Category Name shouldn't be blank")
	@Size(min=3, max=10, message = "Category must between 2 and 50 caracters")
	private String name;
}
