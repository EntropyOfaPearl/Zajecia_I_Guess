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
        int pesel_num = String.valueOf(pesel).length();
        if(pesel_num == 11){
            if(Cinema.get_Staff_By_PESEL(pesel) != null){
                this.PESEL = pesel;
            }else{
                throw new IllegalArgumentException("ERROR: PESEL already exists");
            }
        }else{
            throw new IllegalArgumentException("Error: Make sure that the PESEL number is exactly 11 characters long");
        }
        set_name(name);
        set_surname(surname);
        set_gender(gender);
        set_dateOfBirth(monthOfBirth, dayOfBirth, yearOfBirth);
        this.salary = salary;
        this.position = position;
        if(Interface.validate_data(password, Interface.PASSWORD_REGEX)){
            this.password = Interface.hash_String(password);
        }else{
            throw new IllegalArgumentException("ERROR: email doesn't match the allowed expression");
        }
    }
    public void set_salary(float salary){
        this.salary = salary;
    }
    public void add_bonus(float bonus){
        this.salary += bonus;
    }
    public void change_value_by_precent(float precent){
        this.salary = this.salary + (this.salary * precent);
    }
    public void display_info(){
        int year = Year.now().getValue();
        int currentAge = year - getDateOfBirth().getYear();
        System.out.println("Name: "+getName()+" Surname: "+getSurame()+" sex: "+getGender()+" Date Of birth: "+getDateOfBirth()+" current Age: "+currentAge+" Position: "+this.position);
    }
    public float getSalary(){
        return this.salary;
    }
    public int getPESEL(){
        return this.PESEL;
    }
    public String getPosition(){
        return this.position;
    }
    public void set_Position(String position){
        this.position = position;
    }
    public void addComment(String comment){
        this.comments.add(comment);
    }
    public void set_Schedule(){
        String[] week_schedule = new String[7];
        Scanner scan =  new Scanner(System.in);
        System.out.println("For how many weeks? ");
        String user_input_weeks = scan.nextLine().toString();
        int weeks = Integer.parseInt(user_input_weeks);
        System.out.println(" Please insert data for the following month: ");
        for(int i = 0; i < weeks; i++){
            System.out.println("week "+(i+1)+": ");
            for(int j = 0; j < 7; j++){
                System.out.print("Please insert the working hours of "+getName()+" "+getSurame()+" for " + Interface.getNameDay(j+1));
                week_schedule[j] = scan.nextLine().toString();
            }
            this.schedule.add(week_schedule);

        }

    }
    public void clear_schedule(){
        this.schedule.clear();
    }
    public void display_list(){
        System.out.println("Displaying the schedule for the following month: ");
        for(int i = 0; i < this.schedule.size(); i++){
            System.out.println("Week "+(i+1)+": ");
            for(int j = 0; j < 7; j++){
                System.out.println(Interface.getNameDay(j+1)+": "+this.schedule.get(i)[j]);
            }
        }
    }
    public int get_PESEL(){
        return this.PESEL;
    }
    void set_password(String password) throws NoSuchAlgorithmException {
        if(Interface.validate_data(password, Interface.PASSWORD_REGEX)){
            this.password = Interface.hash_String(password);
        }else{
            throw new IllegalArgumentException("ERROR: email doesn't match the allowed expression");
        }
    }
    public static boolean log_in(int pesel, String password) throws NoSuchAlgorithmException, InterruptedException{
        Staff p =Cinema.get_Staff_By_PESEL(pesel);
        if(p.PESEL == pesel && 
            p.password == Interface.hash_String(password)
        ){
            System.out.println("Log in Successfull");
            Thread.sleep(2000);
            return true;
        }
        return false;
    }
}
