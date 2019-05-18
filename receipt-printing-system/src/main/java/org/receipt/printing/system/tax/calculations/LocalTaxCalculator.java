package org.receipt.printing.system.tax.calculations;

import org.receipt.printing.system.utils.TaxUtil;

public class LocalTaxCalculator implements TaxCalculator {
	public double CalculateTax(double price, double localTax, boolean imported) {
		double tax = price * localTax;

		if (imported)
			tax += (price * 0.5);

		// rounds off to nearest 0.05;
		tax = TaxUtil.RoundOff(tax);

		return tax;
	}
}