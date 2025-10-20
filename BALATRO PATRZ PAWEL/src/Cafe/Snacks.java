package src.Cafe;

import java.util.ArrayList;

public class Snacks extends Food{
    private int sizeGrams;
    private ArrayList<String> allergens = new ArrayList<String>();
    public Snacks(String name, double price, String description, int size){
        this.name = name;
        this.price = price;
        this.description = description;
        this.sizeGrams = size;
    }
    public void addAllergens(String allergen){
        this.allergens.add(allergen);
    }
    public void changeSize(int size){
        this.sizeGrams = size;
    }
    public void displayList(){
        int counter = 1;
        System.out.print("Displaying the list of allergens: %n ");
        if(!this.allergens.isEmpty()){
            for(String a:this.allergens){
                System.out.printf("[ %d ]: %s %n",counter, a);
                counter+=1;
            }
        }else{
            System.out.println("this product has no allergens.");
        }
    }
    public void displayInfo(){
        System.out.printf("%s %n %s %n size: %d g. ", this.name, this.description, this.sizeGrams);
        displayList();
    }
    public int getSize(){
        return this.sizeGrams;
    }
    public ArrayList<String> getAllergenList(){
        return this.allergens;
    }
    
}
