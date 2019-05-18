package org.receipt.printing.system.shopping;

import java.util.Scanner;

import org.receipt.printing.system.billing.PaymentCounter;
import org.receipt.printing.system.billing.Receipt;
import org.receipt.printing.system.products.Product;

public class ShoppingStore {
	private ShoppingCart shoppingCart;
	private StoreShelf storeShelf;
	private PaymentCounter paymentCounter;
	private String country;
	private Scanner scanner = new Scanner(System.in);

	public ShoppingStore() {
		country = "Local";
		shoppingCart = new ShoppingCart();
		paymentCounter = new PaymentCounter(country);
		storeShelf = new StoreShelf();
	}

	public void RetrieveOrderAndPlaceInCart(String name, double price, boolean imported, int quantity) {
		Product product = storeShelf.SearchAndRetrieveItemFromShelf(name, price, imported, quantity);
		shoppingCart.AddItemToCart(product);
	}

	public void GetSalesOrder() {
		do {
			String name = GetProductName();
			double price = GetProductPrice();
			boolean imported = IsProductImported();
			int quantity = GetQuantity();
			RetrieveOrderAndPlaceInCart(name, price, imported, quantity);
		} while (IsAddAnotherProduct());
	}

	public void CheckOut() {
		paymentCounter.billItemsInCart(shoppingCart);
		Receipt receipt = paymentCounter.GetReceipt();
		paymentCounter.PrintReceipt(receipt);
	}

	public String GetProductName() {
		System.out.println("Enter the product name:\n");
		return scanner.nextLine();
	}

	public double GetProductPrice() {
		System.out.println("Enter the product price:\n");
		return scanner.nextDouble();
	}

	public boolean IsProductImported() {
		System.out.println("Is product imported or not?(Y/N)\n");
		String input = scanner.next();
		boolean isValid = false;
		while (!isValid) {
			if (input == "Y")
				isValid = true;
			else if (input == "N")
				isValid = true;
			else
				System.out.println("Invalid input. Enter (Y/N)");
		}

		if (input == "Y")
			return true;
		else
			return false;
	}

	public int GetQuantity() {
		System.out.println("Enter the quantity:\n");
		int intVal = scanner.nextInt();
		return intVal;
	}

	public boolean IsAddAnotherProduct() {
		System.out.println("Do you want to add another Product?(Y/N)");

		String input = scanner.nextLine();
		while (!(input == "Y" || input == "N")) {
			System.out.println("Invalid input. Enter (Y/N)");
		}
		return input.charAt(0) == 'Y' ? true : false;// = TaxUtil.ParseBoolean(Convert.ToChar(input));
	}
}