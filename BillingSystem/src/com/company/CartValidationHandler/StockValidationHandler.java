package com.company.CartValidationHandler;

import java.util.ArrayList;
import java.util.HashMap;

public class StockValidationHandler implements IValidationHandler{
    private IValidationHandler chain = null;

    @Override
    public ArrayList<String> validate(HashMap<String, String[]>  inventory, HashMap <String, String[]> order, HashMap<String, Integer> categoryWiseRequirements,ArrayList<String> errors) {

        for (String key : order.keySet()) {
            if(inventory.containsKey(key)==true){
                if(Integer.parseInt(order.get(key)[0])>Integer.parseInt(inventory.get(key)[1]))
                {
                    errors.add(key);

                }
            }else {
                errors.add(key);
            }
        }

        this.chain.validate( inventory,  order, categoryWiseRequirements,errors);
        return errors;

    }

    @Override
    public void nextHandler(IValidationHandler chain) {
        this.chain = chain ;
    }
}
