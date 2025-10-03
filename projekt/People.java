import java.time.Year;

abstract public class People{
    private String name = new String();
    private String surname = new String();
    private String dateOfBirth = new String();
    private char gender = 'n';
    public void set_name(String name){
        this.name = name;
    }
    public void set_surname(String name){
        this.surname = name;
    }
    public void set_dateOfBirth(int monthOfBirth, int dayOfBirth, int yearOfBirth){
        int year = Year.now().getValue();
        if(yearOfBirth > year - 13){
            throw new IllegalArgumentException("Error: You are not old enough to register. Please ask your parent to create an account");
        }
        if(yearOfBirth < 1910){
            throw new IllegalArgumentException("Error: Please use your real date of birth."); 
        }
        if(monthOfBirth < 1 || monthOfBirth > 12 ){
            throw new IllegalArgumentException("Error: There are only 12 months in a year."); 
        }
        boolean leap_year = false;
        switch (monthOfBirth) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(!(dayOfBirth >= 1 && dayOfBirth <=31)){
                    throw new IllegalArgumentException("ERROR: inavlid day of the month");
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(!(dayOfBirth >= 1 && dayOfBirth <=30)){
                    throw new IllegalArgumentException("ERROR: inavlid day of the month");
                }
                break;
            case 2:
                if(yearOfBirth % 4 == 0){
                    if(yearOfBirth % 100 == 0){
                        if(yearOfBirth % 400 == 0){
                            leap_year = true;
                        }
                    }else{
                        leap_year = true;
                    }
                }
                if(!leap_year){
                    if(!(dayOfBirth > 1 && dayOfBirth <= 28)){
                        throw new IllegalArgumentException("ERROR: Febuary on not a leap year only has 28 days.");
                    }
                }else{
                    if(!(dayOfBirth > 1 && dayOfBirth <= 29)){
                        throw new IllegalArgumentException("ERROR: Febuary on a leap year only has 29 days.");                        
                    }
                }
                break;
        }
        if(dayOfBirth < 10){
            this.dateOfBirth+="0"+dayOfBirth+".";
        }else{
            this.dateOfBirth+=dayOfBirth+".";
        }
        if(monthOfBirth < 10){
            this.dateOfBirth+="0"+monthOfBirth+".";
        }else{
            this.dateOfBirth+=monthOfBirth+".";
        }
        this.dateOfBirth+=yearOfBirth;
        }
    public void set_gender(char gender){
        if(gender == 'f' || gender == 'm'){
            this.gender = gender;
        }else{
            throw new IllegalArgumentException("ERROR: Please set the gender as either male or female.");
        }
    }
    public String getDateOfBirth(){
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
    public int getYearOfBirth(){
        String yearStr = this.dateOfBirth.substring(6,10 );
        int year = Integer.parseInt(yearStr);
        return year;
    }
    public int getMonthOfBirth(){
        String yearStr = this.dateOfBirth.substring(3,5 );
        int year = Integer.parseInt(yearStr);
        return year;
    }
    public int getDayOfBirth(){
        String yearStr = this.dateOfBirth.substring(0,2 );
        int year = Integer.parseInt(yearStr);
        return year;
    }

}
