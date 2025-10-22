package src.Cafe;
abstract public class Food {
    protected String name;
    protected double price;
    protected int amount_sold = 0;
    protected String description;
    public void sell(){
        amount_sold += 1;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public double getPrice(){
        return this.price;
    }
    public String getName(){
        return this.name;
    }
    public double calculateIncome(){
        double income = this.price * (double)this.amount_sold;
        return income;  
    }
    public int getAmountSold(){
        return this.amount_sold;
    }
}
