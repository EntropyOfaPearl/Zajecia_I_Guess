package src.Cafe;
public class Sets extends Food{
    private Snacks snack;
    private Drinks drink;
    private int drinkAmount;
    private int snackAmount;
    public Sets(String name, String description, Snacks snack, Drinks drink, int drinkA, int snackA) {
        this.name = name;
        this.description = description;
        this.drink=drink;
        this.snack = snack;
        this.drinkAmount = drinkA;
        this.snackAmount = snackA;
        this.price =((snackA * snack.getPrice()) + (drinkA * drink.getPrice()))*0.75;

    }
    public void displayInfo(){
        System.out.printf("%s %.2f $    : %n %s %n",this.name, this.price, this.description);
        System.out.printf("The %s set includes: %n %d x %s , %n %d x %s",this.name, this.snackAmount, this.snack.getName(),this.drinkAmount, this.drink.getName());
    }
    public void setAmount(int drinkAmount, int snackAmount){
        this.drinkAmount = drinkAmount;
        this.snackAmount = snackAmount;
    }
    public void setDrink(Drinks drink) {
        this.drink = drink;
    }
    public void setSnack(Snacks snack){
        this.snack = snack;
    }
    public Snacks getSnack(){
        return this.snack;
    }
    public Drinks getDrink(){
        return this.drink;
    }
    //how to write quantaty ?? is there an 'i'in there?? am I dyslexic
    public int getDrinkQuantaty(){
        return this.drinkAmount;
    }
    public int getSnackQuantaty(){
        return this.drinkAmount;
    }
}