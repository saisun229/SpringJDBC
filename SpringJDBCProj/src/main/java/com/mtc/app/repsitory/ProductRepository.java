package com.mtc.app.repsitory;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.mtc.app.entity.Product;

@Repository
public class ProductRepository implements IProductRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
/*	public boolean add(Product product) {
		
		String insertQuery = "insert into test.product(id,description,name,quantity,price) values(?,?,?,?,?)";
		
		int noOfRecords = jdbcTemplate.update(insertQuery,product.getId(),product.getDescription(),product.getName(),product.getQuantity(),product.getPrice());
		
		if(noOfRecords == 1) {
			return true;
		}		
		
		return false;
	}*/
	
	public boolean addProduct(Product product) {
		
		String insertQuery = "insert into test.product(id,description,name,quantity,price) values(:id,:description,:name,:quantity,:price)";
		
		SqlParameterSource  parameterSource = new BeanPropertySqlParameterSource(product);
		
		int noOfRecords = namedParameterJdbcTemplate.update(insertQuery, parameterSource);
		
		if(noOfRecords == 1) {
			return true;
		}		
		
		return false;
	}
	
	
   @Override
   	public List<Product> findAll() {
   		
	   String selectQuery = "select * from test.product";
	   
	   List<Product> products = jdbcTemplate.query(selectQuery, Product::mapProduct);
	   
   		return products;
   	}	
	
	public Product find(int id) {
		
		String selectQuery = "select * from test.product where id=?";
		
//		RowMapper<Product> rowMapper = (ResultSet rs,int rowNo) -> {
//			
//			Product product = new Product();
//			
//			product.setId(rs.getInt("id"));
//			product.setName(rs.getString("name"));
//			product.setPrice(rs.getFloat("price"));
//			product.setDescription(rs.getString("description"));
//			product.setQuantity(rs.getInt("quantity"));
//			
//			return product;
//		
//		};
		
		Product  product = jdbcTemplate.queryForObject(selectQuery, Product::mapProduct, id);
		
		return product;
	}
	
	


}
