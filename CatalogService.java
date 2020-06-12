package io.application;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CatalogService {

	
	List<Product> products = Arrays.asList(
			new Product(1,"product1", "category1", "01.02.2020", "02.02.2020"),
			new Product(2,"product2", "category2", "02.02.2020", "03.02.2020"));

	
	public List<Product> getAll() {
		return products;
	}
	
	
	
	public Product getProduct(int id) {
		return products.stream().filter(p -> p.getId()==id).findFirst().get();
	}

	public void addProduct(Product product) {
		products.add(product);
		
	}

	public void updateProduct(int id, Product product) {
		for (int i = 0; i<products.size(); i++) {
			Product p = products.get(i);
			if(p.getId()==id) {
				products.set(i, product);
				return;
			}
		}
		
	}

	public void deleteProduct(int id) {
		products.removeIf(p -> p.getId()==id);
		
	}

	
}
