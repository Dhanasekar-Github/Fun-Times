/**
 * 
 */
package com.grocery.henrys_groceries.service.discount;

import com.grocery.henrys_groceries.dto.CatalogItem;

import java.util.List;

/**
 * @author Dhanasekar Chandran
 *
 */
public interface IDiscount {
	
	/**
	 * It returns the description.
	 * @return The description.
	 */
	public String getDescription();
	
	/**
	 * It returns the description to use in tickets.
	 * @return The description to use in tickets.
	 */
	public String getTicketDescription();
	
	/**
	 * It returns the discount to apply to a list of items.
	 * @param basket List of items.
	 * @return the amount to discount.
	 */
	public float getValue(List<CatalogItem> basket);
	
}
