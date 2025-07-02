package com.litmus7.retaildiscountsystem.controller;

import com.litmus7.retaildiscountsystem.discount.Discountable;

public class RetailDiscountController {

	public double getDiscountedAmount(double totalAmount, Discountable customer) {

		return customer.applyDiscount(totalAmount);

	}
}
