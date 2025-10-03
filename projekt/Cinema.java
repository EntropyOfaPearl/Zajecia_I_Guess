import java.util.ArrayList;

public class Cinema {
    private static ArrayList<Staff>cinema_staff = new ArrayList<Staff>();
    private static ArrayList<Movies>cinema_movies = new ArrayList<Movies>();
    private static ArrayList<Customers>cinema_Customers = new ArrayList<Customers>();
    private static ArrayList<Reservations>cinema_Reservations = new ArrayList<Reservations>();
    private static ArrayList<Screening_rooms>cinema_Screening_Rooms = new ArrayList<Screening_rooms>();
    private float income;
    private float expenses;
    public Cinema(float income, float expenses){
        this.income = income;
        this.expenses = expenses;
    }

    public Cinema() {
    }

    public float calculate_earnings(){
        float earnings = this.income - this.expenses;
        return earnings;
    }
    public void set_income(float income){
        this.income = income;
    }
    public void set_expenses(float expenses){
        this.expenses = expenses;
    }
    public void add_expense(float mew_expenses){
        this.expenses += mew_expenses;
    }
    public void add_staff(Staff personel){
        cinema_staff.add(personel);
    }
    public void add_movie(Movies movie){
        cinema_movies.add(movie);
    }
    public void add_cusromer(Customers client){
        cinema_Customers.add(client);
    }
    public void add_screening_room(Screening_rooms room){
        cinema_Screening_Rooms.add(room);
    }
    public void add_reservation(Reservations record){
        cinema_Reservations.add(record);
    }
    public ArrayList<Staff> getCinema_staff(){
        return cinema_staff;
    }
    public ArrayList<Movies> getCinema_movies(){
        return cinema_movies;
    }
    public ArrayList<Customers> getCinema_Customers(){
        return cinema_Customers;
    }
    public ArrayList<Reservations> getCinema_Reservations(){
        return cinema_Reservations;
    }
    public ArrayList<Screening_rooms> getCinema_Screening_Rooms(){
        return cinema_Screening_Rooms;
    }
    public Customers get_Customer_by_ID(int ID){
        Customers found = null;
        for(Customers person : cinema_Customers){
            if(person.getID() == ID){
                found = person;
            }
        }
        return found;
    }
    public Staff get_Staff_By_PESEL(int PESEL){
        Staff found = null;
        for(Staff person : cinema_staff){
            if(person.getPESEL() == PESEL){
                found = person;
            }
        }
        return found;
    }
    //1-staff, 2-Movies, 3-Reservations, 4-customers, 5-screening room
    public void displayList(int choice){
        switch (choice){
            case 1:
                for(Staff person : cinema_staff){
                    person.display_info();
                    System.out.println(" ");
                }
                break;
            case 2:

        }
    }
}
