package com.st.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
