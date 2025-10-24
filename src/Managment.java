package src;
import src.CinemaManagment.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import src.People.*;
import src.UIs.*;

public class Managment{
    public static final String MAGENTA = "\u001B[31m";
    public static final String ITALIC = "\u001B[3m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String	BLUE = "\u001B[34m";
    public static final String	RED	= "\u001B[31m";
    public static final String	YELLOW = "\u001B[33m";
    public static final String	BACKGROUND_BLUE	= "\u001B[44m";
    public static final String BACKGROUND_CYAN5 = "\u001B[46m";
    public static final String BACKGROUND_MAGENTA ="\u001B[45m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) throws NoSuchAlgorithmException, InterruptedException, IOException {
        //sample data added to make the program work.
        //you can log in to those accounts or create new ones.
        Cinema podziemnyKrag = new Cinema(9999.99, 999.99);
        SampleData.createSampleCustomers();
        SampleData.createSampleStaff();
        SampleData.createSampleFood();

        Scanner userInput = new Scanner(System.in);
        int choice = 5;
        while(true){
            System.out.print(BACKGROUND_BLUE);
            System.out.println("Menu: ");
            System.out.println("[1]: Log in as an employee"); 
            System.out.println("[2]: Log in as a customer");
            System.out.println("[3]: Register as a Customer");
            System.out.println("[0] exit program"+ANSI_RESET); 
           try{
                choice  = Integer.parseInt(userInput.nextLine().toString());
            }catch(NumberFormatException e){
               System.out.println(RED+"please provide a valid argument. "+ANSI_RESET);
               continue;
            }
            switch (choice) {
                case 1:
                    System.out.printf("%s please insert your: %s %n",BACKGROUND_MAGENTA, ANSI_RESET);
                    System.out.printf("%s      PESEL:%s", MAGENTA, ANSI_RESET);
                    String peselLogIn = userInput.nextLine().toString();
                    System.out.printf("%s %n      Password:%s", MAGENTA, ANSI_RESET);
                    String passwordLogInStaff = userInput.nextLine().toString();
                    Staff p =Cinema.getStaffByPESEL(peselLogIn);
                    if(p!= null){
                        if(p.logIn(p, passwordLogInStaff)){
                            System.out.printf("%s Log in sucessfull, welcome %s. %n %s", MAGENTA,Cinema.getStaffByPESEL(peselLogIn).getName(), ANSI_RESET);
                            StaffUI.staffUI(Cinema.getStaffByPESEL(peselLogIn));
                        }else{
                            System.out.printf("%s Login unsuccessful, please try again. %n %s", RED, ANSI_RESET);
                        } 
                    }

                    break;
                case 2:
                    System.out.printf("%s please insert your: %s %n",BACKGROUND_MAGENTA, ANSI_RESET);
                    System.out.printf("%s      email:%s", MAGENTA, ANSI_RESET);
                    String emailLogIn = userInput.nextLine().toString();
                    System.out.printf("%s %n      Password:%s", MAGENTA, ANSI_RESET);
                    String passwordLogIn = userInput.nextLine().toString();
                    Customers person = Cinema.getCustomerByEmail(emailLogIn);
                    if(person == null){
                        System.out.println("user does not exist");
                    }
                    if(person.logIn(person, passwordLogIn)){
                        System.out.printf("%s Log in sucessfull, welcome %s. %n %s", MAGENTA,Cinema.getCustomerByEmail(emailLogIn).getName(), ANSI_RESET);
                        CustomerUI.customerUI(Cinema.getCustomerByEmail(emailLogIn));
                    }else{
                        System.out.printf("%s Login unsuccessful, please try again. %n %s", RED, ANSI_RESET);
                    } 

                    break;
                case 3:
                    try{
                        System.out.printf("%s please insert your: %s %n",BACKGROUND_MAGENTA, ANSI_RESET);
                        System.out.printf("%s      name: %s", MAGENTA, ANSI_RESET);
                        String name = userInput.nextLine().toString();
                        System.out.printf("%s %n      Surname: %s", MAGENTA, ANSI_RESET);
                        String Surname = userInput.nextLine().toString();
                        System.out.printf("%s %n      day of birth: %s", MAGENTA, ANSI_RESET);
                        int dayOfBirth = Integer.parseInt(userInput.nextLine().toString());                        
                        System.out.printf("(%s %n      month of birth: %s", MAGENTA, ANSI_RESET);
                        int monthOfBirth = Integer.parseInt(userInput.nextLine().toString());
                        System.out.printf("%s %n      year of birth: %s", MAGENTA, ANSI_RESET);
                        int yearOfBirth = Integer.parseInt(userInput.nextLine().toString());
                        System.out.printf("%s %n      Password: %s", MAGENTA, ANSI_RESET);
                        String password = userInput.nextLine().toString();
                        System.out.printf("%s %n      email adress: %s", MAGENTA, ANSI_RESET);
                        String email = userInput.nextLine().toString();
                        System.out.printf("%s %n      gender: %s", MAGENTA, ANSI_RESET);
                        char gender = userInput.nextLine().toString().toCharArray()[0];
                        Customers registration = new Customers(name, Surname, dayOfBirth, monthOfBirth, yearOfBirth, password, email, gender);
                        Cinema.addCustomer(registration);
                        System.out.printf("%s %s Registration successfull!! :) welcome %s ! %s",CYAN, ITALIC, name, ANSI_RESET);

                    }catch(IllegalArgumentException e){
                        System.out.printf("%s ERROR: %s . Please try again. %s %n", RED, e.toString(), ANSI_RESET);
                    }
                    break;
                case 0:
                    System.exit(0);
                break;
                default:
                    System.out.printf("%s PLEASE PROVIDE A VALID CHOICE!!! %s",RED,ANSI_RESET);
                    break;
            }
        }
    }

}
