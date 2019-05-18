package org.receipt.printing.system.product.factories;

import org.receipt.printing.system.products.MedicalProduct;
import org.receipt.printing.system.products.Product;

public class MedicalProductFactory extends ProductFactory
    {
        public  Product CeateProduct(String name, double price, boolean imported, int quantity)
        {
            return new MedicalProduct();
        }
    }