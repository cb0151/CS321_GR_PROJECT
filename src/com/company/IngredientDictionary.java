package com.company;

import java.util.ArrayList;

import java.util.ListIterator;

public class IngredientDictionary {

    private ArrayList<IngredientItem> ingredientItemArrayList;
    private static  IngredientDictionary instance = null;
    private static ChangeLogger ingredientChangeLogger;

    /**
     * Gets instance the single instance of IngredientFact
     */
    public static IngredientDictionary getIngredientDictionary()
    {
        if(instance == null)
        {

            instance = new IngredientDictionary();
        }

        return instance;

    }
    private IngredientDictionary()
    {
        this.ingredientItemArrayList = new ArrayList<>();
        for(int i = 0; i < ingredientItemArrayList.size(); i++){

            this.ingredientItemArrayList.add(ingredientItemArrayList.get(i));

        }

    }

    /**
     * Creates the Array list for the Singleton
     * @param ingredientItemArrayList
     */
    public void setIngredientItemArrayList(ArrayList<IngredientItem> ingredientItemArrayList){
        this.ingredientItemArrayList = new ArrayList<>();
        for(int i = 0; i < ingredientItemArrayList.size(); i++){

            this.ingredientItemArrayList.add(ingredientItemArrayList.get(i));

        }

    }


    /**
     * Constructor to Create a Clone of the Ingredient Item Array List
     * @param ingredientItemArrayList  The Ingredient Item Array List to be Cloned
     */
    public IngredientDictionary(ArrayList<IngredientItem> ingredientItemArrayList) {
        this.ingredientItemArrayList = new ArrayList<>();
        for(int i = 0; i < ingredientItemArrayList.size(); i++){

            this.ingredientItemArrayList.add(ingredientItemArrayList.get(i));

        }
    }

    /**
     * Method to Get the Ingredient Item Linked List to be managed else where.
     * TODO look into security issues with passing this from the Dictionary.
     * @return
     */
    public ArrayList<IngredientItem> getIngredientItemArrayList() {
        return ingredientItemArrayList;
    }

    /**
     * Method allows you to get a single Ingredient Item referenced by name
     * @param ingredientName    Name of the Ingredient Item to returned
     * @return  Returns Ingredient Item Extracted from the Array List
     */
    public IngredientItem getIngredientItem(String ingredientName){

        IngredientItem tempIngredientItem = null;
        for(int i = 0; i < this.ingredientItemArrayList.size(); i++){
            if(this.ingredientItemArrayList.get(i).getName().equals(ingredientName)){
                tempIngredientItem = new IngredientItem(this.ingredientItemArrayList.get(i));
            }
        }
        return tempIngredientItem;
    }

    /**
     * Method to check if an Ingredient Name Already Exists in the Array List
     * @param ingredientName
     * @return  Boolean Value to be returned to verify the operation succeeded.
     */
    public boolean ingredientNameCheck(String ingredientName){
        boolean isIngredient = false;
        for(int i = 0; i < this.ingredientItemArrayList.size(); i++){
            if(this.ingredientItemArrayList.get(i).getName().equals(ingredientName)){

                isIngredient = true;
            }
        }


        return isIngredient;
    }

    /**
     * Method to check if an Ingredient Already Exists in the Array List
     * @param ingredientItem
     * @return  Boolean Value to be returned to verify the operation succeeded.
     */
    public boolean ingredientCheck(IngredientItem ingredientItem){
        boolean isIngredient = false;
        for(int i = 0; i < this.ingredientItemArrayList.size(); i++){
            if(this.ingredientItemArrayList.get(i).getName().equals(ingredientItem.getName())){
                System.out.println("Found Ingredient ::" + this.ingredientItemArrayList.get(i).getName());
                isIngredient = true;
            }
        }
        //TODO add exception Handling here
        if(isIngredient == false) System.out.println(ingredientItem.getName() + " :: Error Not Found");

        return isIngredient;
    }

    /**
     * Method to Add Ingredient Item to the List,
     * TODO add exception call for when the Ingredient Already Exists in the list
     * @param ingredientItem    The ingredient Item to be added.
     * @return  Boolean Value to be returned to verify the operation succeeded.
     */

    public boolean addIngredientToList(IngredientItem ingredientItem){
        boolean alreadyExists = ingredientCheck(ingredientItem);


        if(alreadyExists == false){
            System.out.println("Safe to Add to List");
            this.ingredientItemArrayList.add(ingredientItem);
            System.out.println(ingredientItem.getName() + ":: Has Been Added To the List");
            return true;
        }else {
            System.out.println("Error, Ingredient" + ingredientItem.getName() + "Already Exists");
            return false;
        }
    }

    /**
     * Method to Remove the Ingredient from the List
     * TODO add exception for when the Ingredient Does Not exist in the list.
     * @param ingredientItem    The ingredient Item to be removed from the list.
     * @return  Boolean Value to be returned to verify the operation succeeded.
     */
    public void removeIngredientFromList(IngredientItem ingredientItem){
        boolean exists = ingredientCheck(ingredientItem);

        if(exists == true) {
            for (int i = 0; i < this.ingredientItemArrayList.size(); i++) {
                if (this.ingredientItemArrayList.get(i).getName().equals(ingredientItem.getName())) {
                    String temp = this.ingredientItemArrayList.get(i).getName();
                    this.ingredientItemArrayList.remove(i);
                    System.out.println(temp + ":: Removed From Ingredient Dictionary List");
                }
            }
        }
    }

    /**
     * Method to Update a Single Ingredient Item that exists in the list.
     * UPDATES BY REPLACING THE SAME INGREDIENT IN THE LIST WITH A NEW VERSION OF THE ITEM
     * @param updateItem    The Ingredient Item to be updated
     * @return  Boolean Value to be returned to verify the operation succeeded.
     */
    public boolean updateIngredientInList(IngredientItem updateItem){
        this.removeIngredientFromList(updateItem);
        this.ingredientChanges(updateItem);
        this.addIngredientToList(updateItem);
        return true;
    }

    /**
     * Method convert Ingredient Array List to an Array List of String Printouts
     * @return
     */
    public ArrayList<String> convertToStringArrayList(){
        ArrayList<String> stringArrayList = new ArrayList<>();
        for(int i = 0; i < this.ingredientItemArrayList.size(); i++){
            stringArrayList.add(this.ingredientItemArrayList.get(i).toJSONString());
        }
        return stringArrayList;
    }

    /**
     * Method for Testing, Prints out all Items in the Ingredient Item Array List
     */
    public void printDictionary(){
        ListIterator<IngredientItem> itr = this.ingredientItemArrayList.listIterator(0);
        while(itr.hasNext()){
            System.out.println(itr.next().toJSONString());
        }
    }

    /**
     * Method to compare 2 Ingredient Items to see if the original had any changes made before it gets updated
     * @param ingredientItem    The ingredient item to be updated
     * @return
     */
    private ChangeLogger ingredientChanges(IngredientItem ingredientItem){
        //TODO remove, inserted to as place holder
        ChangeLogger changes = new ChangeLogger();

        for(int i = 0; i < this.ingredientItemArrayList.size(); i++){
            if(!this.ingredientItemArrayList.get(i).getName().equals(ingredientItem.getName())){
                //TODO Record Changes
            }

            if(!this.ingredientItemArrayList.get(i).getType().equals((ingredientItem.getType()))){
                //TODO Record Changes
            }

            if(this.ingredientItemArrayList.get(i).getCost() != ingredientItem.getCost()){
                //TODO Record Changes
            }

            if(this.ingredientItemArrayList.get(i).getWeight() != ingredientItem.getWeight()){
                //TODO Record Changes
            }

            if(!this.ingredientItemArrayList.get(i).getMeasurementUnit().equals((ingredientItem.getMeasurementUnit()))){
                //TODO Record Changes
            }

            if(this.ingredientItemArrayList.get(i).getQuantityOnHand() != ingredientItem.getQuantityOnHand()){
                //TODO Record Changes
            }
        }

        return changes;
    }
}

//hello
