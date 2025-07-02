package com.litmus7.retaildiscountsystem.customer;

import com.litmus7.retaildiscountsystem.discount.Discountable;

public class WholesaleCustomer implements Discountable {

	public double applyDiscount(double totalAmount) {

		if (totalAmount > 10000)
			return totalAmount - ( 0.15 * totalAmount );
		else
			return totalAmount - ( 0.1 * totalAmount );
	}

}
