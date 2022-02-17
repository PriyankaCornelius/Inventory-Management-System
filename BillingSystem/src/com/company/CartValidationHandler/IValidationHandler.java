package com.company.CartValidationHandler;

import java.util.ArrayList;
import java.util.HashMap;

public interface IValidationHandler {
        ArrayList<String> validate(HashMap<String, String[]> inventory, HashMap<String, String[]> order, HashMap<String, Integer> categoryWiseRequirements, ArrayList<String> errors);
        void nextHandler(IValidationHandler next);
}
