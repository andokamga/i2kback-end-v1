package org.i2kgroups.appserver.dtos;

import java.util.List;

import org.i2kgroups.appserver.enums.EnumDevise;
import org.i2kgroups.appserver.enums.EnumTypeProduct;

import lombok.Data;

@Data
public class ProductDTO {

	private Long id;
	private Long companyId;
	private String name;
	private int quantity;
	private int remise;
	private int ristoune;
	private int rabais;
	private double minPrice;
	private double maxPrice;
	private boolean reduction;
	private boolean pubActive;
	private EnumTypeProduct type;
	private EnumDevise devise;
	private CategoryDTO categoryDTO;
	private ParagraphDTO paragraphDTO;
	private List<VisualDTO> visualsDTO;
}
