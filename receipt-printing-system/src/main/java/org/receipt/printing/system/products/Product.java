package org.receipt.printing.system.products;

import org.receipt.printing.system.product.factories.ProductFactory;

public abstract class Product {
	protected String name;

	private double _price;
	private boolean imported;
	private int quantity;
	private double TaxedCost;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double get_price() {
		return _price;
	}

	public void set_price(double _price) {
		this._price = _price;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTaxedCost() {
		return TaxedCost;
	}

	public void setTaxedCost(double taxedCost) {
		TaxedCost = taxedCost;
	}

	public String importedToString(boolean imported) {
		if (!imported)
			return "";
		else
			return "imported";
	}

	public abstract ProductFactory GetFactory();

	public abstract double GetTaxValue(String country);
}