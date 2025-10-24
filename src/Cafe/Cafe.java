package src.Cafe;
import src.CinemaManagment.*;
import src.People.*;
import java.time.*;
import java.util.ArrayList;
import static java.lang.Integer.parseInt;


public class Cafe implements Interface{
    //menus are static because they'll stay the same in different bars
    static private ArrayList <Snacks> menuSnacks = new ArrayList<Snacks>();
    static private ArrayList <Drinks> menuDrinks = new ArrayList<Drinks>();
    static private ArrayList <Sets> menuSets = new ArrayList<Sets>();
    private LocalDateTime openingHour;
    private LocalDateTime closingHour;
    private  ArrayList<String> FDAViolations;
    private boolean open;
    Staff barista;
    public Cafe (int opening_hh,int opening_mm,int closing_hh,int closing_mm, boolean open, Staff barista) {
        try{
            this.openingHour.plusHours(opening_hh);
            this.openingHour.plusMinutes(opening_mm);
            this.closingHour.plusHours(closing_hh);
            this.closingHour.plusMinutes(closing_mm);
        }catch(DateTimeException e){
            throw new DateTimeException("ERROR: wong time format :((");
        }
        this.open = open;
        this.barista = barista;
    }
    public static ArrayList <Drinks> getDrinkMenu(){
        return menuDrinks;
    }
    public static ArrayList <Snacks> getSnackMenu(){
        return menuSnacks;
    }
    public static ArrayList <Sets> getSetMenu(){
        return menuSets;
    }
    public void openLater(int hh, int mm){
        openingHour.plusHours(hh);
        openingHour.plusMinutes(mm);
    }
    public void setBarista(Staff b){
        this.barista = b;
    }
    public Staff getBarista(){
        return this.barista;
    }
    public void setOpeningStatus(boolean open){
        this.open = open;
    }
    public LocalDateTime getOpeningHour(){
        return this.openingHour;
    }
    public LocalDateTime getClosingHour(){
        return this.closingHour;
    }    
    public void opeEarly(int hh, int mm){
        openingHour.minusHours(hh);
        openingHour.minusMinutes(mm);
    }
    public boolean isOpen(){
        return this.open;
    }
    public static void addToSnacks(Snacks snack){
        menuSnacks.add(snack);
    }
    public static void addToDrinks(Drinks drink){
        menuDrinks.add(drink);
    }
    public static void addToSets(Sets set){
        menuSets.add(set);
    }
    public void addFDAViolations(String violation){
        this.FDAViolations.add(violation);
    }
    public double getFinalPrice(Customers p, double price){
        double discountPremium;
        if(p.getMembershipStatus()){
            discountPremium = 0.75d;
        }else discountPremium = 1;
        double discountFromDay;
        LocalDate now = LocalDate.now();
        DayOfWeek day = DayOfWeek.from(now);
        switch (day){
            case MONDAY:
                discountFromDay = 0.80d;
                break;
            case TUESDAY:
                discountFromDay = 1d;
                break;
            case WEDNESDAY:
                discountFromDay = 1.10d;
                break;
            case THURSDAY:
                discountFromDay = 1.50d;
                break;
            case FRIDAY:
                discountFromDay = 4d;
                break;
            case SATURDAY:
                discountFromDay =10d;
                break;
            case SUNDAY:
                discountFromDay = 0.50;
                break;
            default:
                discountFromDay = 1d;
                break;
        }
        double discountFromGender;
        if(p.getGender() == 'm'){
            discountFromGender = 1.1d;
        }else discountFromGender = 1d;
        double discountfromAge;
        int y= parseInt(String.valueOf(Year.from(p.getDateOfBirth())));
        int age = parseInt(String.valueOf(Year.now().minusYears(y)));
        if(age < 21 || age > 65){
            discountfromAge = 0.40d;
        }else discountfromAge = 1d;
        
        return price * discountfromAge * discountFromGender * discountFromDay * discountPremium;



    }
    
    public void sellDrink(Drinks d, Customers p){
        int y= Integer.parseInt(String.valueOf(Year.from(p.getDateOfBirth())));
        int age = Integer.parseInt(String.valueOf(Year.now().minusYears(y)));
        if(age < 18 && d.is18plus()){
            System.out.println("user is not old enough to buy this womp womp");
            return;
        }
        double totalPrice = getFinalPrice(p, d.getPrice());
        Cinema.addIncome(totalPrice);
        d.sell();
    }
    public void sellSnack(Snacks s, Customers p){
        double totalPrice = getFinalPrice(p, s.getPrice());
        Cinema.addIncome(totalPrice);
        s.sell();
    }
    public void sellSet(Sets s, Customers p){
        double totalPrice = getFinalPrice(p, s.getPrice());
        Cinema.addIncome(totalPrice);
        s.sell();
    }    
    public void displayViolations(){
        System.out.printf("The cafe has %d violations. %n", this.FDAViolations.size());
        for(String violation : FDAViolations){
            System.out.printf("Description: %s %n",violation);
        }
    }
    public static ArrayList<Drinks> getDrinkByCategory(String category){
        ArrayList<Drinks> drinkFound = new ArrayList<Drinks>();
        for(Drinks d : menuDrinks){
            if(d.getCategory().toLowerCase().equals(category.toLowerCase())){
                drinkFound.add(d);
            }
        }
        return drinkFound;
    }

    
    static public void displayListStatic(){
        System.out.printf("Menu: %n %n");
        int iterator = 1;
        System.out.printf("Snacks: %n");
        for(Snacks s : menuSnacks){
            System.out.printf("%d . %s  %n", iterator, s.getName());
            iterator+=1;
        }
        System.out.printf("%n Drinks: %n %n");
        System.out.printf("Sodas: %n");
        ArrayList<Drinks> soda = getDrinkByCategory("Soda");
        for(Drinks d : soda){
            System.out.printf("%d . %s  %n", iterator, d.getName());
            iterator+=1;
        }
        ArrayList<Drinks> water = getDrinkByCategory("Water");
        for(Drinks d : water){
            System.out.printf("%d . %s  %n", iterator, d.getName());
            iterator+=1;
        }
        ArrayList<Drinks> tea = getDrinkByCategory("Tea");
        for(Drinks d : tea){
            System.out.printf("%d . %s  %n", iterator, d.getName());
            iterator+=1;
        }
        ArrayList<Drinks> coffee = getDrinkByCategory("coffee");
        for(Drinks d : coffee){
            System.out.printf("%d . %s  %n", iterator, d.getName());
            iterator+=1;
        }
        ArrayList<Drinks> alcohol = getDrinkByCategory("alcohol");
        for(Drinks d : alcohol){
            System.out.printf("%d . %s  %n", iterator, d.getName());
            iterator+=1;
        }
        ArrayList<Drinks> energyDrinks  = getDrinkByCategory("energy Drinks");
        for(Drinks d : energyDrinks){
            System.out.printf("%d . %s  %n", iterator, d.getName());
            iterator+=1;
        }
        System.out.printf("Sets: %n");
        for(Sets s : menuSets){
            System.out.printf("%d . %s  %n", iterator, s.getName());
            iterator+=1;
        }
        System.out.println("Please understand that to enchance user experience we choose not to display prices on the menu. Your total will be shown to you at checkout as we have implemented dynamic pricing to ensure our customers get the experience best tailored to them.");
    }
    public static void getSnackByName(){

    }
    @Override
    public void displayInfo(){
        System.out.printf("Open from %s : %s to %s : %s  open: %b current staff: %s %n", this.openingHour.getHour() , this.openingHour.getMinute(),this.closingHour.getHour() , this.closingHour.getMinute(),this.open, this.barista.getName());
    }
}
