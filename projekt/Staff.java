import java.time.Year;
import java.util.ArrayList;
public class Staff extends People{
    private final int PESEL;
    private float salary;
    private String position;
    private ArrayList<String>comments = new ArrayList<String>();
    public Staff(String name, String surname, int pesel, int dayOfBirth, int monthOfBirth, int yearOfBirth, char gender, float salary, String position){
        int pesel_num = String.valueOf(pesel).length();
        if(pesel_num == 11){
            this.PESEL = pesel;
        }else{
            throw new IllegalArgumentException("Error: Make sure that the PESEL number is exactly 11 characters long");
        }
        set_name(name);
        set_surname(surname);
        set_gender(gender);
        set_dateOfBirth(monthOfBirth, dayOfBirth, yearOfBirth);
        this.salary = salary;
        this.position = position;
    }
    public void set_salary(float salary){
        this.salary = salary;
    }
    public void add_bonus(float bonus){
        this.salary += bonus;
    }
    public void change_value_by_precent(float precent){
        salary = salary + (salary * precent);
    }
    public void display_info(){
        int year = Year.now().getValue();
        int currentAge = year - getYearOfBirth();
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
    public void addComment(String comment){
        comments.add(comment);
    }
}
