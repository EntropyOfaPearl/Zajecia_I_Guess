package src.CinemaManagment;
import src.People.*;
import src.Reservations.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HexFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cinema {
    private static ArrayList<Staff>cinemaStaff = new ArrayList<Staff>();
    private static ArrayList<Movies>cinemaMovies = new ArrayList<Movies>();
    private static ArrayList<Customers>cinemaCustomers = new ArrayList<Customers>();
    private static ArrayList<Reservation>cinemaReservations = new ArrayList<Reservation>();
    private static ArrayList<ScreeningRooms>cinemaScreeningRooms = new ArrayList<ScreeningRooms>();
    private static ArrayList<Program>schedule = new ArrayList<Program>();
    private static HashMap<String, Double> POSITIONS = new HashMap<>();
    private static double income; 
    private static double expenses;
    private final static double MINIMUM_WAGE = 4806.00d;
    final String PASSWORDREGEX = "\"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$\"";
    public Cinema(double income, double expenses){
        Cinema.income = income;
        Cinema.expenses = expenses;
        POSITIONS.put("clerk",MINIMUM_WAGE*0.75);
        POSITIONS.put("barista",MINIMUM_WAGE);
        POSITIONS.put("cleaner",MINIMUM_WAGE*0.5);
        POSITIONS.put("manager",MINIMUM_WAGE*1.25);
        POSITIONS.put("CEO",99999999999999999999999.99d);
        POSITIONS.put("HR",MINIMUM_WAGE*1.4);

    }
    public double calculate_earnings(){
        double earnings = income - expenses;
        return earnings;
    }
    public static HashMap<String, Double> getPositions(){
        return POSITIONS;
    }
    public void setIncome(double iincome){
        income = iincome;
    }
    public static void setExpenses(double eexpenses){
        expenses = eexpenses;
    }
    public static void addExpense(double mew_expenses){
        expenses += mew_expenses;
    }
    public static void addIncome(double income){
        income+=income; 
    }
    public static void addStaff(Staff personel){
        cinemaStaff.add(personel);
    }
    public static void addMovie(Movies movie){
        cinemaMovies.add(movie);
    }
    public static void addCustomer(Customers client){
        cinemaCustomers.add(client);
    }
    public void addScreeningRoom(ScreeningRooms room){
        cinemaScreeningRooms.add(room);
    }
    public static void addReservation(Reservation record){
        cinemaReservations.add(record);
    }
    static public ArrayList<Staff> getCinemaStaff(){
        return cinemaStaff;
    }
    static public ArrayList<Movies> getCinemaMovies(){
        return cinemaMovies;
    }
    static public ArrayList<Customers> getCinemaCustomers(){
        return cinemaCustomers;
    }
    static public ArrayList<Reservation> getCinemaReservations(){
        return cinemaReservations;
    }
    static public ArrayList<ScreeningRooms> getCinemaScreening_Rooms(){
        return cinemaScreeningRooms;
    }
    static public Customers getCustomerByID(int ID){
        Customers found = null;
        for(Customers person : cinemaCustomers){
            if(person.getID() == ID){
                found = person;
            }
        }
        return found;
    }
    static public Customers getCustomerByEmail(String email){
        Customers found = null;
        for(Customers person : cinemaCustomers){
            if(person.getEmail().equals(email)){
                found = person;
            }
        }
        return found;
    }
   static public Staff getStaffByPESEL(String PESEL){
        Staff found = null;
        for(Staff person : cinemaStaff){
            if(person.getPESEL().equals(PESEL)){
                found = person;
            }
        }
        return found;
    }
    public static void deleteCustomer(Customers person){
        cinemaCustomers.remove(person);
    }
    public static void fireStaff(Staff person){
        cinemaStaff.remove(person);
    }
    public static double getWageByPosition(String position){
        return POSITIONS.get(position);
    }
    //1-staff, 2-Movies, 3-Reservations, 4-customers, 5-screening room
    public void displayList(int choice){
        switch (choice){
            case 1:
                System.out.println("List of staff: ");
                for(Staff person : cinemaStaff){
                    person.displayInfo();
                    System.out.println(" ");
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                System.out.println("List of customers: ");
                for(Staff person : cinemaStaff){
                    person.displayInfo();
                    System.out.println(" ");
                }

        }
    }
    public static void addToSchedule(Program p){
        schedule.add(p);
    }
    public static ArrayList<Program> getSchedule(){
        return schedule;
    }

    public static ScreeningRooms getRoomByNumber(int room_number) {
        for(ScreeningRooms s : cinemaScreeningRooms){
            if(s.getRoomNumber() ==  room_number){
                return s;
            }
        }
        return null;
    }
    public static ArrayList<Reservation> getAllCustomerReservations(Customers p){
        ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
        if(!reservationList.isEmpty()){
            for(Reservation r : cinemaReservations){
                if(r.getCustomer().getID() == p.getID()){
                    reservationList.add(r);
                }
            }
        }else{
            System.out.println("Sorry! there haven't been any reservations made yet :(");
        }
        return reservationList;

    }
    public double getIncome(){
        return Cinema.income;
    }
    public double getExpenses(){
        return Cinema.expenses;
    }

    
    public static String hashString(String text) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashbytes = digest.digest(text.getBytes(StandardCharsets.UTF_8));
        String hex = HexFormat.of().formatHex(hashbytes);
        return hex;
    }
   public static boolean validateData(String data, String reg_Exp){
        Pattern patternCheck = Pattern.compile(reg_Exp);
        Matcher matcher = patternCheck.matcher(data);
        if(matcher.matches()){
            return true;
        }
        return true;
    }
    public static String getNameDay(int day_number){
        switch(day_number){
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday??";
            case 7:
                return "Sunday (i think??)";
            default:
                throw new IllegalArgumentException("ERROR: not a valid day.");
        }
    }

    
}
