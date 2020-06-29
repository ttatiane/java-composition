package com.org.java.composition.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.org.java.composition.entities.Client;
import com.org.java.composition.entities.Order;
import com.org.java.composition.entities.OrderItem;
import com.org.java.composition.entities.Product;
import com.org.java.composition.entities.enums.OrderStatus;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());  
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus orderStatus =  OrderStatus.valueOf(sc.next());
		
		Order od1 = new Order(new Date(), orderStatus, client);
		
		System.out.print("How many items to this order? ");
		int quantity = sc.nextInt();
		
		for (int i = 0; i < quantity; i++) {
			System.out.println("Enter #" + (i + 1) + " item data:");
			sc.nextLine();
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer orderItemQuantity = sc.nextInt(); 
			
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(orderItemQuantity, productPrice, product);
			od1.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(od1);
		
		sc.close();
	}

}
