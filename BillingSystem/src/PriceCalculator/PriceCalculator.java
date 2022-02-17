package PriceCalculator;

import Database.InMemoryDb;
import com.company.BillingSystem;

import java.util.HashMap;

public class PriceCalculator {
    InMemoryDb db = new InMemoryDb();

    float totalPrice=0;
    float itemPrice=0;
    float itemQty=0;

    public float getTotal(HashMap<String, String[]> order, HashMap<String, String[]> inventory){
        System.out.println("this.order in pricecalc" +order);
        for (String item : order.keySet()) {
            if(inventory.containsKey(item)){
                itemQty= Float.parseFloat(order.get(item)[0]);
                itemPrice = Float.parseFloat(inventory.get(item)[2]);
                System.out.println("item price : "+ itemPrice + " qty "+ itemQty);
                totalPrice=totalPrice+ (itemQty* itemPrice);
            }
        }
        System.out.println("Total Price is : " + totalPrice);
        return totalPrice;
    }


}
