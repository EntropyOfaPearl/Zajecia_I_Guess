import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Year;

abstract public class People{
    protected String name;
    protected String surname;
    protected LocalDate dateOfBirth;
    protected char gender = 'n';

    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String name){
        this.surname = name;
    }
    public void setDateOfBirth(int monthOfBirth, int dayOfBirth, int yearOfBirth){
        int yearCurrent = Year.now().getValue();
        if(yearOfBirth >=yearCurrent-13 ){
            throw new IllegalArgumentException("ERROR: you are too young. You must be 13 or older to use the service :((  (we sell your data to CCP <3)");
        }
        if(yearOfBirth < 1911){
            throw new IllegalArgumentException("ERROR: don't lie about your age online so blantly -_-, you were not buddies with Piłusudzki");
        }
        try{
            this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        }catch(DateTimeException e){
            throw new IllegalArgumentException("ERROR: invalid date of birth. please make ssure it is set up as yyy:mm:dd");
        }
    }
    public void setGender(char gender){
        if(gender == 'f' || gender == 'm'){
            this.gender = gender;
        }else{
            throw new IllegalArgumentException("ERROR: Please set your sex as either male or female.");
        }
    }    
    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }
    public String getName(){
        return this.name;
    }
    public String getSurame(){
        return this.surname;
    }
    public char getGender(){
        return this.gender;
    }

}
