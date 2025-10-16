import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Directors extends People{
    private ArrayList<Movies> directed_movies = new ArrayList<Movies>();
    private final Year DEBUT;
    private ArrayList<String> awards = new ArrayList<String>();
    public Directors(String name, String surname,int monthOfBirth, int dayOfBirth, int yearOfBirth, char gender,int DEBUT){
        set_name(name);
        set_surname(surname);
        set_dateOfBirth(monthOfBirth, dayOfBirth, yearOfBirth);
        set_gender(gender);
        Year yearCurrent = Year.now();
        Year first_movie = Year.of(1903);
        if(Year.of(DEBUT).isAfter(yearCurrent) || Year.of(DEBUT).isBefore(first_movie)){
            this.DEBUT = Year.of(DEBUT);
        }else{
            throw new IllegalArgumentException("ERROR: IS INVALID DEBUT YEAR. CAN'T DEBUT IN THE FUTURE OR BEFORE MOVIES WERE CREATED");
        }
    }
    public void add_movie(Movies film){
        this.directed_movies.add(film);
    }
    public ArrayList<Movies> get_movie_list(){
        return this.directed_movies;
    }
    public void add_award(String award){
        this.awards.add(award);
    }
    public ArrayList<String> get_awards(){
        return this.awards;
    }
    public void display_info(){
        int currentAge = Year.now().getValue() - dateOfBirth.getYear();
        System.out.println("Name: "+name+" surname: "+surname+" age:"+ currentAge + " Date of birth: "+dateOfBirth + " Amount of awards: "+awards.size()+" Amount of directed Movies: "+ directed_movies.size()+" debut year: "+this.DEBUT);
    }
    public Year get_debut_year(){
        return this.DEBUT;
    }
    public void display_list(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which list to display 'm' for movies, 'a' for awards, b for both.");
        String input = scanner.nextLine().toString();
        switch(input){
            case "m":
                if(directed_movies.size() > 0){
                    int counter = 1;
                    System.out.println("This director has made the following movies:");
                    for(Movies m: directed_movies){
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("["+counter+"]: ");
                        m.display_info();
                    }
                }else{
                    System.out.println("This director's movies haven't been uploaded to our site yet");
                }
                break;
            case "a":
                if(awards.size() > 0){
                    System.out.println("The director got these awards: ");
                    for(String a: awards){
                        System.out.println(a);
                    }
                }else{
                    System.out.println("there are no awards to show :(");
                }
            break;
            default:
                System.out.println("ERROR: wrong choice selection :((");
        }
        
    }

}
