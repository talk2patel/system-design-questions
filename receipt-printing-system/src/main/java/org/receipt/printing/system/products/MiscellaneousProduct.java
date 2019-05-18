package org.receipt.printing.system.products;

import org.receipt.printing.system.product.factories.MiscellaneousProductFactory;
import org.receipt.printing.system.product.factories.ProductFactory;
import org.receipt.printing.system.tax.calculations.LocalTaxValues;

public class MiscellaneousProduct extends Product {
	
	public MiscellaneousProduct(String name, double price, boolean imported, int quantity) {
		// TODO Auto-generated constructor stub
	}
	
	public MiscellaneousProduct() {
		// TODO Auto-generated constructor stub
	}

	public ProductFactory GetFactory() {
		return new MiscellaneousProductFactory();
	}

	public double GetTaxValue(String country)
        {
            if (country == "Local")
                return LocalTaxValues.MISC_TAX;
            else
                return 0;
        }
}