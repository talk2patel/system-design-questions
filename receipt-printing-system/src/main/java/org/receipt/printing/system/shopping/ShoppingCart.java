package org.receipt.printing.system.shopping;

import java.util.ArrayList;
import java.util.List;

import org.receipt.printing.system.products.Product;

public class ShoppingCart {
	private List<Product> productList;

	public ShoppingCart() {
		productList = new ArrayList<>();
	}

	public void AddItemToCart(Product product) {
		productList.add(product);
	}

	public List<Product> GetItemsFromCart() {
		return productList;
	}

	public int GetCartSize() {
		return productList.size();
	}
}