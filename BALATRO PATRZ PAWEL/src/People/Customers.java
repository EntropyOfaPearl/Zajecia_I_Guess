package src.People;
import src.CinemaManagment.*;
import java.security.NoSuchAlgorithmException;

public class Customers extends People{
    private final int ID;
    private String email;
    private String password;
    private boolean premiumMember = false;
    private String[] cardInfo = new String[3]; 
    private int points = 0;
    public  Customers(String name, String surname, int dayOfBirth, int monthOfBirth, int yearOfBirth,String password, String email, char gender)throws NoSuchAlgorithmException{
        int last = Cinema.getCinemaCustomers().size()+1;
        this.ID = last;
        setName(name);
        setSurname(surname);
        setDateOfBirth(monthOfBirth,dayOfBirth,yearOfBirth);
        setGender(gender);
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("ERROR: email can't be empty");

        }
        final String PASSWORDREGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";
        final String EMAILREGEXP = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        if(Interface.validateData(email, EMAILREGEXP)){
            this.email = email;
        }else{
            throw new IllegalArgumentException("ERROR: email doesn't match the allowed expression");
        }
        if(Interface.validateData(password, PASSWORDREGEX)){
            String hashedPass = Interface.hashString(password);
            this.password = hashedPass ;
        }else{
            throw new IllegalArgumentException("ERROR: the password is not secure enough");
        }

    }
    public int getID(){
        return this.ID;
    }
    public void setPremiumMember(){
        this.premiumMember = true;
    }
    public void revokeMembership(){
        this.premiumMember = false;
    }
    public void setCreditCard(String card_number, String cvc, String exp_Date) throws  NoSuchAlgorithmException{
        if(Interface.validateData(card_number, "^\\d{16}$")){
            cardInfo[0] = Interface.hashString(card_number);
        }else{
            throw new IllegalArgumentException("ERROR: CARD NUMBER EITHER CONTAINS ILLEGAL CHARACTERS OR IS NOT EXACTLY 16 CHARACTERS LONG");
        }
        if(Interface.validateData(cvc, "^\\d{3}$")){
            this.cardInfo[1] = Interface.hashString(cvc);
        }else{
            throw new IllegalArgumentException("ERROR: cvc IS NOT EXACTLY 3 DIGITS OR CONTAINS INVALID CHARACTERS");
        }
        if(Interface.validateData(exp_Date, "^\\\\d{2}/\\\\d{2}$")){
            cardInfo[2] = Interface.hashString(exp_Date);
        }else{
            throw new IllegalArgumentException("ERROR: wrong exparation date format. Please amke sure it is dd/mm");
        }  
    }
    public void clearCardInfo(){
        for(int i = 0; i < 3; i++){
            this.cardInfo[i] = null;
        }
    }
    public void setEmail(String email){
        final String EMAIL_REGEXP = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
        if(Interface.validateData(email, EMAIL_REGEXP)){
            this.email = email;
        }else{
            throw new IllegalArgumentException("ERROR: email doesn't match the allowed expression");
        }
    }
    public String getEmail(){
        return this.email;
    }
    public void setPassword(String password) throws NoSuchAlgorithmException {
        if(Interface.validateData(password, Interface.PASSWORDREGEX)){
            this.password = Interface.hashString(password);
        }else{
            throw new IllegalArgumentException("ERROR: email doesn't match the allowed expression");
        }
    }
    public static boolean logIn(String email, String password) throws NoSuchAlgorithmException{
        String pass_hashed = Interface.hashString(password);
        Customers temp = Cinema.getCustomerByEmail(email);
        if(temp == null){
            System.out.println("user does not exist");
            return false;
        }
        if(temp.password.equals(pass_hashed)){
            return true;
        }
        return false;
    }
    public boolean getMembershipStatus(){
        return this.premiumMember;
    }
    public void addBonus(int points){
        this.points+=points;
    }
    public int get_amount_of_points(){
        return this.points;
    }
    public void displayInfo(){
        System.out.println("ID: "+this.ID+ "Name: "+this.name+" Surname: "+this.surname+" date of birth"+this.dateOfBirth+" Membership status: "+this.premiumMember+" amount of points: "+this.get_amount_of_points());
    }

    
}