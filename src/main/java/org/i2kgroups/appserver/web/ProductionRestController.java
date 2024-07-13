package org.i2kgroups.appserver.web;

import org.i2kgroups.appserver.dtos.CategoryDTO;
import org.i2kgroups.appserver.dtos.ProductDTO;
import org.i2kgroups.appserver.dtos.RequestBodyDTO;
import org.i2kgroups.appserver.services.IAppInitDataService;
import org.i2kgroups.appserver.services.production.IProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
public class ProductionRestController {
	@Autowired
	private IProductionService iProductionService;
	
	@PostMapping(path ="/",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<ProductDTO> allCompanyProduct(@RequestBody RequestBodyDTO requestBody){
		PageRequest pageRequest = PageRequest.of( requestBody.getPage(),requestBody.getSize()); 
		
		Page<ProductDTO> productsDTO = iProductionService.allCompanyProduct(requestBody.getCompanyId(), pageRequest);
		return productsDTO;
	}
	@PostMapping(path ="/services/",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<ProductDTO> allCompanyService(@RequestBody RequestBodyDTO requestBody){
		PageRequest pageRequest = PageRequest.of( requestBody.getPage(),requestBody.getSize()); 
		
		Page<ProductDTO> productsDTO = iProductionService.allCompanyService(requestBody.getCompanyId(), pageRequest);
		return productsDTO;
	}
	@PostMapping(path ="/category/",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategoryDTO> allCompanyCategory(@RequestBody RequestBodyDTO requestBody){
		PageRequest pageRequest = PageRequest.of( requestBody.getPage(),requestBody.getSize()); 
		Page<CategoryDTO> categoriesDTO = iProductionService.allCategory(pageRequest);
		return categoriesDTO;
	}
	@PostMapping(path ="/search/",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<ProductDTO> searchCompanyProduct(@RequestBody RequestBodyDTO requestBody){
		PageRequest pageRequest = PageRequest.of( requestBody.getPage(),requestBody.getSize()); 
		Page<ProductDTO> productsDTO = iProductionService.findCompanyProduct(requestBody.getCompanyId(),requestBody.getSearch() ,pageRequest);
		return productsDTO;
	}
	@PostMapping(path ="/category/search",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategoryDTO> searchCompanyCategory(@RequestBody RequestBodyDTO requestBody){
		PageRequest pageRequest = PageRequest.of( requestBody.getPage(),requestBody.getSize()); 
		Page<CategoryDTO> categoriesDTO = iProductionService.findCompanyCategory(requestBody.getSearch(), pageRequest);
		return categoriesDTO;
	}
	
	@PutMapping(path ="/service/",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO addUpdateProduct(@RequestBody ProductDTO product){
		ProductDTO productsDTO = iProductionService.addUpdateProduct(product);
		return productsDTO;
	}
	@PutMapping(path ="/category/",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CategoryDTO addUpdateCategory(@RequestBody CategoryDTO category){
		CategoryDTO categoriesDTO = iProductionService.addUpdateCategory(category);
		return categoriesDTO;
	}
	@DeleteMapping(path ="/{id}")
	public boolean deleteProduct(@PathVariable(name = "id") long id) {
		return iProductionService.deleteProduct(id);
	}
	@DeleteMapping(path ="/category/{id}")
	public boolean deleteCategory(@PathVariable(name = "id") long id) {
		return iProductionService.deleteCategory(id);
	}

}
