package com.company;

import com.company.CartValidationHandler.CapValidationHandler;
import com.company.CartValidationHandler.IValidationHandler;
import com.company.CartValidationHandler.StockValidationHandler;
import Database.InMemoryDb;
import FileFactory.WriteToCSV;
import FileFactory.WriteToTxt;
import PriceCalculator.PriceCalculator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import  java.lang.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class BillingSystem {
    public static ArrayList<String> errors;

    public static void main(String[] args) throws Exception {
        // write your code here
        System.out.println("hello world");
        errors = new ArrayList<String>();

        InMemoryDb db = new InMemoryDb();

        BillingSystem billingSystem = new BillingSystem();

        HashMap<String, String[]> inventory = billingSystem.createInventory();
        db.setInventory(inventory);

        HashMap<String, String[]> order = billingSystem.getOrder();
        System.out.println("this.order set in bill sys" + order);
        db.setOrder(order);

        HashMap<String, Integer> categoryWiseRequirements = billingSystem.getCategoryWiseRequirements(inventory, order);
        db.setCategoryWiseRequirements(categoryWiseRequirements);

        HashSet<String[]> cardNumber = billingSystem.getCardNumbers();
        db.setCardNumber(cardNumber);

        System.out.println("order ****** " + order);
        System.out.println("inv ***** " + inventory);
        System.out.println("categoryWiseRequirements ****** " + categoryWiseRequirements);
        System.out.println("cardNumber ****** " + cardNumber);

        IValidationHandler validStock = new StockValidationHandler();
        IValidationHandler capCategory = new CapValidationHandler();
        validStock.nextHandler(capCategory);
        ArrayList<String> Err = validStock.validate(inventory, order, categoryWiseRequirements, errors);

        System.out.println(Err.toString());

        if(Err.isEmpty()) {
            PriceCalculator priceObj = new PriceCalculator();
            float totalPrice = priceObj.getTotal(order, inventory);

            WriteToCSV writeCSVobj = new WriteToCSV();
            writeCSVobj.writeToFile(String.valueOf(totalPrice));
        }
        else{
            WriteToTxt writeObj = new WriteToTxt();
            writeObj.writeToFile(Err.toString());
        }

//        WriteToTxt writeObj = new WriteToTxt();
//        writeObj.writeToFile();
//        WriteToCSV writeCSVobj = new WriteToCSV();
//        writeCSVobj.writeToFile();
    }


    private HashMap<String, String[]> createInventory() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the inventory file: ");

        String response = "";
        HashMap<String, String[]> inventory = new HashMap<String, String[]>();

        try {
            response = br.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(response));
            String line = "";
            String splitBy = ",";
            //ignore first line
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null)   //returns a Boolean value
            {
                String[] lineafterread = line.split(splitBy);    // use comma as separator
                inventory.put(lineafterread[1], new String[]{lineafterread[0], lineafterread[2], lineafterread[3]});

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return inventory;

    }

    private HashMap<String, String[]> getOrder() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the order file path to place order: ");

        String response = "";
        HashMap<String, String[]> order = new HashMap<String, String[]>();

        try {
            response = br.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(response));
            String line = "";
            String splitBy = ",";
            //ignore first line
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null)   //returns a Boolean value
            {
                String[] lineafterread = line.split(splitBy);    // use comma as separator

                order.put(lineafterread[0], new String[]{lineafterread[1], lineafterread[2]});
            }


        } catch (IOException e) {

            e.printStackTrace();

        }

        return order;

    }

    private HashMap<String, Integer> getCategoryWiseRequirements(HashMap<String, String[]> inventory, HashMap<String, String[]> order) {
        HashMap<String, Integer> categoryWiseRequirements = new HashMap<String, Integer>();
        for (String item : order.keySet()) {
            String category = inventory.get(item)[0];
            // search  for value
            int orderedQty = Integer.parseInt(order.get(item)[0]);
            int categoryQuantity = categoryWiseRequirements.containsKey(category) ? categoryWiseRequirements.get(category) : 0;
            int updatedQty = categoryQuantity + orderedQty;
            categoryWiseRequirements.put(category, updatedQty);

        }
        return categoryWiseRequirements;
    }


    private HashSet<String[]> getCardNumbers() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the card numbers file: ");

        String response = "";
        HashSet<String[]> cardNumbers = new HashSet<String[]>();

        try {
            response = br.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(response));
            String line = "";
            String splitBy = ",";
            //ignore first line
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null)   //returns a Boolean value
            {
                String[] lineafterread = line.split(splitBy);    // use comma as separator

                cardNumbers.add(lineafterread);
            }


        } catch (IOException e) {

            e.printStackTrace();

        }

        return cardNumbers;

    }
}