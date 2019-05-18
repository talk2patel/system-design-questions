package org.receipt.printing.system.billing;

import java.util.List;

import org.receipt.printing.system.products.Product;
import org.receipt.printing.system.shopping.ShoppingCart;
import org.receipt.printing.system.tax.calculations.TaxCalculator;
import org.receipt.printing.system.tax.calculations.TaxCalculatorFactory;

public class PaymentCounter
    {
        private Biller biller;
        private Receipt receipt;
        private List<Product> productList;
        private String country;

        public PaymentCounter(String country)
        {
            this.country = country;
        }

        public void billItemsInCart(ShoppingCart cart)
        {
            productList = cart.GetItemsFromCart();

            for (Product p : productList)
            {
                biller = GetBiller(country);
                double productTax = biller.CalculateTax(p.get_price(), p.GetTaxValue(country), p.isImported());
                double taxedCost = biller.CalcTotalProductCost(p.getTaxedCost(), productTax);
                p.setTaxedCost(taxedCost);
            }
        }

        public Receipt GetReceipt()
        {
            double totalTax = biller.CalcTotalTax(productList);
            double totalAmount = biller.CalcTotalAmount(productList);
            receipt = biller.CreateNewReceipt(productList, totalTax, totalAmount);
            return receipt;
        }

        public void PrintReceipt(Receipt receipt)
        {
            biller.GenerateReceipt(receipt);
        }

        public Biller GetBiller(String strategy)
        {
            TaxCalculatorFactory factory = new TaxCalculatorFactory();
            TaxCalculator taxCal = factory.GetTaxCalculator(strategy);
            return new Biller(taxCal);
        }
    }