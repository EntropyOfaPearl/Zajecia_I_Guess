package src.Reservations;
import src.People.*;
import src.CinemaManagment.*;
import java.time.LocalDate;
import java.util.ArrayList;
public class Movies implements Interface{
    private float cost;
    private String title;
    private String originalTitle;
    private String genre;
    private Directors director;
    private String audio;
    private boolean subtitles;
    private LocalDate releaseDate;
    private String description;
    private double criticRanking;
    private ArrayList<Double> audienceRating = new ArrayList<>();
    public static ArrayList<String> genre_list= new ArrayList<String>(); 
    public Movies(int cost,String title, String originalTitle, String genre, Directors director, String audio_lang, boolean sub,LocalDate release, String description, double criticRanking){
        this.title = title;
        this.originalTitle = originalTitle;
        this.genre = genre;
        this.director = director;
        this.audio = audio_lang;
        this.subtitles = sub;
        this.releaseDate = release;
        this.cost = cost;
        Cinema.addExpense(cost);
        this.description =  description;
        this.criticRanking = criticRanking;
    }
    public Directors get_Director(){
        return this.director;
    }
    public String getTitle(){
        return this.title;
    }
    public String getOriginalTitle(){
        return this.originalTitle;
    }
    public String genre(){
        return this.genre;
    }
    public String getAudioLanguage(){
        return this.audio;
    }
    public boolean subbed(){
        return this.subtitles;
    }
    public String getDesc(){
        return this.description;
    }
    public LocalDate getReleaseDate(){
        return this.releaseDate;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setSubtitles(){
        this.subtitles = true;

    }
    public double getCriticRating(){
        return this.criticRanking;
    }
    public double getAudienceRating(){
        if(audienceRating.size()>0){
            double average = 0.00d;
            for(double r : audienceRating){
                average += r;
            }
            average /= audienceRating.size();
            return average;
        }else{
            System.out.println("There are no audience reviews for this movie yet :((");
            return (Double)null;
        }
    }
    @Override
    public void displayInfo(){
        System.out.println("Title: "+this.title);
        System.out.println("Original title: "+this.originalTitle);
        System.out.println("genre:"+this.genre);
        System.out.println("Director: "+this.director.getName()+" "+this.director.getSurame());
        System.out.println("Audio language: "+this.audio);
        System.out.println("Is it subbed? : "+this.subtitles);
        System.out.println("Release date : "+this.releaseDate);
        System.out.println("Critic rating: "+this.criticRanking);
        System.out.println("Audience rating: "+getAudienceRating());
    }
}
