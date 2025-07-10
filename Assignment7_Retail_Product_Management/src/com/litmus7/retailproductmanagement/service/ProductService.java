package com.litmus7.retailproductmanagement.service;

import java.util.List;

import com.litmus7.retailproductmanagement.dao.ProductDao;
import com.litmus7.retailproductmanagement.dto.Product;
import com.litmus7.retailproductmanagement.exception.DatabaseEmptyException;
import com.litmus7.retailproductmanagement.exception.DbAccessException;
import com.litmus7.retailproductmanagement.exception.ProductAlreadyExistsException;
import com.litmus7.retailproductmanagement.exception.ProductNotFoundException;
import com.litmus7.retailproductmanagement.exception.ProductServiceException;

public class ProductService {

	private ProductDao productDao = new ProductDao();

	public Product addProduct(Product product) throws ProductServiceException, ProductAlreadyExistsException {
		try {

			if (productDao.getProductByName(product.getName()) != null)
				throw new ProductAlreadyExistsException("Product already exists in database.");
			Product addedProduct = productDao.addProduct(product);
			return addedProduct;
		} catch (DbAccessException e) {
			throw new ProductServiceException("Could not add product.", e);
		}
	}

	public Product getProductById(int productId) throws ProductServiceException, ProductNotFoundException {
		try {
			Product foundProduct = productDao.getProductById(productId);
			if (foundProduct == null)
				throw new ProductNotFoundException("Product not found in database.");
			return foundProduct;
		} catch (DbAccessException e) {
			throw new ProductServiceException("Could not get product by Product Id.", e);
		}
	}

	public List<Product> getAllProducts() throws ProductServiceException, DatabaseEmptyException {
		try {
			List<Product> products = productDao.getAllProducts();
			if (products.isEmpty())
				throw new DatabaseEmptyException("The database is empty.");
			return products;
		} catch (DbAccessException e) {
			throw new ProductServiceException("Could not get all products.", e);
		}
	}

	public Product updateProduct(Product product) throws ProductServiceException, ProductNotFoundException {
		try {

			return productDao.updateProduct(product);
		} catch (DbAccessException e) {
			throw new ProductServiceException("Could not update product.", e);
		}
	}

	public void deleteProduct(int productId) throws ProductNotFoundException, ProductServiceException {
		try {
			if (productDao.getProductById(productId) == null)
				throw new ProductNotFoundException("Product not found in database.");
			productDao.deleteProduct(productId);
		} catch (DbAccessException e) {
			throw new ProductServiceException("Could not delete product.", e);
		}

	}

}
