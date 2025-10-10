import java.security.NoSuchAlgorithmException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;
public class Staff extends People{
    private final int PESEL;
    private String password;
    private float salary;
    private String position;
    private ArrayList<String>comments = new ArrayList<String>();
    private ArrayList<String[]> schedule = new ArrayList<String[]>();
    public Staff(String name, String surname, int pesel, int dayOfBirth, int monthOfBirth, int yearOfBirth, char gender, float salary, String position, String password) throws NoSuchAlgorithmException{
        int peselNum = String.valueOf(pesel).length();
        if(peselNum == 11){
            if(Cinema.getStaffByPESEL(pesel) != null){
                this.PESEL = pesel;
            }else{
                throw new IllegalArgumentException("ERROR: PESEL already exists");
            }
        }else{
            throw new IllegalArgumentException("Error: Make sure that the PESEL number is exactly 11 characters long");
        }
        setName(name);
        setSurname(surname);
        setGender(gender);
        setDateOfBirth(monthOfBirth, dayOfBirth, yearOfBirth);
        this.salary = salary;
        this.position = position;
        if(Interface.validateData(password, Interface.PASSWORDREGEX)){
            this.password = Interface.hashString(password);
        }else{
            throw new IllegalArgumentException("ERROR: email doesn't match the allowed expression");
        }
    }
    public void setSalary(float salary){
        this.salary = salary;
    }
    public void addBonus(float bonus){
        this.salary += bonus;
    }
    public void changeValueByPrecent(float precent){
        this.salary = this.salary + (this.salary * precent);
    }
    public void displayInfo(){
        int year = Year.now().getValue();
        int currentAge = year - getDateOfBirth().getYear();
        System.out.println("Name: "+getName()+" Surname: "+getSurame()+" sex: "+getGender()+" Date Of birth: "+getDateOfBirth()+" current Age: "+currentAge+" Position: "+this.position);
    }
    public float getSalary(){
        return this.salary;
    }
    public String getPosition(){
        return this.position;
    }
    public void setPosition(String position){
        this.position = position;
    }
    public void addComment(String comment){
        this.comments.add(comment);
    }
    public void setSchedule(){
        String[] weekSchedule = new String[7];
        Scanner scan =  new Scanner(System.in);
        System.out.println("For how many weeks? ");
        String userInputWeeks = scan.nextLine().toString();
        int weeks = Integer.parseInt(userInputWeeks);
        System.out.println(" Please insert data for the following month: ");
        for(int i = 0; i < weeks; i++){
            System.out.println("week "+(i+1)+": ");
            for(int j = 0; j < 7; j++){
                System.out.print("Please insert the working hours of "+getName()+" "+getSurame()+" for " + Interface.getNameDay(j+1));
                weekSchedule[j] = scan.nextLine().toString();
            }
            this.schedule.add(weekSchedule);

        }

    }
    public void clearSchedule(){
        this.schedule.clear();
    }
    public void displayList(){
        System.out.println("Displaying the schedule for the following month: ");
        for(int i = 0; i < this.schedule.size(); i++){
            System.out.println("Week "+(i+1)+": ");
            for(int j = 0; j < 7; j++){
                System.out.println(Interface.getNameDay(j+1)+": "+this.schedule.get(i)[j]);
            }
        }
    }
    public int getPESEL(){
        return this.PESEL;
    }
    void setPassword(String password) throws NoSuchAlgorithmException {
        if(Interface.validateData(password, Interface.PASSWORDREGEX)){
            this.password = Interface.hashString(password);
        }else{
            throw new IllegalArgumentException("ERROR: email doesn't match the allowed expression");
        }
    }
    public static boolean logIn(int pesel, String password) throws NoSuchAlgorithmException, InterruptedException{
        Staff p =Cinema.getStaffByPESEL(pesel);
        if(p.PESEL == pesel && 
            p.password == Interface.hashString(password)
        ){
            System.out.println("Log in Successfull");
            Thread.sleep(2000);
            return true;
        }
        return false;
    }
}
