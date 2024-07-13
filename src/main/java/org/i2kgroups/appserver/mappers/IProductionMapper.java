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

public interface IProductionMapper {
	
	public ProductDTO productConvertToProductDTO(Product product);
	public CategoryDTO categoryConvertToCategoryDTO(Category category);
	public ItemProductDTO itemProductConvertToItemProductDTO(ItemProduct product);
	public ClientBillDTO clientBillConvertToClientBillDTO(ClientBill clientBill);
	public DailyReportDTO dailyReportConvertToDailyReportDTO(DailyReport dailyReport);
	public VisualDTO visualConvertToVisualDTO(Visual visual);
	public ParagraphDTO paragraphConvertToParagraphDTO(Paragraph paragraph);
	public Product productDTOConvertToProduct(ProductDTO productDTO);
	public Category categoryDTOConvertToCategory(CategoryDTO categoryDTO);
	public ItemProduct itemProductDTOConvertToItemProduct(ItemProductDTO productDTO);
	public ClientBill clientBillDTOConvertToClientBill(ClientBillDTO clientBillDTO);
	public DailyReport dailyReportDTOConvertToDailyReport(DailyReportDTO dailyReportDTO);
	public Visual visualDTOConvertToVisual(VisualDTO visualDTO);
	public Paragraph paragraphDTOConvertToParagraph(ParagraphDTO paragraphDTO);
	public TextDTO textConvertToTextDTO(Text text);
	public Text textDTOConvertToText(TextDTO textDTO);

}
