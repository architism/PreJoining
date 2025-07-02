package com.litmus7.retaildiscountsystem.customer;

import com.litmus7.retaildiscountsystem.discount.Discountable;

public class PremiumCustomer implements Discountable {

	public double applyDiscount(double totalAmount) {

		if (totalAmount > 5000)
			return totalAmount - ( 0.1 * totalAmount );
		else
			return totalAmount - ( 0.07 * totalAmount );

	}

}
