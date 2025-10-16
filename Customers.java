import java.security.NoSuchAlgorithmException;

public class Customers extends People{
    private final int ID;
    private String email;
    private String password;
    private boolean premium_member = false;
    private String[] card_info = new String[3]; 
    private int points = 0;
    public  Customers(String name, String surname, int dayOfBirth, int monthOfBirth, int yearOfBirth,String password, String email, char gender)throws NoSuchAlgorithmException{
        int last = Cinema.getCinema_Customers().size()+1;
        this.ID = last;
        set_name(name);
        set_surname(surname);
        set_dateOfBirth(monthOfBirth,dayOfBirth,yearOfBirth);
        set_gender(gender);
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("ERROR: email can't be empty");

        }
        final String PASSWORD_REGEX = "\"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$\"";
        final String EMAIL_REGEXP = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
        if(Interface.validate_data(email, EMAIL_REGEXP)){
            this.email = email;
        }else{
            throw new IllegalArgumentException("ERROR: email doesn't match the allowed expression");
        }
        if(Interface.validate_data(password, PASSWORD_REGEX)){
            String hashed_pass = Interface.hash_String(password);
            this.password = hashed_pass ;
        }

    }
    public int getID(){
        return this.ID;
    }
    public void setPremium_member(){
        this.premium_member = true;
    }
    public void revoke_membership(){
        this.premium_member = false;
    }
    void set_credit_card(String card_number, String cvc, String exp_Date) throws  NoSuchAlgorithmException{
        boolean isValid_card_num = card_number.matches("^\\d{16}$");
        if(isValid_card_num){
            card_info[0] = Interface.hash_String(card_number);
        }else{
            throw new IllegalArgumentException("ERROR: CARD NUMBER EITHER CONTAINS ILLEGAL CHARACTERS OR IS NOT EXACTLY 16 CHARACTERS LONG");
        }
        boolean isValid_cvc = cvc.matches("^\\d{3}$");
        if(isValid_cvc){
            this.card_info[1] = Interface.hash_String(cvc);
        }else{
            throw new IllegalArgumentException("ERROR: cvc IS NOT EXACTLY 3 DIGITS OR CONTAINS INVALID CHARACTERS");
        }
        boolean isValid_exp_date = exp_Date.matches("^\\\\d{2}/\\\\d{2}$");
        if(isValid_exp_date){
            card_info[2] = Interface.hash_String(exp_Date);
        }else{
            throw new IllegalArgumentException("ERROR: wrong exparation date format. Please amke sure it is dd/mm");
        }  
    }
    void clear_Card_info(){
        for(int i = 0; i < 3; i++){
            this.card_info[i] = null;
        }
    }
    void set_email(String email){
        final String EMAIL_REGEXP = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
        if(Interface.validate_data(email, EMAIL_REGEXP)){
            this.email = email;
        }else{
            throw new IllegalArgumentException("ERROR: email doesn't match the allowed expression");
        }
    }
    String get_email(){
        return this.email;
    }
    void set_password(String password) throws NoSuchAlgorithmException {
        if(Interface.validate_data(password, Interface.PASSWORD_REGEX)){
            this.password = Interface.hash_String(password);
        }else{
            throw new IllegalArgumentException("ERROR: email doesn't match the allowed expression");
        }
    }
    boolean log_in(int ID, String password) throws NoSuchAlgorithmException, InterruptedException{
        String pass_hashed = Interface.hash_String(password);
        Customers temp = Cinema.get_Customer_by_ID(ID); 
        if(temp.password == pass_hashed){
            System.out.println("Log in sucessfull");
            Thread.sleep(5000);
            return true;
        }
        return false;
    }
    boolean get_membership_status(){
        return this.premium_member;
    }
    public void add_bonus(int points){
        this.points+=points;
    }
    public int get_amount_of_points(){
        return this.points;
    }
    void display_info(){
        System.out.println("ID: "+this.ID+ "Name: "+this.name+" Surname: "+this.surname+" date of birth"+this.dateOfBirth+" Membership status: "+this.premium_member+" amount of points: "+this.get_amount_of_points());
    }

    
}