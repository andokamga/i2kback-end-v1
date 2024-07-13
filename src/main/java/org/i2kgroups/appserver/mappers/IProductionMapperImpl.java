package org.i2kgroups.appserver.mappers;
import org.i2kgroups.appserver.dtos.CategoryDTO;
import org.i2kgroups.appserver.dtos.ClientBillDTO;
import org.i2kgroups.appserver.dtos.DailyReportDTO;
import org.i2kgroups.appserver.dtos.ItemProductDTO;
import org.i2kgroups.appserver.dtos.ParagraphDTO;
import org.i2kgroups.appserver.dtos.ProductDTO;
import org.i2kgroups.appserver.dtos.TextDTO;
import org.i2kgroups.appserver.dtos.VisualDTO;
import org.i2kgroups.appserver.entities.Category;
import org.i2kgroups.appserver.entities.ClientBill;
import org.i2kgroups.appserver.entities.DailyReport;
import org.i2kgroups.appserver.entities.ItemProduct;
import org.i2kgroups.appserver.entities.Paragraph;
import org.i2kgroups.appserver.entities.Product;
import org.i2kgroups.appserver.entities.Text;
import org.i2kgroups.appserver.entities.Visual;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class IProductionMapperImpl implements IProductionMapper {
	
	@Autowired
	public ModelMapper modelMapper;

	@Override
	public ProductDTO productConvertToProductDTO(Product product) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProductDTO productDTO = new ProductDTO();
		productDTO = modelMapper.map(product, ProductDTO.class);
		return productDTO;
	}
	
	@Override
	public CategoryDTO categoryConvertToCategoryDTO(Category category) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO = modelMapper.map(category, CategoryDTO.class);
		return categoryDTO;
	}

	@Override
	public ItemProductDTO itemProductConvertToItemProductDTO(ItemProduct product) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ItemProductDTO itemProductDTO= new ItemProductDTO();
		itemProductDTO = modelMapper.map(product, ItemProductDTO.class);
		return itemProductDTO;
	}

	@Override
	public ClientBillDTO clientBillConvertToClientBillDTO(ClientBill clientBill) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ClientBillDTO clientBillDTO= new ClientBillDTO();
		clientBillDTO = modelMapper.map(clientBill, ClientBillDTO.class);
		return clientBillDTO;
	}

	@Override
	public DailyReportDTO dailyReportConvertToDailyReportDTO(DailyReport dailyReport) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		DailyReportDTO dailyReportDTO= new DailyReportDTO();
		dailyReportDTO = modelMapper.map(dailyReport, DailyReportDTO.class);
		return dailyReportDTO;
	}

	@Override
	public VisualDTO visualConvertToVisualDTO(Visual visual) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		VisualDTO visualDTO= new VisualDTO();
		visualDTO = modelMapper.map(visual, VisualDTO.class);
		return visualDTO;
	}

	@Override
	public ParagraphDTO paragraphConvertToParagraphDTO(Paragraph paragraph) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ParagraphDTO paragraphDTO= new ParagraphDTO();
		paragraphDTO = modelMapper.map(paragraph, ParagraphDTO.class);
		return paragraphDTO;
	}

	@Override
	public Product productDTOConvertToProduct(ProductDTO productDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Product product = new Product();
		product = modelMapper.map(productDTO, Product.class);
		return product;
	}
	
	@Override
	public Category categoryDTOConvertToCategory(CategoryDTO categoryDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Category category = new Category();
		category = modelMapper.map(categoryDTO, Category.class);
		return category;
	}

	@Override
	public ItemProduct itemProductDTOConvertToItemProduct(ItemProductDTO productDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ItemProduct itemProduct= new ItemProduct();
		itemProduct = modelMapper.map(productDTO, ItemProduct.class);
		return itemProduct;
	}

	@Override
	public ClientBill clientBillDTOConvertToClientBill(ClientBillDTO clientBillDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ClientBill clientBill= new ClientBill();
		clientBill = modelMapper.map(clientBillDTO, ClientBill.class);
		return clientBill;
	}

	@Override
	public DailyReport dailyReportDTOConvertToDailyReport(DailyReportDTO dailyReportDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		DailyReport dailyReport= new DailyReport();
		dailyReport = modelMapper.map(dailyReportDTO, DailyReport.class);
		return dailyReport;
	}

	@Override
	public Visual visualDTOConvertToVisual(VisualDTO visualDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Visual visual= new Visual();
		visual = modelMapper.map(visualDTO, Visual.class);
		return visual;
	}

	@Override
	public Paragraph paragraphDTOConvertToParagraph(ParagraphDTO paragraphDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Paragraph paragraph= new Paragraph();
		paragraph = modelMapper.map(paragraphDTO, Paragraph.class);
		return paragraph;
	}

	@Override
	public TextDTO textConvertToTextDTO(Text text) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		TextDTO textDTO= new TextDTO();
		textDTO = modelMapper.map(text, TextDTO.class);
		return textDTO;
	}

	@Override
	public Text textDTOConvertToText(TextDTO textDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Text text= new Text();
		text = modelMapper.map(textDTO, Text.class);
		return text;
	}


}
