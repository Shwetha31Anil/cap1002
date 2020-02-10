package com.capgemini.training.serviceimpl;

import java.util.List;

import com.capgemini.training.daoimpl.ProductDaoImpl;
import com.capgemini.training.daos.ProductDao;
import com.capgemini.training.exceptions.BuissnessException;
import com.capgemini.training.model.Product;
import com.capgemini.training.services.ProductService;

public class ProductServiceImpl implements ProductService {

	ProductDao productDao;
	 public ProductServiceImpl() {
		productDao=new ProductDaoImpl();
	}
	
	@Override
	public List<Product> retriveProducts() throws BuissnessException {
		// TODO Auto-generated method stub
		List<Product> products=productDao.retriveProducts();
		if(!products.isEmpty()) {
			return products;
		}else {
			throw new BuissnessException("No products available");
		}
		
	}

	@Override
	public Product retriveProductById(int pid) throws BuissnessException {
		// TODO Auto-generated method stub
		return productDao.retriveProductById(pid);
	}

	@Override
	public List<Product> retriveProductByBrand(String brand) throws BuissnessException {
		// TODO Auto-generated method stub
		if(brand.matches("[a-zA-Z]{4,12}")) {
			List<Product> products=productDao.retriveProductByBrand(brand);
			if(!products.isEmpty()) {
				return products;
			}else {
				throw new BuissnessException("no products fro this brand");
		}
		}else {
			throw new BuissnessException("Brand is invalid");
		}
	}

	@Override
	public void insertProduct(Product p) throws BuissnessException {
		// TODO Auto-generated method stub
		if(p.getPid()>=10 && p.getPid()<=99) {
			if(p.getPname().matches("[a-zA-Z]{3,10}")) {
				if(p.getBrand().matches("[a-zA-Z]{4,12}")) {

					if(p.getQty()> 0) {
						if(p.getPrice()>1000) {
							productDao.insertProduct(p);					
						}else {
							throw new BuissnessException("price greater than 1000");
						}
					}else {
						throw new BuissnessException("only positive numbers");
					}
				}else {
					throw new BuissnessException("only letters and min 4 and max 12 charecters");
				}
			}else {
				throw new BuissnessException("only letters and min 3 and max 10 charecters");
			}
		}else {
			throw new BuissnessException("only two digits");
		}
		
	}

	@Override
	public void updateProduct(Product p) throws BuissnessException {
		// TODO Auto-generated method stub
		productDao.updateProduct(p);
	}

	@Override
	public void deleteProduct(int pid) throws BuissnessException {
		// TODO Auto-generated method stub
		productDao.deleteProduct(pid);
	}

	@Override
	public List<Product> retriveProductByName(String pname) throws BuissnessException {
		// TODO Auto-generated method stub
		return productDao.retriveProductByName(pname);
	}

	@Override
	public List<Product> retriveProductByPrice(double price) throws BuissnessException {
		// TODO Auto-generated method stub
		return productDao.retriveProductByPrice(price);
	}

}
