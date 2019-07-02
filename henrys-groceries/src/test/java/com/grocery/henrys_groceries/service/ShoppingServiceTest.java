/**
 * 
 */
package com.grocery.henrys_groceries.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grocery.henrys_groceries.dto.Catalog;
import com.grocery.henrys_groceries.test.SpringTest;

/**
 * @author Dhanasekar Chandran
 * 
 */
public class ShoppingServiceTest extends SpringTest {

	static final Logger logger = Logger.getLogger(ShoppingService.class);

	/**
	 * Service to test
	 */
	@Autowired
	private ShoppingService service;

	/**
	 * Catalog
	 */
	@Autowired
	private Catalog catalog;
	
	/**
	 * It tests the initialization of the service
	 */
	@Test
	public void testService() {
		assertNotNull("service not initialised", service);
	}
	
	@Test
	public void testSimpleProcess1() throws Exception {
		service.setCatalog(catalog);
		List<String> ids = new LinkedList<String>();
		ids.add("Soup");
		ids.add("Soup");
		ids.add("Soup");
		ids.add("Bread");
		ids.add("Bread");
		float price = service.processShoppingList(ids);
		if (logger.isDebugEnabled()) {
			logger.debug("The price is " + price);
		}
		assertEquals("Expected Total price", 3.15, (double)price, 0.000001);
	}

	@Test
	public void testSimpleProcess2() throws Exception {
		service.setCatalog(catalog);
		List<String> ids = new LinkedList<String>();
		ids.add("Apple");
		ids.add("Apple");
		ids.add("Apple");
		ids.add("Apple");
		ids.add("Apple");
		ids.add("Apple");
		ids.add("Milk");
		float price = service.processShoppingList(ids);
		if (logger.isDebugEnabled()) {
			logger.debug("The price is " + price);
		}
		assertEquals("Unexpected total price", 1.90, (double)price, 0.000001);
	}
}
