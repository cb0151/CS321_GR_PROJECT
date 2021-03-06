package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class ChangeLogger {

    private ArrayList<String> originalIngredientFile;
    private ArrayList<String> originalRecipeFile;
    private ArrayList<String> changesMade;
    private static final String changeLogFilePath = "DataSource/ChangeLog.json";
    //TODO Create other original Attributes that would need to be temporarily stored for Change Logging
    //TODO Methods that compare the Original to the New Read out to record changes, also to generate Reports

    public ChangeLogger() {
        this.originalIngredientFile = new ArrayList<>();
        this.originalRecipeFile = new ArrayList<>();
        this.changesMade = new ArrayList<>();
        this.createChangeLogFile();
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

    /**
     * Method to Record the Change Being Made
     * @param action    The Enumerated Type ChangeLoggerAction to be recorded
     * @param original  The Original Item if Updating Item
     * @param change    The Changed Item if Updating Item
     */
    public void recordIngredientChange(ChangeLoggerAction action, IngredientItem original, IngredientItem change){
        switch (action){
            case ADD:
                //Adds the Items to Added to the Change Made ArrayList
                this.changesMade.add("{\"ChangeAction\" : \"ADDED\", \"" +
                        "name\" : \"" + original.getName() + "\", \"" +
                        "type\" : \"" + original.getType() + "\", \"" +
                        "measurementUnit\" : \"" + original.getMeasurementUnit() + "\", \"" +
                        "cost\" : \"" + original.getCost() + "\", \"" +
                        "weight\" : \"" + original.getWeight()+ "\", \"" +
                        "quantityOnHand\" : \"" + original.getQuantityOnHand() + "\", \"" +
                        "lastUsedDate\" : \"" + original.getLastUsedDate() + "\"}");
                break;
            case DELETE:
                //Adds the Item to be Deleted to the Changes Made ArrayList
                this.changesMade.add("{\"ChangeAction\" : \"DELETED\", \"" +
                        "name\" : \"" + original.getName() + "\", \"" +
                        "type\" : \"" + original.getType() + "\", \"" +
                        "measurementUnit\" : \"" + original.getMeasurementUnit() + "\", \"" +
                        "cost\" : \"" + original.getCost() + "\", \"" +
                        "weight\" : \"" + original.getWeight()+ "\", \"" +
                        "quantityOnHand\" : \"" + original.getQuantityOnHand() + "\", \"" +
                        "lastUsedDate\" : \"" + original.getLastUsedDate() + "\"}");
                break;
            case UPDATE:
                //Adds the Updating Item Original and New to the Changes Made ArrayList
                this.changesMade.add("{\"ChangeAction\" : \"UPDATED\", \"" +
                        "name\" : \"" + original.getName() + "\", \"" +
                        "type\" : \"" + original.getType() + "\", \"" +
                        "measurementUnit\" : \"" + original.getMeasurementUnit() + "\", \"" +
                        "cost\" : \"" + original.getCost() + "\", \"" +
                        "weight\" : \"" + original.getWeight()+ "\", \"" +
                        "quantityOnHand\" : \"" + original.getQuantityOnHand() + "\", \"" +
                        "lastUsedDate\" : \"" + original.getLastUsedDate() + "\"}");
                //Adding the Changed item
                this.changesMade.add("{\"ChangeAction\" : \"UPDATED\", \"" +
                        "name\" : \"" + change.getName() + "\", \"" +
                        "type\" : \"" + change.getType() + "\", \"" +
                        "measurementUnit\" : \"" + change.getMeasurementUnit() + "\", \"" +
                        "cost\" : \"" + change.getCost() + "\", \"" +
                        "weight\" : \"" + change.getWeight()+ "\", \"" +
                        "quantityOnHand\" : \"" + change.getQuantityOnHand() + "\", \"" +
                        "lastUsedDate\" : \"" + change.getLastUsedDate() + "\"}");
                break;
            default:
                //TODO exception handling here
                break;
        }
    }


    public void beforeClosing(){

        FileManager changeFile = new FileManager(changeLogFilePath);
        changeFile.appendToFile(changesMade,FileType.CHANGELOG);

    }

    private boolean createChangeLogFile(){
        //TODO INCOMPLETE METHOD
        FileManager newFile = new FileManager(changeLogFilePath);
        newFile.createFile();
        try {
            newFile.generateJSONFile(FileType.CHANGELOG);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(newFile.fileExists() == true) return true;
        else return false;
    }
    public void compareToOriginal(){

    }
}
