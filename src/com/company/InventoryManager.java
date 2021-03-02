package com.company;

import java.util.ArrayList;
import java.util.Date;

//This is a very early version of Inventory that I made just to test how some functionalities will be implemented. Adding exception checks and covering all use cases soon.
public class InventoryManager {
    IngredientDictionary SourceDict; //Copy instance of IngredientDictionary here to load inventory


    public InventoryManager(IngredientDictionary Ing_Dictionary){
        SourceDict = Ing_Dictionary;
    }


    public IngredientItem searchIngredient(String input){
        IngredientItem SearchResult = SourceDict.getIngredientItem(input);
        if (SearchResult.equals(null)){
            System.out.println("Ingredient not found. ");
        }
        return SearchResult;
    }

    public void addIngredient(){
        //IngredientItem newitem = PromptForInput()  //Not sure how we are going to implement this just yet, but I imagine we prompt
        //for details and add them as new ingredients to the Dictionary.

        IngredientItem newitem = new IngredientItem();
        newitem = this.searchIngredient(newitem.getName());
        if (!newitem.equals(null)){
            SourceDict.addIngredientToList(newitem);
        }
    }

    //This function will prompt the user for details about the new ingredient. All attributes will go into the arraylist.
    public ArrayList<String> PromptForInput(){
    ArrayList<String> InputStream = new ArrayList<String>();

    return InputStream;
    }
    // I couldn't find a method to create an ingredient from scratch, so I just created one. This can be deleted or moved somewhere else
    public IngredientItem createIngredient(ArrayList<String> InputStream){
        //
        IngredientItem newIngredient = new IngredientItem();
        newIngredient.setName(InputStream.get(0));
        newIngredient.setType(InputStream.get(1));
        newIngredient.setCost(Double.parseDouble(InputStream.get(2)));
        newIngredient.setWeight(Double.parseDouble(InputStream.get(3)));
        newIngredient.setMeasurementUnit(InputStream.get(0));
        newIngredient.setQuantityOnHand(Double.parseDouble(InputStream.get(2)));
       // newIngredient.setLastUsedDate(InputStream.get(0)); //create a method to convert string to date
        return newIngredient;
    }
    public void removeIngredient(String ingredient){
        IngredientItem newitem = new IngredientItem();
        newitem = this.searchIngredient(newitem.getName());
        if (!newitem.equals(null)){
            SourceDict.removeIngredientFromList(newitem);
        }
    }

    public double calculateCost(String ingredient){
        /*TODO
        *This I think would be the following formula
        *Beginning Inventory (at the beginning of the year)
        *Plus Purchases and Other Costs
        *Minus Ending Inventory (at the end of the year)
        *Equals Cost of Goods Sold.

         */
    //Do we prompt for quantity of item in question we are trying to calculate?

        double quantity = 0.5;
        //Unit calculation comes here
        return quantity*searchIngredient(ingredient).getCost();
    }

    public IngredientItem getIngredient(IngredientItem ingredient){
        return ingredient;
    }

    public boolean doesIngredientExist(IngredientItem ingredient){
        return false;
    }

    public boolean ingredientHasNext(IngredientItem ingredient){
        return false;
    }

}
