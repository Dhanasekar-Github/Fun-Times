/**
 * 
 */
package com.grocery.henrys_groceries.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.grocery.henrys_groceries.service.ItemsException;
import com.grocery.henrys_groceries.service.ShoppingService;

/**
 * @author Dhanasekar Chandran
 * 
 */
public class HenrysGrocery {

	private static final Logger logger = Logger.getLogger(ShoppingService.class);

	private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
			new String[] {"ApplicationContext.xml"});

	/**
	 * It calculates the price of the basket.
	 * @param args The args are the ids of the items of the catalog.
	 */
	public static void main(String[] args) {

		// This is used to get the item count and items through command prompt.
		Scanner itemCount=new Scanner (System.in);
		System.out.println("Please enter the items count:");
		int Count = itemCount.nextInt();
		Scanner in=new Scanner (System.in);
        String items[]=new String[Count];
        System.out.println("Please enter the items:");
        for (int i = 0; i < Count; i++)
        {
        	items[i] = in.next();
        }
		
		ShoppingService service = appContext.getBean("service", ShoppingService.class);
		if ((items.length == 0) || "--help".equals(items[0])) {
			System.out.println("Usage HenrysGrocery lis_of_ids");
			System.out.println("list_of_ids is a list of ids of items of the catalog, separated by spaces.");
			System.out.println("Available ids are: " + String.join(", ",
					service.getCatalog().getAvailableItems().keySet().toArray(new String[0])));
		} else {
			List<String> ids = Arrays.asList(items);
			try {
				service.processShoppingList(ids);
			} catch (ItemsException ie) {
				logger.error("Error in arguments " + ie);
				System.err.println(ie.toString());
			}
		}
	}
}
