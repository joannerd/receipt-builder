package com.mycompany.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static double roundNum(double num) {
        double result = Math.round(num * 100) / 100.00;
        return result;
    }

    public static double roundTax(double itemPrice, double taxRate) {
        double result = Math.round(itemPrice * taxRate * 20.00) / 20.00;
        double unrounded = itemPrice * taxRate;
        result = (unrounded - result > 0.01) ? Math.ceil(itemPrice * taxRate * 20.00) / 20.00 : result;
        return result;
    }

    public static void main(String[] args) {
        Scanner fileInput;

        // attempt to create scanner for file
        try {
            fileInput = new Scanner(new File("Input3.txt"));
            String[] taxExemptItems = new String[] { "book", "chocolate", "chocolates", "pills" };

            double totalTaxes = 0;
            double totalPrice = 0;

            while (fileInput.hasNextLine()) {

                String[] wordsArray = fileInput.nextLine().split(" ");

                // build `itemString` and set `taxRate`
                double taxRate = 0.10;
                String itemString = "";
                for (int i = 1; i < wordsArray.length - 1; i++) {
                    String word = wordsArray[i];

                    // remove tax rate if the item is exempt
                    if (Arrays.asList(taxExemptItems).contains(word))
                        taxRate -= 0.10;

                    // add import duty to imported items
                    if (word.equals("imported"))
                        taxRate += 0.05;

                    // determine build of `itemString`
                    itemString += (word.equals("at")) ? ": " : " " + word;
                }

                int numberItems = Integer.parseInt(wordsArray[0]);
                double itemPrice = Double.parseDouble(wordsArray[wordsArray.length - 1]);

                double itemTax = roundTax(itemPrice, taxRate);
                double taxPrice = numberItems * roundNum(itemTax + itemPrice);

                System.out.println(numberItems + itemString + taxPrice);

                totalTaxes += itemTax;
                totalPrice += taxPrice;
            }

            System.out.println("Sales Taxes: " + roundNum(totalTaxes));
            System.out.println("Total: " + roundNum(totalPrice));
            fileInput.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Doesnt Exist");
        }
    }

}