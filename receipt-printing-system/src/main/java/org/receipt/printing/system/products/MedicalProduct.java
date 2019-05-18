package org.receipt.printing.system.products;

import org.receipt.printing.system.product.factories.MedicalProductFactory;
import org.receipt.printing.system.product.factories.ProductFactory;
import org.receipt.printing.system.tax.calculations.LocalTaxValues;

public class MedicalProduct extends Product {

	public ProductFactory GetFactory() {
		return new MedicalProductFactory();
	}

	public double GetTaxValue(String country)
        {
            if (country == "Local")
                return LocalTaxValues.MEDICAL_TAX;
            else
                return 0;
        }
}