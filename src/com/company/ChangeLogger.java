package com.company;

import java.util.ArrayList;

public class ChangeLogger {

    private ArrayList<String> originalIngredientFile;
    private ArrayList<String> originalRecipeFile;
    private ArrayList<String> changesMade;
    //TODO Create other original Attributes that would need to be temporarly stored for Change Logging
    //TODO Methods that compare the Original to the New Read out to record changes, also to generate Reports

    public ChangeLogger() {
        originalIngredientFile = new ArrayList<>();
        originalRecipeFile = new ArrayList<>();
    }

    public ArrayList<String> getOriginalIngredientFile() {
        return originalIngredientFile;
    }

    /**
     * Method Needs the Original Read In Array String to save in this array directly
     * Using a Deep Copy.
     * @param originalIngredientFile    The Original Ingredient File Array List of Strings
     */
    public void setOriginalIngredientFile(ArrayList<String> originalIngredientFile) {
        for(int i = 0; i < originalIngredientFile.size(); i++){
            this.originalIngredientFile.add(originalIngredientFile.get(i));
        }
    }

    public ArrayList<String> getOriginalRecipeFile() {
        return originalRecipeFile;
    }

    public void setOriginalRecipeFile(ArrayList<String> originalRecipeFile) {
        for(int i = 0; i < originalRecipeFile.size(); i++){
            this.originalRecipeFile.add(originalRecipeFile.get(i));
        }
    }
    public void recordIngredientChange(String action, IngredientItem original, IngredientItem change){
        //TODO add methods to add to the "changesMade" array list using the "appendToFile" method in File Manager
        switch (action){
            case "Add":
                //TODO add method to record that an add ingredient has occurred
                break;
            case "Delete":
                //TODO add method to record that a delete ingredient has occurred
                break;
            case "Update":
                //TODO add method to record that an update ingredient has occurred
                break;
            default:
                //TODO exception handling here
                break;
        }
    }


    public void compareToOriginal(){

    }
}
