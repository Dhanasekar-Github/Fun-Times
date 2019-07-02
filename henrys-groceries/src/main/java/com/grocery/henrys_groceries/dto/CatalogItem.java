/**
 * 
 */
package com.grocery.henrys_groceries.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Dhanasekar Chandran
 * 
 */
@Data
@EqualsAndHashCode(of = {"id"})
public class CatalogItem {

	/**
	 * Id of the item.
	 */
	private String id;

	/**
	 * Description of the item.
	 */
	private String description;

	/**
	 * Description used on the ticket.
	 */
	private String ticketDescription;

	/**
	 * Price of the container for the item.
	 */
	private float price;
}
