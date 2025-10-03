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
}
