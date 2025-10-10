import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Directors extends People{
    private final ArrayList<Movies> directedMovies = new ArrayList<Movies>();
    private final Year DEBUT;
    private final ArrayList<String> awards = new ArrayList<String>();
    public Directors(String name, String surname,int monthOfBirth, int dayOfBirth, int yearOfBirth, char gender,int DEBUT){
        setName(name);
        setSurname(surname);
        setDateOfBirth(monthOfBirth, dayOfBirth, yearOfBirth);
        setGender(gender);
        Year yearCurrent = Year.now();
        Year firstMovie = Year.of(1903);
        if(Year.of(DEBUT).isAfter(yearCurrent) || Year.of(DEBUT).isBefore(first_movie)){
            this.DEBUT = Year.of(DEBUT);
        }else{
            throw new IllegalArgumentException("ERROR: IS INVALID DEBUT YEAR. CAN'T DEBUT IN THE FUTURE OR BEFORE MOVIES WERE CREATED");
        }
    }
    public void add_movie(Movies film){
        this.directedMovies.add(film);
    }
    public ArrayList<Movies> get_movie_list(){
        return this.directedMovies;
    }
    public void add_award(String award){
        this.awards.add(award);
    }
    public ArrayList<String> get_awards(){
        return this.awards;
    }
    public void display_info(){
        int currentAge = Year.now().getValue() - dateOfBirth.getYear();
        System.out.printf("Name: %s surname: %s age: %d Date of birth: %tF Amount of awards: %d Amount of directed Movies: %d debut year: %tY",this.name, this.surname, currentAge, this.dateOfBirth, this.awards.size(),this.directedMovies.size(),this.DEBUT);
    }
    public Year get_debut_year(){
        return this.DEBUT;
    }
    public void display_list(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which list to display 'm' for movies, 'a' for awards, b for both.");
        String input = scanner.nextLine();
        switch(input){
            case "m":
                if(!directedMovies.isEmpty()){
                    int counter = 1;
                    System.out.println("This director has made the following movies:");
                    for(Movies m: directedMovies){
                        System.out.println();
                        System.out.println("["+counter+"]: ");
                        m.display_info();
                    }
                }else{
                    System.out.println("This director's movies haven't been uploaded to our site yet");
                }
                break;
            case "a":
                if(!awards.isEmpty()){
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
