import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Customers extends People{
    private final int ID;
    private String email;
    private String password;
    private boolean premium_member = false;
    public  Customers(String name, String surname, int dayOfBirth, int monthOfBirth, int yearOfBirth,String Password, String email, int ID){
        if(get_Customer_by_ID(ID) != null){
            this.ID = ID;
        }else{
            throw new IllegalArgumentException("ERROR: USER ALREADY EXISTS");
        }
        set_name(name);
        set_surname(surname);
        set_dateOfBirth(monthOfBirth,dayOfBirth,yearOfBirth);
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("ERROR: email can't be empty");

        }
        if(validate_email()){
            this.email = email;
        }else{
            throw new IllegalArgumentException("ERROR: email doesn't match the allowed expression");
        }
        if(validate_Password()){
            this.password = password;
        }

    }
    public int getID(){
        return this.ID;
    }
    public void setPremium_member(){
        this.premium_member = true;
    }
    public boolean validate_email(){

    }
    public boolean validate_Password(){
        boolean valid = true;
        final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        if (password == null) {
            valid = false;
        }
        Matcher matcher = pattern.matcher(password);
        if(!matcher.matches()){
            valid = false;
        }
        return valid;
    }

}