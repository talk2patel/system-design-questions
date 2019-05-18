package org.receipt.printing.system.billing;

import java.util.List;

import org.receipt.printing.system.products.Product;
import org.receipt.printing.system.tax.calculations.TaxCalculator;
import org.receipt.printing.system.utils.TaxUtil;

public class Biller {
	private TaxCalculator taxCalculator;

	public Biller(TaxCalculator taxCalc) {
		taxCalculator = taxCalc;
	}

	public double CalculateTax(double price, double tax, boolean imported) {

		double totalProductTax = taxCalculator.CalculateTax(price, tax, imported);
		return totalProductTax;
	}

	public double CalcTotalProductCost(double price, double tax) {
		return TaxUtil.Truncate(price + tax);
	}

	public double CalcTotalTax(List<Product> prodList)
        {
            double totalTax = 0.0;

            for (Product p : prodList)
            {
                totalTax += (p.getTaxedCost() - p.get_price());
            }

            return TaxUtil.Truncate(totalTax);
        }

	public double CalcTotalAmount(List<Product> prodList)
        {
            double totalAmount = 0.0;

            for (Product p : prodList)
            {
                totalAmount += p.getTaxedCost();
            }

            return TaxUtil.Truncate(totalAmount);
        }

	public Receipt CreateNewReceipt(List<Product> productList, double totalTax, double totalAmount) {
		return new Receipt(productList, totalTax, totalAmount);
	}

	public void GenerateReceipt(Receipt r) {
		String receipt = r.ToString();
		System.out.println(receipt);
	}

}