package com.grocery.henrys_groceries.service.discount;

import com.grocery.henrys_groceries.dto.CatalogItem;
import com.grocery.henrys_groceries.dto.Catalog;
import com.grocery.henrys_groceries.test.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @author Dhanasekar Chandran
 */
public class SingleTemporaryItemDiscountTest extends SpringTest {

	@Autowired
	private SingleTemporaryItemDiscount applesDiscount;

	@Autowired
	private Catalog catalog;

	@Test
	public void getValueReturnsDiscountOnBuyingApples() throws Exception {
		List<CatalogItem> basket = Arrays.asList("Apple").stream()
				.map(idItem -> catalog.getAvailableItems().get(idItem))
				.collect(Collectors.toList());
		assertEquals("Unexpected discount", 0.1, (double)applesDiscount.getValue(basket), 0.000001);
	}

	@Test
	public void getValueReturnsNoDiscountOnBuyingSomethingElse() throws Exception {
		List<CatalogItem> basket = Arrays.asList("Bread").stream()
				.map(idItem -> catalog.getAvailableItems().get(idItem))
				.collect(Collectors.toList());
		assertEquals("Unexpected discount", 0.0, (double)applesDiscount.getValue(basket), 0.000001);
	}
}