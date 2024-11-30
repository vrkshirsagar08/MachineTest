package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;


@Service
public class ProductServiceImp implements ProductService {
	 @Autowired
	    private ProductRepository productRepository;

	 @Override
	    public Page<Product> getAllProducts(Pageable pageable) {
	        return productRepository.findAll(pageable);
	    }


	    @Override
	    public Product getProductById(Long id) {
	        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	    }

	    @Override
	    public Product createProduct(Product product) {
	        return productRepository.save(product);
	    }

	    @Override
	    public Product updateProduct(Long id, Product product) {
	        Product existingProduct = getProductById(id);
	        existingProduct.setName(product.getName());
	        existingProduct.setPrice(product.getPrice());
	        existingProduct.setCategory(product.getCategory());
	        return productRepository.save(existingProduct);
	    }

	    @Override
	    public void deleteProduct(Long id) {
	        productRepository.deleteById(id);
	    }
}
