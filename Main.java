package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //catalog
        ArrayList<Product> catalog = new ArrayList<Product>();

        //shopping cart
        ArrayList<Product> myproducts = new ArrayList<Product>();

        Product prod1 = new Product();
        Product prod2 = new Product();
        Product prod3 = new Product();
        Product prod4 = new Product();

        Scanner input = new Scanner(System.in);
        String choice;
        String item;
        String edit;

        // add items to catalog
        prod1.setProduct("Bison Sweater");
        prod1.setPrice(55.99);
        catalog.add(prod1);

        prod2.setProduct("Bison Tee");
        prod2.setPrice(14.99);
        catalog.add(prod2);

        prod3.setProduct("Bison Hoodie");
        prod3.setPrice(23.99);
        catalog.add(prod3);

        prod4.setProduct("Bison Bumpersticker");
        prod4.setPrice(4.99);
        catalog.add(prod4);

        //prompt users to add input until they are ready to complete their transaction
        do {
            System.out.println("1.) Add Product 2.) Change Product 3.) Show Cart 4.) Complete Transaction");
            choice = input.nextLine();

            if (choice.equals("1")) //if add purchase
            {
                System.out.println("Name of Product?: ");
                item = input.nextLine();
                for (int i = 0; i < catalog.size(); i++)
                {
                    if (catalog.get(i).getProduct().equals(item))
                    {
                        myproducts.add(catalog.get(i));
                        System.out.println("Success");
                    }
                }
            } else if(choice.equals("2")) //if change purchase
            {
                System.out.println("Which item would you like to change?");
                item = input.nextLine();
                for (int i = 0; i < myproducts.size(); i++)
                {
                    if (myproducts.get(i).getProduct().equals(item))
                    {
                        System.out.println("Remove(1) or Exchange(2)?");
                        edit = input.nextLine();
                        if (edit.equals("1"))//if remove
                        {
                            myproducts.remove(i);
                            System.out.println("Success");
                            item = null;
                        } else if (edit.equals("2"))// if exchange
                        {
                            System.out.println("What would you like to exchange this product with?");
                            item = input.nextLine();
                            for (int j = 0; j < catalog.size(); j++)
                            {
                                if (catalog.get(j).getProduct().equals(item))
                                {
                                    myproducts.set(i, catalog.get(j));
                                    System.out.println("Success");
                                    item = null;
                                }
                            }
                        }
                    }
                }
            } else if(choice.equals("3"))//if show cart
            {
                System.out.println("Invoice: ");
                for (int i = 0; i < myproducts.size(); i++) {
                    System.out.println(myproducts.get(i).getProduct() + " - " + myproducts.get(i).getPrice());
                }
            }
        } while ( ! choice.equals("4") );
        double total = 0;
        for (int i = 0; i < myproducts.size(); i++) {
            total += myproducts.get(i).getPrice();
        }
        System.out.println("Thank you for shopping with us! Your total came out to " + total);
    }
}
