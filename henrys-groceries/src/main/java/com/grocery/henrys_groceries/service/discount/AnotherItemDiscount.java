/**
 * 
 */
package com.grocery.henrys_groceries.service.discount;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.grocery.henrys_groceries.dto.CatalogItem;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 *
 * @author Dhanasekar Chandran
 * 
 */
@Data
public class AnotherItemDiscount implements IDiscount {

	private static final Logger logger = Logger.getLogger(AnotherItemDiscount.class);

	/**
	 * The description
	 */
	private String description;

	/**
	 * The description to use in the ticket.
	 */
	private String ticketDescription;

	/**
	 * The item required to apply the discount.
	 */
	private CatalogItem itemRequired;

	/**
	 * The number of items required to apply the discount.
	 */
	private int numItemsRequired;

	/**
	 * The item to which applying the discount over.
	 */
	private CatalogItem itemDiscounted;

	/**
	 * The percentage of discount to apply.
	 */
	@Setter(AccessLevel.NONE)
	private double percentage;

	/**
	 * It sets the percentage of discount to apply.
	 * @param percentage The percentage to set
	 */
	public void setPercentage(double percentage) {
		this.percentage = percentage;
		assert ((percentage >= 0) && (percentage <= 100));
	}

	private long getTimesToApply(List<CatalogItem> basket) {
		long numItemsFound = basket.stream().filter(item -> item.equals(itemRequired)).count();
		return numItemsFound / numItemsRequired;
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public float getValue(List<CatalogItem> basket) {
		long numTimesDiscount = getTimesToApply(basket);

		List<CatalogItem> itemsToDiscount = basket.stream()
				.filter(item -> item.equals(itemDiscounted))
				.limit(numTimesDiscount).collect(Collectors.toList());

		float discount = (float) itemsToDiscount.stream()
				.mapToDouble(item -> item.getPrice() * percentage / 100)
				.sum();

		if (logger.isDebugEnabled()) {
			logger.debug("Discount over items " + itemDiscounted.getId() + " is "
					+ discount);
		}
		return discount;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTicketDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
