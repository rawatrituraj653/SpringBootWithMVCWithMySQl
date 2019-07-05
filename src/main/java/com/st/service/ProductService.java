package com.st.service;

import java.util.List;

import com.st.model.Product;

public interface ProductService {
	
	public abstract Integer saveProduct(Product p);
	public abstract List<Product> getAllProduct();
	public abstract void deleteProduct(int id);
	public abstract Product getProductById(int id);
	
}
