package Database;

import com.company.BillingSystem;

import java.util.HashMap;
import java.util.HashSet;

public class InMemoryDb {

    private HashMap<String, String[]> inventory;
    private HashMap<String, String[]> order;
    private HashMap<String, Integer> categoryWiseRequirements;
    private HashSet<String[]> cardNumber;


    public HashMap<String, String[]> getInventory() {
        return this.inventory;
    }

    public void setInventory(HashMap<String, String[]> inv) {
        this.inventory = inv;
    }

    public HashMap<String, String[]> getOrder() {
        return this.order;
    }

    public void setOrder(HashMap<String, String[]> ord) {
        this.order = ord;
        System.out.println("order this.order" + this.order);
    }

    public HashMap<String, Integer> getCategoryWiseRequirements() {
        return this.categoryWiseRequirements;
    }

    public void setCategoryWiseRequirements(HashMap<String, Integer> req) {
        this.categoryWiseRequirements = req;
    }

    public HashSet<String[]> getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(HashSet<String[]> card) {
        this.cardNumber = card;
    }

}
