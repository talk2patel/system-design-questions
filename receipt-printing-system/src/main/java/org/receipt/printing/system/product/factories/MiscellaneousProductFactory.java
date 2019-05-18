package org.receipt.printing.system.product.factories;

import org.receipt.printing.system.products.MiscellaneousProduct;
import org.receipt.printing.system.products.Product;

public class MiscellaneousProductFactory extends ProductFactory
    {
        public  Product CeateProduct(String name, double price, boolean imported, int quantity)
        {
            return new MiscellaneousProduct(name, price, imported, quantity);
        }
    }