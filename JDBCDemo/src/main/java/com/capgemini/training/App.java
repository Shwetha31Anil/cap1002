package com.capgemini.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.capgemini.training.daos.CreateTable;
import com.capgemini.training.exceptions.BuissnessException;
import com.capgemini.training.model.Login;
import com.capgemini.training.model.Product;
import com.capgemini.training.serviceimpl.LoginServiceImpl;
import com.capgemini.training.serviceimpl.ProductServiceImpl;
import com.capgemini.training.services.LoginService;
import com.capgemini.training.services.ProductService;
import com.capgemini.training.util.DbUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws BuissnessException
    {
    	Scanner sc=new Scanner(System.in);
    	//CreateTable.tableCreate();
    	//CreateTable.tableCreate2();
    	System.out.println("Welcome to Cart App");
    	LoginService lService=new LoginServiceImpl();
    ProductService pServive=new ProductServiceImpl();
    	do {
    	System.out.println("1. Register \n 2. Login\n 3. Terminate");
    	
    	int choice= sc.nextInt();
    	if(choice==1) {
    		Login login=new Login();
    		System.out.println("enter user id");
    		login.setLid(sc.nextInt());
    		System.out.println("enter email");
    		login.setEmail(sc.next());
    		System.out.println("enter password");
    		login.setPass(sc.next());
    		System.out.println("enter role");
    		login.setRole(sc.next());
    		try {
				lService.addUser(login);
				System.out.println("registered Sucess");
			} catch (BuissnessException e) {
				System.out.println(e.getMessage());
			}
    	}else if(choice==2) {
    		System.out.println("Enter mail id");
    		String email=sc.next();
    		System.out.println("enter pass");
    		String pass=sc.next();
    		try {
				Login login=lService.loginUser(email, pass);
				System.out.println("welcome "+login.getEmail());
				if(login.getRole().equalsIgnoreCase("admin")) {
					do {
					System.out.println("1.Add Product \n 2.UpdateProduct"
							+ "\n 3.Delete Product \n 4.ListProducts \n"
							+ " 5. Logout");
					switch(sc.nextInt()) {
					case 1: System.out.println("enter product details");
						Product p=new Product();
						System.out.println("pid");
						p.setPid(sc.nextInt());
						System.out.println("pname");
						p.setPname(sc.next());
						System.out.println("qty");
						p.setQty(sc.nextInt());
						System.out.println("price");
						p.setPrice(sc.nextDouble());
						System.out.println("brand");
						p.setBrand(sc.next());
						pServive.insertProduct(p);
						System.out.println("product added");
				
					break;
					case 2:
						System.out.println("enter product id to update");
						Product product=pServive.retriveProductById(sc.nextInt());
						System.out.println("qty");
						product.setQty(sc.nextInt());
						System.out.println("price");
						product.setPrice(sc.nextDouble());
						pServive.updateProduct(product);
						System.out.println("product updated");
				
					break;
					case 3: System.out.println("enter the product id to delete the product");
						pServive.deleteProduct(sc.nextInt());
						System.out.println("Product deleted");
					break;
					case 4: System.out.println("List of products");
					List<Product> products=pServive.retriveProducts();
					products.forEach((p9)->System.out.println(p9.getPid()+" "+p9.getPname()+" "+p9.getPrice()+" "+p9.getQty()+" "+p9.getBrand()));
					break;
					case 5: System.out.println("Thank You"+login.getEmail());
					System.exit(0);
					
					default:System.out.println("invalid option");
				}
				}while(true);
				}else if(login.getRole().equalsIgnoreCase("customer")) {
					do {
					System.out.println("1. List Products\n "
							+ "2.Product By ID"
							+ "3.Product By Name "
							+ "4.Product By Price"
							+"5.Logout");
					switch(sc.nextInt()) {
					case 1:System.out.println("List of products");
					List<Product> products=pServive.retriveProducts();
					products.forEach((p9)->System.out.println(p9.getPid()+" "+p9.getPname()+" "+p9.getPrice()+" "+p9.getQty()+" "+p9.getBrand()));
					break;
					case 2:System.out.println("Enter product id");
					Product pro=pServive.retriveProductById(sc.nextInt());
					System.out.println(pro.getPid()+" "+pro.getPname()+" "+pro.getPrice()+" "+pro.getQty()+" "+pro.getBrand());
					break;
					case 3: System.out.println("Enter the name");
					List<Product> pnames=pServive.retriveProductByName(sc.next());
					pnames.forEach((p9)->System.out.println(p9.getPid()+" "+p9.getPname()+" "+p9.getPrice()+" "+p9.getQty()+" "+p9.getBrand()));
					break;
					case 4: System.out.println("enter the price");
					List<Product> productsByPrice=pServive.retriveProductByPrice(sc.nextDouble());
					productsByPrice.forEach((p9)->System.out.println(p9.getPid()+" "+p9.getPname()+" "+p9.getPrice()+" "+p9.getQty()+" "+p9.getBrand()));
					break;
					case 5: System.out.println("Thank you"+login.getEmail());
					System.exit(0);
					default: System.out.println("Invalid");
					}
					}while(true);
				}
			} catch (BuissnessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}else if(choice==3) {
    		System.exit(0);
    	}else {
    		System.out.println("enter the proper choice");
    	}
    	}while(true);
    	
    }
}
