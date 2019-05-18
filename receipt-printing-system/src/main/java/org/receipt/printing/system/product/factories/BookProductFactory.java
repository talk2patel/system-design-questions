package org.receipt.printing.system.product.factories;

import org.receipt.printing.system.products.BookProduct;
import org.receipt.printing.system.products.Product;

public class BookProductFactory extends ProductFactory
    {
        public  Product CeateProduct(String name, double price, boolean imported, int quantity)
        {
            return new BookProduct(name, price, imported, quantity);
        }
    }