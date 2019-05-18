package org.receipt.printing.system.products;

import org.receipt.printing.system.product.factories.FoodProductFactory;
import org.receipt.printing.system.product.factories.ProductFactory;
import org.receipt.printing.system.tax.calculations.LocalTaxValues;

public class FoodProduct extends Product {
	public FoodProduct(String name, double price, boolean imported, int quantity) {
		// TODO Auto-generated constructor stub
	}

	public FoodProduct() {
		// TODO Auto-generated constructor stub
	}

	public ProductFactory GetFactory() {
		return new FoodProductFactory();
	}

	public double GetTaxValue(String country) {
		if (country == "Local")
			return LocalTaxValues.FOOD_TAX;
		else
			return 0;
	}
}