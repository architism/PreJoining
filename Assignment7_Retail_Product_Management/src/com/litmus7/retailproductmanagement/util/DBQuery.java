package com.litmus7.retailproductmanagement.util;

public class DBQuery {

	public static final String addProductQuery = "INSERT INTO Products(productId, name, category, price, stockQuantity)"
			+ "VALUES(?,?,?,?,?)";
	public static final String getProductByIdQuery = "SELECT productId, name, category, price, stockQuantity FROM Products WHERE productID = ? ";
	public static final String getAllProductsQuery = "SELECT productId, name, category, price, stockQuantity FROM Products";
	public static final String updateProductQuery = " UPDATE Products SET name = ?, category = ?, price=?, stockQuantity=? WHERE productId = ?";
	public static final String deleteProductQuery = "DELETE FROM Products WHERE productId = ? ";
	public static final String getProductByNameQuery = "SELECT productId, name, category, price, stockQuantity FROM Products WHERE name = ? ";

}
