package com.litmus7.retailproductmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.retailproductmanagement.dto.Product;
import com.litmus7.retailproductmanagement.exception.DbAccessException;
import com.litmus7.retailproductmanagement.util.DBColumn;
import com.litmus7.retailproductmanagement.util.DBQuery;
import com.litmus7.retailproductmanagement.util.DBUtil;

public class ProductDao {

	public Product addProduct(Product product) throws DbAccessException {

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(DBQuery.addProductQuery);) {
			statement.setInt(1, product.getProductId());
			statement.setString(2, product.getName());
			statement.setString(3, product.getCategory());
			statement.setDouble(4, product.getPrice());
			statement.setInt(5, product.getStockQuantity());

			statement.executeUpdate();

			return getProductById(product.getProductId());
		} catch (SQLException e) {

			throw new DbAccessException("Database error while adding product.", e);
		}
	}

	public Product getProductById(int productId) throws DbAccessException {

		Product foundProduct = null;

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(DBQuery.getProductByIdQuery);) {

			statement.setInt(1, productId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next())
				foundProduct = new Product(resultSet.getInt(DBColumn.ID_COLUMN), resultSet.getString(DBColumn.NAME_COLUMN),
						resultSet.getString(DBColumn.CATEGORY_COLUMN), resultSet.getDouble(DBColumn.PRICE_COLUMN),
						resultSet.getInt(DBColumn.STOCK_COLUMN));

			return foundProduct;

		} catch (SQLException e) {
			throw new DbAccessException("Database error while searching product by id.", e);
		}
	}

	public List<Product> getAllProducts() throws DbAccessException {

		List<Product> products = new ArrayList<Product>();

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(DBQuery.getAllProductsQuery);) {

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next())
				products.add(new Product(resultSet.getInt(DBColumn.ID_COLUMN), resultSet.getString(DBColumn.NAME_COLUMN),
						resultSet.getString(DBColumn.CATEGORY_COLUMN), resultSet.getDouble(DBColumn.PRICE_COLUMN),
						resultSet.getInt(DBColumn.STOCK_COLUMN)));

			return products;

		} catch (SQLException e) {
			throw new DbAccessException("Database error while retreiving all products.", e);
		}
	}

	public Product updateProduct(Product product) throws DbAccessException {

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(DBQuery.updateProductQuery);) {
			statement.setString(1, product.getName());
			statement.setString(2, product.getCategory());
			statement.setDouble(3, product.getPrice());
			statement.setInt(4, product.getStockQuantity());
			statement.setInt(5, product.getProductId());

			statement.executeUpdate();

			return new Product(product.getProductId(), product.getName(), product.getCategory(), product.getPrice(),
					product.getStockQuantity());

		} catch (SQLException e) {

			throw new DbAccessException("Database error while updating product.", e);
		}

	}

	public void deleteProduct(int productId) throws DbAccessException {

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(DBQuery.deleteProductQuery);) {

			statement.setInt(1, productId);
			statement.executeUpdate();

		}

		catch (SQLException e) {
			throw new DbAccessException("Database error while deleting product.", e);
		}
	}

	public Product getProductByName(String name) throws DbAccessException {

		Product foundProduct = null;

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(DBQuery.getProductByNameQuery);) {

			statement.setString(1, name);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next())
				foundProduct = new Product(resultSet.getInt(DBColumn.ID_COLUMN), resultSet.getString(DBColumn.NAME_COLUMN),
						resultSet.getString(DBColumn.CATEGORY_COLUMN), resultSet.getDouble(DBColumn.PRICE_COLUMN),
						resultSet.getInt(DBColumn.STOCK_COLUMN));

			return foundProduct;

		} catch (SQLException e) {
			throw new DbAccessException("Database error while searching product by name.", e);
		}
	}
}
