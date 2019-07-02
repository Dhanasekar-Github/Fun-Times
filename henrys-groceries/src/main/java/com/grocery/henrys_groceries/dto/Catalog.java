/**
 * 
 */
package com.grocery.henrys_groceries.dto;

import java.util.Map;

import lombok.Data;

/**
 *
 * @author Dhanasekar Chandran
 * 
 */
@Data
public class Catalog {

	/**
	 * It contains the relationship of items available in the catalog, and the
	 * available containers, indexed by the id of the item.
	 */
	private Map<String, CatalogItem> availableItems;
}
