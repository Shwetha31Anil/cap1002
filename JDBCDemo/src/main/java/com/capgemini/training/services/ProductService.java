package com.capgemini.training.services;

import java.util.List;

import com.capgemini.training.exceptions.BuissnessException;
import com.capgemini.training.model.Product;

public interface ProductService {
	public List<Product> retriveProducts()throws BuissnessException;
	public Product retriveProductById(int pid)throws BuissnessException;
	public List<Product> retriveProductByBrand(String brand)throws BuissnessException;
	public void insertProduct(Product p)throws BuissnessException;
	public void updateProduct(Product p)throws BuissnessException;
	public void deleteProduct(int pid)throws BuissnessException;
	public List<Product> retriveProductByName(String pname)throws BuissnessException;
	public List<Product> retriveProductByPrice(double price)throws BuissnessException;
	
}
