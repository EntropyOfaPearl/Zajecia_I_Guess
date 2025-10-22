package src.Reservations;
import src.People.*;
public class Reservation{
    private Customers customer;
    private Program screening;
    private Seats seat;
    private double total;
    public Reservation(Customers person, Program screening, Seats seat){
        this.customer = person;
        this.screening = screening;
        if(seat.getScreeningRoom() == screening.getRoom().getRoomNumber()){
            this.seat = seat;
        }
        if(customer.getMembershipStatus()){
            this.total  =  0.00d;
        }else{
            this.total = seat.getPrice();
        }
    }
    public Customers getCustomer(){
        return this.customer;
    }
    public Program getScreening(){
        return this.getScreening();
    }
    public double getTotal(){
        return this.total;
    }
    public void setDiscount(double discount){
        if(discount < 1 && discount >= 0){
            this.total *= discount;
        }
    }
    public void displayInfo(){
        System.out.println("Displaying the details of the reservations: ");
        System.out.printf("Name: %s %n Surname: %s %n ",this.customer.getName(), this.customer.getSurame());
        screening.displayInfo();
        seat.displayInfo();
        System.out.printf("Total: %fd",this.total);
    }
}
