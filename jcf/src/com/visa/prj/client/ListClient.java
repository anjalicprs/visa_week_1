package com.visa.prj.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.visa.prj.entity.Product;

public class ListClient {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(645,"Hp Laptop",135000.00,"computer",100));
		products.add(new Product(224,"iPhone",98000.00,"mobile",500));
		products.add(new Product(834,"Logitech Mouse",600.00,"computer",300));
		products.add(new Product(5,"Sony Bravia",125000.00,"tv",900));
		products.add(new Product(912,"One Plus",32000.00,"mobile",100));
		products.add(new Product(88,"HP Printer",19000.00,"computer",100));
		
		Collections.sort(products, (p1, p2)->(int)p1.getPrice()-(int)p2.getPrice());
		//or
		Collections.sort(products, (p1, p2)->Double.compare(p1.getPrice(), p2.getPrice()));
		
		/*
		 * Traverse
		 */
		
		Iterator<Product> iter = products.iterator();
//		Iterator<Product> iter2 = products.iterator();
//		System.out.println("********");
//		System.out.println(iter2.next());
		//If we add new product here then that will throw
		//concurrentModification error as it locks the products arrayList
		//So products.add(p) will fail here
		while(iter.hasNext()) {
			Product p = iter.next();
			System.out.println(p);
		}
		//Avoid this loop
		for(int i=0;i<products.size();i++) {
			Product p=products.get(i);
			System.out.println(p);
		}
		for (Product product : products) {
			System.out.println(product);
		}
		System.out.println("*************");
		List<Product> list = new CopyOnWriteArrayList<>(products); //Read it properly
		Iterator<Product> iter3 = list.iterator();
		while(iter3.hasNext()) {
			list.add(new Product());
			Product p=iter3.next();
			System.out.println(p);
		}
		System.out.println(list.size());
	}

}
