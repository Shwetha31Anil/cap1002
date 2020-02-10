package com.capgemini.training.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.training.daos.ProductDao;
import com.capgemini.training.model.Product;
import com.capgemini.training.util.DbUtil;

public class ProductDaoImpl implements ProductDao {
	
	Connection con=null;
	
	 public ProductDaoImpl() {
		con=DbUtil.createConnection();
	}

	@Override
	public List<Product> retriveProducts() {
		List<Product> products=new ArrayList<>();
		try {
			String sql="select * from product";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setQty(rs.getInt(3));
				p.setPrice(rs.getDouble(4));
				p.setBrand(rs.getString(5));
				products.add(p);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Product retriveProductById(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> retriveProductByBrand(String brand) {
		List<Product> products=new ArrayList<>();
		try {
			String sql="select * from product where brand=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, brand);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setQty(rs.getInt(3));
				p.setPrice(rs.getDouble(4));
				p.setBrand(rs.getString(5));
				products.add(p);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public void insertProduct(Product p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		try {
		String sql="update product set price=?, qty=? where pid=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setDouble(1, p.getPrice());
		pst.setInt(2, p.getQty());
		pst.setInt(3, p.getPid());
		pst.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteProduct(int pid) {
		// TODO Auto-generated method stub

try {
	String sql="delete from product where pid=?";
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setInt(1, pid);
	pst.executeQuery();
}catch(SQLException e) {
	e.printStackTrace();
}
	}

	@Override
	public List<Product> retriveProductByName(String pname) {
		List<Product> products=new ArrayList<>();
		try {
			String sql="select * from product where pname=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, pname);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setQty(rs.getInt(3));
				p.setPrice(rs.getDouble(4));
				p.setBrand(rs.getString(5));
				products.add(p);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<Product> retriveProductByPrice(double price) {
		List<Product> products=new ArrayList<>();
		try {
			String sql="select * from product where price=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setDouble(1, price);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setQty(rs.getInt(3));
				p.setPrice(rs.getDouble(4));
				p.setBrand(rs.getString(5));
				products.add(p);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

}
