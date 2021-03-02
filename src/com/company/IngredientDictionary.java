package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class IngredientDictionary {

    LinkedList<IngredientItem> ingredientItemLinkedList;

    /**
     * Constructor to Create a Clone of the Ingredient Item Linked List
     * @param ingredientItemLinkedList  The Ingredient Item Linked List to be Cloned
     */
    public IngredientDictionary(LinkedList<IngredientItem> ingredientItemLinkedList) {
        this.ingredientItemLinkedList = new LinkedList<>();
        for(int i = 0; i < ingredientItemLinkedList.size(); i++){

            this.ingredientItemLinkedList.add(ingredientItemLinkedList.get(i));

        }
    }

    /**
     * Method to Get the Ingredient Item Linked List to be managed else where.
     * TODO look into security issues with passing this from the Dictionary.
     * @return
     */
    public LinkedList<IngredientItem> getIngredientItemLinkedList() {
        return ingredientItemLinkedList;
    }

    /**
     * Method allows you to get a single Ingredient Item referenced by name
     * @param ingredientName    Name of the Ingredient Item to returned
     * @return  Returns Ingredient Item Extracted from the Linked List
     */
    public IngredientItem getIngredientItem(String ingredientName){

        IngredientItem tempIngredientItem = null;
        for(int i = 0; i < this.ingredientItemLinkedList.size(); i++){
            if(this.ingredientItemLinkedList.get(i).getName().equals(ingredientName)){
                tempIngredientItem = new IngredientItem(this.ingredientItemLinkedList.get(i));
            }
        }
        return tempIngredientItem;
    }

    /**
     * Method to check if an Ingredient Already Exists in the Linked List
     * @param ingredientItem
     * @return  Boolean Value to be returned to verify the operation succeeded.
     */
    public boolean ingredientCheck(IngredientItem ingredientItem){
        boolean isIngredient = false;
        for(int i = 0; i < this.ingredientItemLinkedList.size(); i++){
            if(this.ingredientItemLinkedList.get(i).getName().equals(ingredientItem.getName())){
                System.out.println("Found Ingredient ::" + this.ingredientItemLinkedList.get(i).getName());
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
            this.ingredientItemLinkedList.add(ingredientItem);
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
            for (int i = 0; i < this.ingredientItemLinkedList.size(); i++) {
                if (this.ingredientItemLinkedList.get(i).getName().equals(ingredientItem.getName())) {
                    String temp = this.ingredientItemLinkedList.get(i).getName();
                    this.ingredientItemLinkedList.remove(i);
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
     * Method convert Ingredient Linked List to an Array List of String Printouts
     * @return
     */
    public ArrayList<String> convertToStringArrayList(){
        ArrayList<String> stringArrayList = new ArrayList<>();
        for(int i = 0; i < this.ingredientItemLinkedList.size(); i++){
            stringArrayList.add(this.ingredientItemLinkedList.get(i).toJSONString());
        }
        return stringArrayList;
    }

    /**
     * Method for Testing, Prints out all Items in the Ingredient Item Linked List
     */
    public void printDictionary(){
        ListIterator<IngredientItem> itr = this.ingredientItemLinkedList.listIterator(0);
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

        for(int i = 0; i < this.ingredientItemLinkedList.size(); i++){
            if(!this.ingredientItemLinkedList.get(i).getName().equals(ingredientItem.getName())){
                //TODO Record Changes
            }

            if(!this.ingredientItemLinkedList.get(i).getType().equals((ingredientItem.getType()))){
                //TODO Record Changes
            }

            if(this.ingredientItemLinkedList.get(i).getCost() != ingredientItem.getCost()){
                //TODO Record Changes
            }

            if(this.ingredientItemLinkedList.get(i).getWeight() != ingredientItem.getWeight()){
                //TODO Record Changes
            }

            if(!this.ingredientItemLinkedList.get(i).getMeasurementUnit().equals((ingredientItem.getMeasurementUnit()))){
                //TODO Record Changes
            }

            if(this.ingredientItemLinkedList.get(i).getQuantityOnHand() != ingredientItem.getQuantityOnHand()){
                //TODO Record Changes
            }
        }

        return changes;
    }
}

//hello
