package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;


public class InventoryManager {
    IngredientDictionary IngredientDictionary; //Copy instance of IngredientDictionary here to load inventory

    FileManager FileManager;
    IngredientFactory IngredientFactory;
    double initialInventorycost;
    public InventoryManager(){
        //TODO make so that it takes in a file name here for either Initial Setup or Demo Setup
        FileManager = new FileManager("DataSource/ingredients.json");
        IngredientFactory = new IngredientFactory();
        createIngredientDictionary();
        initialInventorycost = IngredientDictionary.inventoryCost();
    }

    /**
     * Method to create the Ingredient Dictionary and House within the Inventory Manger for Ease of Access to the GUI
     * Designed for Future Development with Recipes being Managed as well
     */
    private void createIngredientDictionary(){
        try {
            FileManager.generateStringArrayList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileManager.createObjectArray();
        IngredientFactory.startFactory(FileManager.getObjectArrayList());
        IngredientDictionary = new IngredientDictionary(IngredientFactory.getList());

        try {
            FileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to Generate/Create the JSON file for Ingredients before closing of program
     */
    public void createIngredientFileWriter(){
        FileManager = new FileManager();
        //TODO Update to reflect a file name being passed in, either from initial setup or from a demo setup
        FileManager.setFileName("DataSource/Ingredients.json");
        FileManager.setStringArrayList(IngredientDictionary.convertToStringArrayList());

        try {
            FileManager.generateJSONFile("Ingredients");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    public IngredientItem searchIngredient(String searchInput){


        IngredientItem SearchResult = IngredientDictionary.getIngredientItem(searchInput);

//        if(!SearchResult.equals(null)){
//            return SearchResult;
//        }else {
//            System.out.println("Ingredient Not Found");
//            return null;
//        }   //TODO change to through exception
//
//       if (SearchResult.equals(null)){
//            System.out.println("Ingredient not found. ");
//        }
        return SearchResult;
    }

    public void addIngredient(IngredientItem addItem){
        //IngredientItem newitem = PromptForInput()
        // Not sure how we are going to implement this just yet, but I imagine we prompt
        //for details and add them as new ingredients to the Dictionary.

        IngredientDictionary.addIngredientToList(addItem);

/*        IngredientItem newitem = new IngredientItem();
        newitem = this.searchIngredient(newitem.getName());

        if (!newitem.equals(null)){
            IngredientDictionary.addIngredientToList(newitem);
        }*/
    }

    //This function will prompt the user for details about the new ingredient.
    // All attributes will go into the arraylist.

    /*This can be handled through the GUI and it's controller, then it can pass the new ingredient to be added
    * to the "addIngredient()" method
    * It would do so by prompting user to enter the relevant data, then store that in a temporary IngredientItem object
    * That would then be passed to the Inventory Manager's addIngredient() method.
    */
    public ArrayList<String> PromptForInput(){
        ArrayList<String> InputStream = new ArrayList<String>();

        return InputStream;
    }

    // I couldn't find a method to create an ingredient from scratch, so I just created one.
    // This can be deleted or moved somewhere else

    /*
    This is done with the IngredientItem Constructor, it can be created multiple ways to be passed around.
    Best not to have any other class creating an Ingredient Item like this.
     */
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

    /**
     * Method to Remove Specified Ingredient Item
     * @param removeItem    Ingredient Item to be Removed from the Ingredient Dictionary
     */
    public void removeIngredient(IngredientItem removeItem){
     //Probably don't need this exception here. Causes it to print twice. Exception already added to the search function,
     //but removing the exception from removeIngredient leads to errors the way its currently coded. Could easily be fixed
     //depending on how we choose to remove ingredients from the array.
    try {
    IngredientDictionary.removeIngredientFromList(removeItem);
    }
    catch (NullPointerException e){
    System.out.println("::Ingredient Not Found");
    }
/*         IngredientItem newitem = new IngredientItem();
        newitem = this.searchIngredient(newitem.getName());
        if (!newitem.equals(null)){
            IngredientDictionary.removeIngredientFromList(newitem);
        }*/
    }

    public double calculateCost(String ingredient, double quantity){
        /*TODO
        *This I think would be the following formula
        *Beginning Inventory (at the beginning of the year)
        *Plus Purchases and Other Costs
        *Minus Ending Inventory (at the end of the year)
        *Equals Cost of Goods Sold.

         */
    //Do we prompt for quantity of item in question we are trying to calculate?
        //Unit calculation comes here
        return quantity*searchIngredient(ingredient).getCost();
    }
/**
 * This returns the current cost of all items in the inventory.
 * @return A double which represents the current cost of all items in the inventory
 * */
    public double curInventoryCost(){
        return IngredientDictionary.inventoryCost();
    }
    /**
     * This returns the difference between the initial cost of all items and the current cost.
     * @return A double which represents the cost difference.
     * */
    public double costDifference(){
        return initialInventorycost - curInventoryCost();
    }

    /**
     * Method will Retrieve a copy of the Ingredient Item Needed
     * @param ingredientName    The name of the Ingredient Item to be Retrieved
     * @return  Returns the requested Ingredient Item
     * TODO add Exception Handler for when the Ingredient Item Does not
     */
    public IngredientItem getIngredient(String ingredientName){
        return IngredientDictionary.getIngredientItem(ingredientName);
    }

    /**
     * Method Checks to see an Ingredient Item Exists in the Inventory Dictionary
     * @param ingredient    The Ingredient Item to be Searched for
     * @return  Boolean Value based on result
     */
    public boolean doesIngredientExist(IngredientItem ingredient){
        return IngredientDictionary.ingredientCheck(ingredient);
    }

    //Need???
    public boolean ingredientHasNext(IngredientItem ingredient){
        return false;
    }

}
