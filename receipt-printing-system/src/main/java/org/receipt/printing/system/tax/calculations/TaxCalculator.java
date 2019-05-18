package org.receipt.printing.system.tax.calculations;

public interface TaxCalculator {

	/// <summary>
	/// Calculates Tax for a Product where Tax Cost is the Sum of Sales
	/// Tax and Imported Duty of a Product.
	/// </summary>
	/// <param name="price">The Price of the Product.</param>
	/// <param name="tax">The Tax Rate of the Product.</param>
	/// <param name="imported">Product is whether Imported or not.</param>
	/// <returns></returns>
	double CalculateTax(double price, double tax, boolean imported);
}