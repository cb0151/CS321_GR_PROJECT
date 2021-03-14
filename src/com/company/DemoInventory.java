package com.company;

import java.io.IOException;

public class DemoInventory {

    FileManager FileManager = new FileManager("DataSource/ingredients.json");
    IngredientFactory testFactory = new IngredientFactory();
    IngredientDictionary ingredientDictionary;

    public DemoInventory(){

        this.createDictionary();
        testInventory();
    }

    public void createDictionary(){
        try {
            FileManager.generateStringArrayList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileManager.createObjectArray();
        testFactory.startFactory(FileManager.getObjectArrayList());
        ingredientDictionary = new IngredientDictionary(testFactory.getList());
        try {
            FileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   public void testInventory(){
        System.out.println("Initialize Inventory");
        InventoryManager Manager = new InventoryManager();
        System.out.println("Successfully loaded Inventory");
        double curcost = Manager.curInventoryCost();
        double initcost = Manager.initialInventorycost;
        //IngredientItem test = Manager.searchIngredient("BEEFS BROTH");
        Manager.removeIngredient(Manager.searchIngredient("BEEFS BROTH"));
        Manager.removeIngredient(Manager.searchIngredient("BROWN SUGAR"));
        double newcost = Manager.curInventoryCost();
        System.out.println("Initial Cost: "+initcost);
       System.out.println("Current Cost: "+newcost);
       System.out.println("Also Initial Cost: "+curcost);

   }



}
//test
//final test for the night before I give up

