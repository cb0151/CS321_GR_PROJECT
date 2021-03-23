package com.company;

public class Calculations {

    private CalculationAction action;

    //TODO Return calculations
    public void Calculations(
            CalculationAction action,
            IngredientItem item,
            double amount){
        switch(action){
            case ADD:
                this.addToIngredient(item, amount);
                break;
            case SUBTRACT:
                this.subFromIngredient(item, amount);
                break;
            case DIVIDE:
                this.divideFromIngredient(item, amount);
                break;
            case MULTIPLY:
                this.multiplyIngredientBy(item, amount);
                break;
            case REMAINDER:
                this.remainderDivision(item, amount);
                break;
            case DIFFERENCE:
                this.differenceBetween(item, amount);
                break;
        }
    };

    public void addToIngredient(IngredientItem item,
                                double amount){


    }

    public void subFromIngredient(IngredientItem item,
                                  double amount){

    }

    public void divideFromIngredient(IngredientItem item,
                                     double amount){

    }

    public void multiplyIngredientBy(IngredientItem item,
                                     double amount){

    }

    public void differenceBetween(IngredientItem item,
                                  double amount){

    }

    public void remainderDivision(IngredientItem item,
                                  double amount){

    }
}
