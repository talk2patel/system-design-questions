package org.receipt.printing.system.billing;

import java.util.List;

import org.receipt.printing.system.products.Product;

public class Receipt {
	private List<Product> ProductList;
	private double TotalSalesTax;
	private double TotalAmount;

	public Receipt(List<Product> prod, double tax, double amount) {
		ProductList = prod;
		TotalSalesTax = tax;
		TotalAmount = amount;
	}

	public int GetTotalNumberOfItems() {
		return ProductList.size();
	}

	public String ToString() {
		String receipt = "";
		System.out.println("***************");
		for (Product p : ProductList) {
			receipt += (p.toString() + "\n");
		}

		receipt += "Total sales tax = " + TotalSalesTax + "\n";
		receipt += "Total amount = " + TotalAmount + "\n";

		return receipt;
	}
}