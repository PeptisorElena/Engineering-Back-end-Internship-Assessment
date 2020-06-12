package io.application;

import java.util.List;
import java.security.Principal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Catalog {

	@Autowired
	private CatalogService catalogService;
	
	/*
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	*/
	
	
	
	@RequestMapping("/catalog")
	public List<Product> getAll() {
		return catalogService.getAll();
	}
	
	
	//getRequest
	@RequestMapping("/catalog/product/{id}")
	public Product getProductFromCatalog(@PathVariable int id) {
		return catalogService.getProduct(id);
	}
	
	//postRequest
	@RequestMapping(method=RequestMethod.POST, value="/catalog")
	public void addProductToCatalog(@RequestBody Product product) {
		catalogService.addProduct(product);
	}
	
	//putRequest
	@RequestMapping(method=RequestMethod.PUT, value="/catalog/{id}")
	public void updateProductFromCatalog(@RequestBody Product product,@PathVariable int id) {
		catalogService.updateProduct(id,product);
	}
	
	//deleteRequest
		@RequestMapping(method=RequestMethod.DELETE, value="/catalog/{id}")
		public void deleteProductFromCatalog(@PathVariable int id) {
			catalogService.deleteProduct(id);
		}
	
}

