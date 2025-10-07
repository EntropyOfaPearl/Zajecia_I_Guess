import java.time.LocalDate;
import java.util.ArrayList;
public class Movies extends Cinema{
    private float cost;
    private String title;
    private String originalTitle;
    private String genre;
    private Directors director;
    private String audio;
    private boolean subtitles;
    private LocalDate releaseDate;
    private String description;
    private double critic_ranking;
    private ArrayList<Double> audience_rating = new ArrayList<>();
    public static ArrayList<String> genre_list= new ArrayList<String>(); 
    public Movies(int cost,String title, String originalTitle, String genre, Directors director, String audio_lang, boolean sub,LocalDate release, String description, double critic_ranking){
        this.title = title;
        this.originalTitle = originalTitle;
        this.genre = genre;
        this.director = director;
        this.audio = audio_lang;
        this.subtitles = sub;
        this.releaseDate = release;
        this.cost = cost;
        Cinema.add_expense(cost);
        this.description =  description;
        this.critic_ranking = critic_ranking;
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
    public String get_audio_language(){
        return this.audio;
    }
    public boolean subbed(){
        return this.subtitles;
    }
    public String get_Desc(){
        return this.description;
    }
    public LocalDate get_releaseDate(){
        return this.releaseDate;
    }
    public void set_Title(String title){
        this.title = title;
    }
    public void set_subtitles(){
        this.subtitles = true;

    }
    public double get_critic_rating(){
        return this.critic_ranking;
    }
    public double get_audience_rating(){
        if(audience_rating.size()>0){
            double average = 0.00d;
            for(double r : audience_rating){
                average += r;
            }
            average /= audience_rating.size();
            return average;
        }else{
            System.out.println("There are no audience reviews for this movie yet :((");
            return (Double) null;
        }
    }
    public void display_info(){
        System.out.println("Title: "+this.title);
        System.out.println("Original title: "+this.originalTitle);
        System.out.println("genre:"+this.genre);
        System.out.println("Director: "+this.director.getName()+" "+this.director.getSurame());
        System.out.println("Audio language: "+this.audio);
        System.out.println("Is it subbed? : "+this.subtitles);
        System.out.println("Release date : "+this.releaseDate);
        System.out.println("Critic rating: "+this.critic_ranking);
        System.out.println("Audience rating: "+get_audience_rating());
    }
}
