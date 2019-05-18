package org.receipt.printing.system.products;

import org.receipt.printing.system.product.factories.BookProductFactory;
import org.receipt.printing.system.product.factories.ProductFactory;
import org.receipt.printing.system.tax.calculations.LocalTaxValues;

public class BookProduct extends Product {

	public BookProduct(String name, double price, boolean imported, int quantity) {
		// TODO Auto-generated constructor stub
	}

	public BookProduct() {
		// TODO Auto-generated constructor stub
	}

	public ProductFactory GetFactory() {
		return new BookProductFactory();
	}

	public double GetTaxValue(String country) {
		if (country == "Local")
			return LocalTaxValues.BOOK_TAX;
		else
			return 0;
	}
}