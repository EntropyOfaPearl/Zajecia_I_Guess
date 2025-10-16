import java.util.ArrayList;

public class Cinema {
    private static ArrayList<Staff>cinema_staff = new ArrayList<Staff>();
    private static ArrayList<Movies>cinema_movies = new ArrayList<Movies>();
    private static ArrayList<Customers>cinema_Customers = new ArrayList<Customers>();
    private static ArrayList<Reservations>cinema_Reservations = new ArrayList<Reservations>();
    private static ArrayList<Screening_rooms>cinema_Screening_Rooms = new ArrayList<Screening_rooms>();
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
    public void set_income(float iincome){
        income = iincome;
    }
    public static void set_expenses(float eexpenses){
        expenses = eexpenses;
    }
    public static void add_expense(float mew_expenses){
        expenses += mew_expenses;
    }
    public static void add_income(float income){
        income+=income; 
    }
    public void add_staff(Staff personel){
        cinema_staff.add(personel);
    }
    public void add_movie(Movies movie){
        cinema_movies.add(movie);
    }
    public void add_customer(Customers client){
        cinema_Customers.add(client);
    }
    public void add_screening_room(Screening_rooms room){
        cinema_Screening_Rooms.add(room);
    }
    public void add_reservation(Reservations record){
        cinema_Reservations.add(record);
    }
    static public ArrayList<Staff> getCinema_staff(){
        return cinema_staff;
    }
    static public ArrayList<Movies> getCinema_movies(){
        return cinema_movies;
    }
    static public ArrayList<Customers> getCinema_Customers(){
        return cinema_Customers;
    }
    static public ArrayList<Reservations> getCinema_Reservations(){
        return cinema_Reservations;
    }
    static public ArrayList<Screening_rooms> getCinema_Screening_Rooms(){
        return cinema_Screening_Rooms;
    }
    static public Customers get_Customer_by_ID(int ID){
        Customers found = null;
        for(Customers person : cinema_Customers){
            if(person.getID() == ID){
                found = person;
            }
        }
        return found;
    }
   static public Staff get_Staff_By_PESEL(int PESEL){
        Staff found = null;
        for(Staff person : cinema_staff){
            if(person.getPESEL() == PESEL){
                found = person;
            }
        }
        return found;
    }
    public void delete_customer(Customers person){
        cinema_Customers.remove(person);
    }
    public void fire_staff(Staff person){
        cinema_staff.remove(person);
    }
    //1-staff, 2-Movies, 3-Reservations, 4-customers, 5-screening room
    public void displayList(int choice){
        switch (choice){
            case 1:
                System.out.println("List of staff: ");
                for(Staff person : cinema_staff){
                    person.display_info();
                    System.out.println(" ");
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                System.out.println("List of customers: ");
                for(Staff person : cinema_staff){
                    person.display_info();
                    System.out.println(" ");
                }

        }
    }
    public void add_to_schedule(Program p){
        schedule.add(p);
    }
    public static ArrayList<Program> get_schedule(){
        return schedule;
    }
}
