package com.litmus7.retaildiscountsystem.customer;

import com.litmus7.retaildiscountsystem.discount.Discountable;

public class RegularCustomer implements Discountable {

	
	public double applyDiscount(double totalAmount) {
		
		return totalAmount - ( 0.05 * totalAmount );
	}

}
