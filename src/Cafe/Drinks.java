package src.Cafe;

import src.CinemaManagment.Interface;

public class Drinks extends Food implements Interface{
    private int sizeInMl;
    final private boolean PLUS18;
    private String flavour;
    private boolean sugarfree;
    final private String CATEGORY;
    final private static String[]CATEGORIES = {"Energy drink", "Alcohol", "Soda","Water","Tea","Coffee","Ice tea", "Slushie"};
    public Drinks(String name, double price, String description, int size, boolean plus18, String flavour, boolean sugarfree,String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.sizeInMl = size;
        this.PLUS18 = plus18;
        this.flavour = flavour;
        this.sugarfree = sugarfree;
        if(categoryExists(category)){
            this.CATEGORY = category;
        }else{
            throw new IllegalArgumentException("ERROR: such category does not exist");
        }

    }
    public int getSize(){
        return this.sizeInMl;
    }
    public boolean is18plus(){
        return this.PLUS18;
    }
    public String getFlavour(){
        return this.flavour;
    }
    public void SetSize(int size){
        this.sizeInMl = size;
    }
    public void setFlavour(String flavour){
        this.flavour = flavour;
    }
    public boolean categoryExists(String category){
        for(int i = 0; i < CATEGORIES.length; i++){
            if(category.toLowerCase().equals(CATEGORIES[i].toLowerCase())){
                return true;
            }
        }
        return false;
    }
    @Override
    public void displayInfo(){
        System.out.printf("Name: %s %n %s size: %d ml flavour: %s sugarfree: %b",this.name, this.sizeInMl, this.flavour,this.sugarfree);
    }
    public String getCategory(){
        return this.CATEGORY;
    }

}
