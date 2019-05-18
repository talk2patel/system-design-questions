package org.receipt.printing.system.product.factories;

import org.receipt.printing.system.products.Product;

public abstract class ProductFactory {
	public abstract Product CeateProduct(String name, double price, boolean imported, int quantity);
}