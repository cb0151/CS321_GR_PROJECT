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
        InventoryManager Manager = new InventoryManager(ingredientDictionary);
        System.out.println("Successfully loaded Inventory");


   }



}
//test


