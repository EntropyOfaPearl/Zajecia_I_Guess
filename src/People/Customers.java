package src.People;
import src.CinemaManagment.*;
import java.security.NoSuchAlgorithmException;

public class Customers extends People implements InterfacePeople{
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
        if(Cinema.validateData(email, EMAILREGEXP)){
            this.email = email;
        }else{
            throw new IllegalArgumentException("ERROR: email doesn't match the allowed expression");
        }
        if(Cinema.validateData(password, PASSWORDREGEX)){
            String hashedPass = Cinema.hashString(password);
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
        if(Cinema.validateData(card_number, "^\\d{16}$")){
            cardInfo[0] = Cinema.hashString(card_number);
        }else{
            throw new IllegalArgumentException("ERROR: CARD NUMBER EITHER CONTAINS ILLEGAL CHARACTERS OR IS NOT EXACTLY 16 CHARACTERS LONG");
        }
        if(Cinema.validateData(cvc, "^\\d{3}$")){
            this.cardInfo[1] = Cinema.hashString(cvc);
        }else{
            throw new IllegalArgumentException("ERROR: cvc IS NOT EXACTLY 3 DIGITS OR CONTAINS INVALID CHARACTERS");
        }
        if(Cinema.validateData(exp_Date, "^\\\\d{2}/\\\\d{2}$")){
            cardInfo[2] = Cinema.hashString(exp_Date);
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
        if(Cinema.validateData(email, EMAIL_REGEXP)){
            this.email = email;
        }else{
            throw new IllegalArgumentException("ERROR: email doesn't match the allowed expression");
        }
    }
    public String getEmail(){
        return this.email;
    }
    public void setPassword(String password) throws NoSuchAlgorithmException {
        if(Cinema.validateData(password, Cinema.PASSWORDREGEX)){
            this.password = Cinema.hashString(password);
        }else{
            throw new IllegalArgumentException("ERROR: email doesn't match the allowed expression");
        }
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

    @Override
    public void displayInfo(){
        System.out.println("ID: "+this.ID+ "Name: "+this.name+" Surname: "+this.surname+" date of birth"+this.dateOfBirth+" Membership status: "+this.premiumMember+" amount of points: "+this.get_amount_of_points());
    }
    @Override
    public boolean logIn(Object person, String password) {
        String pass_hashed;
        Customers p = (Customers)person;
        try {
            pass_hashed = Cinema.hashString(password);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
            return false;
        }
        if(p.password.equals(pass_hashed)){
            return true;
        }
        return false;
    }


}