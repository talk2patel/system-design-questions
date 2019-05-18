package org.receipt.printing.system.shopping;

import java.util.HashMap;
import java.util.Map;

import org.receipt.printing.system.products.BookProduct;
import org.receipt.printing.system.products.FoodProduct;
import org.receipt.printing.system.products.MedicalProduct;
import org.receipt.printing.system.products.MiscellaneousProduct;
import org.receipt.printing.system.products.Product;

public class StoreShelf
    {
        private  Map<String, Product> productItems;

        public StoreShelf()
        {
            productItems = new HashMap<String, Product>();
            AddProductItemsToShelf("book", new BookProduct());
            AddProductItemsToShelf("music cd", new MiscellaneousProduct());
            AddProductItemsToShelf("chocolate bar", new FoodProduct());
            AddProductItemsToShelf("box of chocolates", new FoodProduct());
            AddProductItemsToShelf("bottle of perfume", new MiscellaneousProduct());
            AddProductItemsToShelf("packet of headache pills", new MedicalProduct());
        }

        public void AddProductItemsToShelf(String productItem, Product productCategory)
        {
            productItems.put(productItem, productCategory);
        }

        public Product SearchAndRetrieveItemFromShelf(String name, double price, boolean imported, int quantity)
        {
            Product productItem = productItems.get(name).GetFactory().CeateProduct(name, price, imported, quantity);
            return productItem;
        }

        public int GetShelfSize()
        {
            return productItems.size();
        }
    }