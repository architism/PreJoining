package com.litmus7.retaildiscountsystem.ui;

import java.util.Scanner;

import com.litmus7.retaildiscountsystem.controller.RetailDiscountController;
import com.litmus7.retaildiscountsystem.customer.PremiumCustomer;
import com.litmus7.retaildiscountsystem.customer.RegularCustomer;
import com.litmus7.retaildiscountsystem.customer.WholesaleCustomer;
import com.litmus7.retaildiscountsystem.discount.Discountable;

public class RetailStoreApp {
	
	
	
	public static void main(String args[]) {
		
		RetailDiscountController retailDiscountController = new RetailDiscountController();

		Discountable customer = null;
		

		System.out.print("Enter customer type (1- Regular, 2- Premium, 3- Wholesale): ");
		Scanner sc = new Scanner(System.in);

		int customerType = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter total purchase amount: ");

		double totalAmount = sc.nextDouble();
		sc.nextLine();

		double payableAmount = 0;

		switch (customerType) {

		case 1: {
			customer = new RegularCustomer();
			payableAmount = retailDiscountController.getDiscountedAmount(totalAmount, customer);
			break;
		}
		case 2: {
			customer = new PremiumCustomer();
			payableAmount = retailDiscountController.getDiscountedAmount(totalAmount, customer);
			break;
		}
		case 3: {
			customer = new WholesaleCustomer();
			payableAmount = retailDiscountController.getDiscountedAmount(totalAmount, customer);
			break;
		}
		default:
			System.out.println("Invalid Customer Type.");

		}

		if (customer != null) {
			System.out.println();
			System.out.println("Customer Type: " + customer.getClass().getSimpleName());
			System.out.println("Original Amount: " + totalAmount);
			System.out.println("Discount Applied: " + (totalAmount - payableAmount));
			System.out.println("Final Payable Amount: " + payableAmount);
		}

		sc.close();
	}

}
