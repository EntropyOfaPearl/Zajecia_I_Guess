import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Cafe{
    ArrayList <Food> menu = new ArrayList<Food>();
    private LocalDateTime openingHour;
    private LocalDateTime closingHour;
    private  ArrayList<String> FDAViolations;
    Staff barista;
    public Cafe(int hh,int mm) {
        try{
            this.openingHour.plusHours(hh);
            this.openingHour.plusMinutes(mm);
        }catch(DateTimeException e){
            throw new DateTimeException("ERROR: wong time format :((");
        }
    }
    public void addToMenu(Food food){
        this.menu.add(food);
    }
    public void addFDAViolations(String violation){
        this.FDAViolations.add(violation);
    }
    public void sell(Food food, Customers p){
        double discountPremium;
        if(p.getMembershipStatus()){
            discountPremium = 0.75d;
        }
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
        if(age < 18 &&
        double totalPrice = food.price * discountfromAge * discountFromGender * discountFromDay;
        Cinema.addIncome(totalPrice);
    }


}
