package org.receipt.printing.system.tax.calculations;

import java.util.HashMap;
import java.util.Map;

public class TaxCalculatorFactory {
	private Map<String, TaxCalculator> taxCalculators;

	public TaxCalculatorFactory() {
		taxCalculators = new HashMap<String, TaxCalculator>();
		RegisterInFactory("Local", new LocalTaxCalculator());
	}

	public void RegisterInFactory(String strategy, TaxCalculator taxCalc) {
		taxCalculators.put(strategy, taxCalc);
	}

	public TaxCalculator GetTaxCalculator(String strategy) {
		TaxCalculator taxCalc = (TaxCalculator) taxCalculators.get(strategy);
		return taxCalc;
	}

	public int GetFactorySize() {
		return taxCalculators.size();
	}
}