package com.mtc.app.repsitory;

import java.util.List;

import com.mtc.app.entity.Product;

public interface IProductRepository {
	
	public boolean add(Product product);
	public Product find(int id);
	public List<Product> findAll();

}
