package org.receipt.printing.system;

import java.util.Scanner;

import org.receipt.printing.system.shopping.ShoppingStore;

public class App 
{
    public static void main( String[] args )
    {
    	ShoppingStore store = new ShoppingStore();
        store.GetSalesOrder();
        store.CheckOut();
        Scanner scanner = new Scanner(System.in);
        
//        Console.ReadKey();
    }
}
