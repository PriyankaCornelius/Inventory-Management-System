package com.company.CartValidationHandler;


import java.util.ArrayList;
import java.util.HashMap;

public class CapValidationHandler implements IValidationHandler{
    private IValidationHandler chain = null;
    private int Luxury=3;
    private int Essential=5;
    private  int Misc=6;
    @Override
    public ArrayList<String> validate(HashMap<String, String[]>  inventory, HashMap<String, String[]>  order, HashMap<String, Integer> categoryWiseRequirements,ArrayList<String> errors) {
        if( categoryWiseRequirements.containsKey("Luxury") && categoryWiseRequirements.get("Luxury")> Luxury)
        {

            errors.add("Luxury-"+categoryWiseRequirements.get("Luxury").toString());
        }

        if (categoryWiseRequirements.containsKey("Essential") &&categoryWiseRequirements.get("Essential")> Essential){
            errors.add("Essentials-"+categoryWiseRequirements.get("Essential").toString());
        }

        if(categoryWiseRequirements.containsKey("Misc")&&categoryWiseRequirements.get("Misc")> Misc){
            errors.add("Misc-"+categoryWiseRequirements.get("Misc").toString());
        }


        return errors;

    }

    @Override
    public void nextHandler(IValidationHandler chain) {
        this.chain = chain ;
    }
}
