package com.test.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.test.backend.entity.Product;
import com.test.backend.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository repo;

	public ProductService(ProductRepository repo) {
		this.repo = repo;
	}

	public List<Product> findAll() {
		return repo.findAll();
	}

	public Optional<Product> findById(Long id) {
		return repo.findById(id);
	}

	public Product save(Product p) {
		return repo.save(p);
	}

	public Product update(Long id, Product p) {
		p.setId(id);
		return repo.save(p);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}