package org.receipt.printing.system.product.factories;

import org.receipt.printing.system.products.FoodProduct;
import org.receipt.printing.system.products.Product;

public class FoodProductFactory extends ProductFactory
    {
        public  Product CeateProduct(String name, double price, boolean imported, int quantity)
        {
            return new FoodProduct(name, price, imported, quantity);
        }
    }