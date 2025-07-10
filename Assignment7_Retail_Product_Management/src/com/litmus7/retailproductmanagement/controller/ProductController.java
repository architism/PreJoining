package com.litmus7.retailproductmanagement.controller;

import java.util.List;

import com.litmus7.retailproductmanagement.dto.Product;
import com.litmus7.retailproductmanagement.dto.Response;
import com.litmus7.retailproductmanagement.exception.DatabaseEmptyException;
import com.litmus7.retailproductmanagement.exception.ProductAlreadyExistsException;
import com.litmus7.retailproductmanagement.exception.ProductNotFoundException;
import com.litmus7.retailproductmanagement.exception.ProductServiceException;
import com.litmus7.retailproductmanagement.service.ProductService;
import com.litmus7.retailproductmanagement.util.Constant;

public class ProductController {
	private ProductService productService = new ProductService();

	public Response<Product> addProduct(Product product) {

		if (product == null) {
			return new Response<Product>(Constant.ERROR_STATUS_CODE, "Empty product cannot be inserted");
		}

		try {
			Product addedProduct = productService.addProduct(product);
			return new Response<Product>(Constant.SUCCESS_STATUS_CODE, "Product added successfully!!", addedProduct);

		} catch (ProductServiceException e) {
			return new Response<Product>(Constant.ERROR_STATUS_CODE, "Product could not be added.");

		} catch (ProductAlreadyExistsException e) {
			return new Response<Product>(Constant.ERROR_STATUS_CODE, "Product already exists in catalog.");

		} catch (Exception e) {
			return new Response<Product>(Constant.ERROR_STATUS_CODE, "An error occured.");
		}
	}

	public Response<Product> viewProductById(int productId) {
		try {
			Product foundProduct = productService.getProductById(productId);
			return new Response<Product>(Constant.SUCCESS_STATUS_CODE, "Product found!!", foundProduct);

		} catch (ProductNotFoundException e) {
			return new Response<Product>(Constant.ERROR_STATUS_CODE, "Product with ID " + productId + " not found.");
		} catch (ProductServiceException e) {
			return new Response<Product>(Constant.ERROR_STATUS_CODE, "Product could not be searched.");
		} catch (Exception e) {
			return new Response<Product>(Constant.ERROR_STATUS_CODE, "An error occured.");
		}
	}

	public Response<List<Product>> viewAllProducts() {
		try {
			List<Product> products = productService.getAllProducts();
			return new Response<List<Product>>(Constant.SUCCESS_STATUS_CODE, "All Products in Catalog.", products);

		} catch (DatabaseEmptyException e) {
			return new Response<List<Product>>(Constant.ERROR_STATUS_CODE, "No Products in catalog currently.");
		} catch (ProductServiceException e) {
			return new Response<List<Product>>(Constant.ERROR_STATUS_CODE, "Could not get all products.");
		} catch (Exception e) {
			return new Response<List<Product>>(Constant.ERROR_STATUS_CODE, "An error occured.");
		}
	}

	public Response<Product> updateProduct(Product product) {

		if (product == null) {
			return new Response<Product>(Constant.ERROR_STATUS_CODE, "Empty product cannot be updated.");
		}

		try {
			Product updatedProduct = productService.updateProduct(product);
			return new Response<Product>(Constant.SUCCESS_STATUS_CODE, "Product updated successfully!!",
					updatedProduct);

		} catch (ProductServiceException e) {
			return new Response<Product>(Constant.ERROR_STATUS_CODE, "Product could not be updated.");
		} catch (Exception e) {
			return new Response<Product>(Constant.ERROR_STATUS_CODE, "An error occured.");
		}
	}

	public Response deleteProduct(int productId) {
		try {
			productService.deleteProduct(productId);
			return new Response(Constant.SUCCESS_STATUS_CODE, "Product deleted successfully!");

		} catch (ProductNotFoundException e) {
			return new Response(Constant.ERROR_STATUS_CODE,
					"Product with ID " + productId + " not found. Deletion Failed.");
		} catch (ProductServiceException e) {
			return new Response(Constant.ERROR_STATUS_CODE, "Product could not be deleted.");
		} catch (Exception e) {
			return new Response(Constant.ERROR_STATUS_CODE, "An error occured.");
		}
	}

}
