package com.litmus7.retailproductmanagement.ui;

import java.util.List;
import java.util.Scanner;

import com.litmus7.retailproductmanagement.controller.ProductController;
import com.litmus7.retailproductmanagement.dto.Product;
import com.litmus7.retailproductmanagement.dto.Response;
import com.litmus7.retailproductmanagement.util.Constant;

public class ProductApp {

	public static void main(String args[]) {
		ProductController productController = new ProductController();
		int choice;
		int productId;
		String category;
		String name;
		Double price;
		int stockQuantity;

		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.print("Menu \n1. Add Product\n2. View Product By Id\n3. View All Products\n4. Update Product"
					+ "\n5. Delete Product\n6. Exit\n Enter Choice: ");

			choice = sc.nextInt();
			sc.nextLine();

			if (choice == 1) {
				System.out.println();
				System.out.print("Enter Product ID: ");
				productId = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Product Name: ");
				name = sc.nextLine();
				System.out.print("Enter Category: ");
				category = sc.nextLine();
				while (true) {
					System.out.print("Enter Price: ");
					price = sc.nextDouble();
					sc.nextLine();
					if (price < 0)
						System.out.println("Price cannot be negative.");
					else
						break;
				}
				while (true) {
					System.out.print("Enter Stock Quantity: ");
					stockQuantity = sc.nextInt();
					sc.nextLine();
					if (stockQuantity < 0)
						System.out.println("Stock Quantity cannot be negative.");
					else
						break;
				}

				Response<Product> response = productController
						.addProduct(new Product(productId, name, category, price, stockQuantity));
				if (response.getStatusCode() == Constant.SUCCESS_STATUS_CODE) {
					System.out.println(response.getResponseMessage());
					System.out.println(response.getResponseItem());
					System.out.println();
				} else {
					System.out.println(response.getResponseMessage());
					System.out.println();
				}

			}

			else if (choice == 2) {
				System.out.println();
				System.out.print("Enter Product ID to search : ");
				productId = sc.nextInt();
				sc.nextLine();
				Response<Product> response = productController.viewProductById(productId);
				if (response.getStatusCode() == Constant.SUCCESS_STATUS_CODE) {
					System.out.println(response.getResponseMessage());
					System.out.println("Product Details");
					System.out.println("ID : " + response.getResponseItem().getProductId());
					System.out.println("Name : " + response.getResponseItem().getName());
					System.out.println("Category : " + response.getResponseItem().getCategory());
					System.out.println("Price : " + response.getResponseItem().getPrice());
					System.out.println("Stock : " + response.getResponseItem().getStockQuantity());
					System.out.println();
				} else {
					System.out.println(response.getResponseMessage());
					System.out.println();
				}

			}

			else if (choice == 3) {
				System.out.println();
				Response<List<Product>> response = productController.viewAllProducts();
				if (response.getStatusCode() == Constant.SUCCESS_STATUS_CODE) {
					System.out.println(response.getResponseMessage());
					for (Product product : response.getResponseItem()) {
						System.out.println("ID : " + product.getProductId() + " | Name : " + product.getName()
								+ " | Category : " + product.getCategory() + " | Price : " + product.getPrice()
								+ " | Stock : " + product.getStockQuantity());

					}
					System.out.println();
				} else {
					System.out.println(response.getResponseMessage());
					System.out.println();
				}

			}

			else if (choice == 4) {
				System.out.println();
				System.out.print("Enter Product ID to update : ");
				productId = sc.nextInt();
				sc.nextLine();
				Response<Product> response = productController.viewProductById(productId);
				if (response.getStatusCode() == Constant.SUCCESS_STATUS_CODE) {

					System.out.print("Enter new name ( current :  " + response.getResponseItem().getName() + " ) : ");
					name = sc.nextLine();
					System.out.print(
							"Enter new category ( current :  " + response.getResponseItem().getCategory() + " ) : ");
					category = sc.nextLine();
					while (true) {
						System.out.print(
								"Enter new price ( current :  " + response.getResponseItem().getPrice() + " ) : ");
						price = sc.nextDouble();
						sc.nextLine();
						if (price < 0)
							System.out.println("Price cannot be negative.");
						else
							break;
					}
					while (true) {
						System.out.print("Enter new stock quantity ( current :  "
								+ response.getResponseItem().getStockQuantity() + " ) : ");
						stockQuantity = sc.nextInt();
						sc.nextLine();
						if (price < 0)
							System.out.println("Stock Quantity cannot be negative.");
						else
							break;
					}

					response = productController
							.updateProduct(new Product(productId, name, category, price, stockQuantity));
					if (response.getStatusCode() == Constant.SUCCESS_STATUS_CODE) {
						System.out.println(response.getResponseMessage());
						System.out.println("Updated Product Details");
						System.out.println("ID : " + response.getResponseItem().getProductId());
						System.out.println("Name : " + response.getResponseItem().getName());
						System.out.println("Category : " + response.getResponseItem().getCategory());
						System.out.println("Price : " + response.getResponseItem().getPrice());
						System.out.println("Stock : " + response.getResponseItem().getStockQuantity());
						System.out.println();
					} else {
						System.out.println(response.getResponseMessage());
					}

				} else {
					System.out.println(response.getResponseMessage() + " Update Failed.");
					System.out.println();
				}

			}

			else if (choice == 5) {
				System.out.println();
				System.out.print("Enter Product ID to delete : ");
				productId = sc.nextInt();
				sc.nextLine();
				Response response = productController.deleteProduct(productId);
				if (response.getStatusCode() == Constant.SUCCESS_STATUS_CODE) {
					System.out.println(response.getResponseMessage());
					System.out.println();

				} else {
					System.out.println(response.getResponseMessage());
					System.out.println();
				}

			}

			else if (choice == 6) {

				System.out.println("Thank you for using RetailMart Product Catalog Manager." + "Goodbye!");
				break;
			}

			else {
				System.out.println();
				System.out.println("Invalid Choice");
				System.out.println();
			}

		}

	}
}
