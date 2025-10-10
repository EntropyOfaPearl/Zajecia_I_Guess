import java.util.ArrayList;

public class Cinema {
    private static ArrayList<Staff>cinemaStaff = new ArrayList<Staff>();
    private static ArrayList<Movies>cinemaMovies = new ArrayList<Movies>();
    private static ArrayList<Customers>cinemaCustomers = new ArrayList<Customers>();
    private static ArrayList<Reservations>cinemaReservations = new ArrayList<Reservations>();
    private static ArrayList<ScreeningRooms>cinemaScreeningRooms = new ArrayList<ScreeningRooms>();
    private static ArrayList<Program>schedule = new ArrayList<Program>();
    private static float income;
    private static float expenses;
    public Cinema(float income, float expenses){
        Cinema.income = income;
        Cinema.expenses = expenses;
    }

    public Cinema() {
    }

    public float calculate_earnings(){
        float earnings = income - expenses;
        return earnings;
    }
    public void setIncome(float iincome){
        income = iincome;
    }
    public static void setExpenses(float eexpenses){
        expenses = eexpenses;
    }
    public static void addExpense(float mew_expenses){
        expenses += mew_expenses;
    }
    public static void addIncome(float income){
        income+=income; 
    }
    public void addStaff(Staff personel){
        cinemaStaff.add(personel);
    }
    public void addMovie(Movies movie){
        cinemaMovies.add(movie);
    }
    public void addCustomer(Customers client){
        cinemaCustomers.add(client);
    }
    public void addScreeningRoom(ScreeningRooms room){
        cinemaScreeningRooms.add(room);
    }
    public void addReservation(Reservations record){
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
    static public ArrayList<Reservations> getCinemaReservations(){
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
   static public Staff getStaffByPESEL(int PESEL){
        Staff found = null;
        for(Staff person : cinemaStaff){
            if(person.getPESEL() == PESEL){
                found = person;
            }
        }
        return found;
    }
    public void deleteCustomer(Customers person){
        cinemaCustomers.remove(person);
    }
    public void fireStaff(Staff person){
        cinemaStaff.remove(person);
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
    public void addToSchedule(Program p){
        schedule.add(p);
    }
    public static ArrayList<Program> getSchedule(){
        return schedule;
    }
}
