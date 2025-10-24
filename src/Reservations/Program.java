package src.Reservations;
import src.CinemaManagment.*;
import java.time.DateTimeException;
import java.time.LocalDateTime;
public class Program  implements Interface{
    private LocalDateTime date;
    private Movies film;
    private ScreeningRooms room;
    private boolean ended;
    public Program(int hour,int minute, int day, int month, int year, Movies film, ScreeningRooms room){
        try{
            this.date.plusYears(year);
            this.date.plusMonths(month);
            this.date.plusDays(day);
            this.date.plusHours(hour);
            this.date.plusMinutes(minute);
        }catch(DateTimeException e){
            throw new IllegalArgumentException("ERROR: wrong time format bro :( Make sure you entered hours, minutes, days, months, years");
        }
        this.film = film;
        for(Program p : Cinema.getSchedule()){
            if(p.date == this.date && p.room == this.room){
                throw new IllegalArgumentException("Can not play different movies at the same time in the same room!!");
            }
        }
        this.room = room;
        is_Screening_Ended();
    }
    public boolean is_Screening_Ended(){
        LocalDateTime now = LocalDateTime.now(); 
        if(this.date.isBefore(now)){
            this.ended = true;
            return true;
        }
        this.ended = false;
        return false;
        
    }

    public LocalDateTime getDate(){
        return this.date;
    }
    public Movies getFilm(){
        return this.film;
    }
    public ScreeningRooms getRoom(){
        return this.room;
    }
    public void delay(int hh, int mm, String reason){
        this.date.plusHours(hh);
        this.date.plusMinutes(mm);
        System.out.println("Reason for delay: ");
        System.out.println(reason);
    }
    public void setRoom(ScreeningRooms room){
        this.room = room;
    }
    @Override
    public void displayInfo(){
        System.out.printf("Movie: %n %n");
        this.film.displayInfo();
        System.out.printf("Date: %tH : %tM %tp %n Screening room: %d %n is ended:",this.date,this.date,this.date,this.room.getRoomNumber(),this.is_Screening_Ended());

    }
 
}
