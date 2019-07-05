package com.st.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.model.Product;
import com.st.repo.ProductRepository;
import com.st.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repo;
	
	@Override
	@Transactional
	public Integer saveProduct(Product p) {
		Product p1=repo.save(p);
		return p1.getId();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> getAllProduct() {
		return repo.findAll();
	}

	@Override
	@Transactional
	public void deleteProduct(int id) {
			repo.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Product getProductById(int id) {
		Optional<Product> op=repo.findById(id);
		return op.get();
	}

}
