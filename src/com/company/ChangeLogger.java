package com.company;

import java.util.ArrayList;

public class ChangeLogger {

    private ArrayList<String> originalIngredientFile;
    private ArrayList<String> originalRecipeFile;
    //TODO Create other original Attributes that would need to be temporarly stored for Change Logging
    //TODO Methods that compare the Original to the New Read out to record changes, also to generate Reports

    public ChangeLogger() {
        originalIngredientFile = new ArrayList<>();
        originalRecipeFile = new ArrayList<>();
    }

    public ArrayList<String> getOriginalIngredientFile() {
        return originalIngredientFile;
    }

    public void setOriginalIngredientFile(ArrayList<String> originalIngredientFile) {
        this.originalIngredientFile = originalIngredientFile;
    }

    public ArrayList<String> getOriginalRecipeFile() {
        return originalRecipeFile;
    }

    public void setOriginalRecipeFile(ArrayList<String> originalRecipeFile) {
        this.originalRecipeFile = originalRecipeFile;
    }
}
