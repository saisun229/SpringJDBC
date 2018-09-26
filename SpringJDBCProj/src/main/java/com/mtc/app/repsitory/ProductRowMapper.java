package com.mtc.app.repsitory;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mtc.app.entity.Product;

public class ProductRowMapper implements RowMapper<Product>{

	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Product product = new Product();
		
		product.setId(rs.getInt("id"));
		product.setDescription(rs.getString("description"));
		product.setName(rs.getString("name"));
		product.setQuantity(rs.getInt("quantity"));
		product.setPrice(rs.getInt("price"));
		
		
		
		return product;
	}
	
}
