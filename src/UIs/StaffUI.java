package src.UIs;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import src.Managment;
import src.CinemaManagment.Cinema;
import src.CinemaManagment.DataAnalysis;
import src.People.*;

public class StaffUI {
    public static void staffUI(Staff p) throws NoSuchAlgorithmException, IOException{
        Scanner skan = new Scanner(System.in);
        switch (p.getPosition()) {
            case "clerk":
            case "cleaner":
                scheduleDisplay(p);
                break;
            case "barista":
                
                break;
            case "HR":
                humanResources();
            case "CEO":
                CEO();
                break;
            case "manager":
                manager();
                break;
            default:
                System.out.printf("%s please provide valid input %s", Managment.RED, Managment.ANSI_RESET);
                break;
        }
    }
    private static boolean logout(){
        Scanner skan = new Scanner(System.in);
        System.out.printf("Log out [y/n]");
        String choice = skan.nextLine();
        if(choice.toLowerCase().equals("y")){
            return true;
        }
        return false;
    }
    //These functions will only be used here therefore they have private access :)
    private static void scheduleDisplay(Staff p){
        Scanner skan = new Scanner(System.in);
        System.out.printf(" %s Displaying your schedule for the following month ;) %s %n",Managment.MAGENTA,Managment.ANSI_RESET);
        if(!p.getSchedule().isEmpty()){
            p.displayList();
        }else{
            System.out.printf("%s Sorry there is no schedule yet:(( Please contact your manager and HR %s %n", Managment.RED, Managment.ANSI_RESET);
        }
    }
    private static void humanResources() throws NoSuchAlgorithmException{ 
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.printf("[0] log out %n");
            System.out.printf("[1] Hire Staff %n");
            System.out.printf("[2] Fire staff %n");
            System.out.printf("[3] add comment to a staff member %n");
            System.out.printf("[4] promote %n");
            System.out.printf("[5] change staff position %n");
            int c = scan.nextInt();
            switch (c) {
                case 0:
                    return;
                case 1:
                    hireStaff();
                    break;
                case 2:
                    fireStaff();
                    break;
                case 3:
                    addCommentToAStaffMember();
                    break;
                case 4:
                    promote();
                    break;
                case 5:
                    addCommentToAStaffMember();
                    break;
                default:
                    System.out.printf("%s please provide a valid input %s", Managment.RED, Managment.ANSI_RESET);
                    break;
            }
        }
    }

    private static void hireStaff() throws NoSuchAlgorithmException{
        Scanner scan = new Scanner(System.in);
        System.out.printf("%s Please provide data for the new employee. %n %s", Managment.BACKGROUND_BLUE, Managment.ANSI_RESET);
        System.out.printf("Name: %n");
        String name = scan.nextLine();
        System.out.printf("Surame: %n");
        String surname = scan.nextLine();
        System.out.printf("Pesel: %n");
        String pesel = scan.nextLine();
        System.out.printf("day of birth: %n");
        int dob = scan.nextInt();
        System.out.printf("month of birth: %n");
        int mob = scan.nextInt();
        System.out.printf("year of birth: %n");
        int yob = scan.nextInt();
        System.out.printf("gender [m/f]: %n");
        char gender = scan.nextLine().toCharArray()[0];
        System.out.printf("Position: %n"); 
        String position = scan.nextLine();
        System.out.printf("temporary password: %n"); 
        String pass = scan.nextLine();       
        Staff newStaff = new Staff(name, surname, pesel, dob, mob, yob, gender, position, pass);
        Cinema.addStaff(newStaff);
    }

    private static void fireStaff(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Please provide PESEL of the staff you're willing to fire %n");
        String pesel = scan.nextLine();
        Staff person = Cinema.getStaffByPESEL(pesel);
        if(person!=null){
            Cinema.fireStaff(person);
        }else{
            System.out.printf("%s sorry there is no employee with this pesel %s %n", Managment.RED, Managment.ANSI_RESET);
        }
    }
    
    private static void addCommentToAStaffMember(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Please provide PESEL of the staff you're willing to comment on %n");
        String pesel = scan.nextLine();
        Staff person = Cinema.getStaffByPESEL(pesel);
        if(person!=null){
            System.out.printf("Please insert your comment below: %n");
            String comment = scan.nextLine();
            person.addComment(comment);
        }else{
            System.out.printf("%s sorry there is no employee with this pesel %s %n", Managment.RED, Managment.ANSI_RESET);
        }
    }
    private static void promote(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Please provide PESEL of the lucky employee %n");
        String pesel = scan.nextLine();
        Staff person = Cinema.getStaffByPESEL(pesel);
        if(person!=null){
            System.out.printf("Would you like to %s %n [1] add a value to the salary %n [2] increase by a precent (please format as 0.00) %s %n",Managment.ITALIC, Managment.ANSI_RESET);
            int choice = scan.nextInt();
            switch(choice){
                case 1:
                    try{
                        System.out.printf("how much of a raise do they have? %n");
                        float raise = scan.nextFloat();
                        person.addBonus(raise);
                    }catch(NumberFormatException e){
                        System.out.printf(" %s Error: not a valid input %s %n", Managment.RED, Managment.ANSI_RESET);
                    }
                    break;
                case 2:
                    try{
                        System.out.printf("how much of a raise do they have? (in 0.xx) %n");
                        float raise = scan.nextFloat();
                        person.changeValueByPrecent(raise);
                    }catch(NumberFormatException e){
                        System.out.printf(" %s Error: not a valid input %s %n", Managment.RED, Managment.ANSI_RESET);
                    }
                    break;
            }
        }else{
            System.out.printf("%s sorry there is no employee with this pesel %s %n", Managment.RED, Managment.ANSI_RESET);
        }
    }
    
    private static void CEO() throws IOException{
        System.out.printf("%s  %s LONG LIVE AKITA NERU! %s", Managment.YELLOW, Managment.ITALIC, Managment.ANSI_RESET );
        while (true) {
            Scanner skan = new Scanner(System.in);
            System.out.printf("%s here are the actions you can perform: %n", Managment.MAGENTA);
            System.out.printf("[0] log out %n");
            System.out.printf("[1] get customer habits %n");
            System.out.printf("[2] get best seller foods %n");
            try{
                int choice;
                choice = skan.nextInt();
                switch(choice){
                    case 0:
                        return;
                    case 1:
                        System.out.printf("%s Best seller drink:  %s %s %s %n",Managment.BACKGROUND_MAGENTA, Managment.ANSI_RESET, Managment.MAGENTA, DataAnalysis.getBestSellerDrinkName());
                        System.out.printf("%s Best seller snack:  %s %s %s %n",Managment.BACKGROUND_MAGENTA, Managment.ANSI_RESET, Managment.MAGENTA, DataAnalysis.getBestSellerSnackName());
                        System.out.printf("%s Best seller drink:  %s %s %s %n %s",Managment.BACKGROUND_MAGENTA, Managment.ANSI_RESET, Managment.MAGENTA, DataAnalysis.getBestSellerSetName(), Managment.ANSI_RESET);
                        break;
                    case 2:
                        try{
                            getCustomerData();
                        }catch(IllegalArgumentException e){
                            System.out.printf("%s something went wrong:( %s %n", Managment.RED, Managment.ANSI_RESET);
                        }
                        System.out.printf("Remember, as a part of our partnership with tencent you're required to send diagnostic data to improve general user experience. Happily we optimazied this process for you :) <3 %n");
                        DataAnalysis.sell("userdata.txt");//this actually doesn't do anything, it's just a joke i threw in 
                        break;
                }
            }catch(NumberFormatException e){
                System.out.printf("%s  please give a valid input! %s %n", Managment.RED, Managment.ANSI_RESET);
            }

        }
    }
    private static void getCustomerData() throws IOException{
        Scanner skan = new Scanner(System.in);
        System.out.printf("%s which data would you like? %s [1]all [2]of an age group [3]of a specific gender [4]both.");
        int choice = skan.nextInt();
        switch(choice){
            case 1:
                System.out.printf("Dumping customer data, please wait :)");
                DataAnalysis.dumpCustomerData("all_data", Cinema.getCinemaCustomers());
                break;
            case 2:
                System.out.printf("What's the start of the age range? ");
                int start = skan.nextInt();
                System.out.printf("and what's the end?? ");
                int end = skan.nextInt();
                DataAnalysis.dumpCustomerData("age_group_data", DataAnalysis.getCustomersByAgeRange(start, end));
                break;
            case 3:
                System.out.printf("What's the start of the age range? ");
                char gender = skan.nextLine().toCharArray()[0];
                DataAnalysis.dumpCustomerData("gender_data", DataAnalysis.getCustomersByGender(gender));
                break;
            case 4:
                 System.out.printf("What's the start of the age range? ");
                int startRange = skan.nextInt();
                System.out.printf("and what's the end?? ");
                int endRange = skan.nextInt();
                DataAnalysis.dumpCustomerData("age_group_data", DataAnalysis.getCustomersByAgeRange(startRange, endRange));
                System.out.printf("What's the start of the age range? ");
                char genderRange = skan.nextLine().toCharArray()[0];
                DataAnalysis.dumpCustomerData("gender_data", DataAnalysis.getCustomersByGender(genderRange));
                break;
            default:
                System.out.printf("%s please provide valid input %s", Managment.RED, Managment.ANSI_RESET);
        }
    }
    public static void manager(){
        Scanner skan = new Scanner(System.in);
        System.out.printf("%n provide the PESEL of the employee you want to fill the schedule in for: ");
        String pesel = skan.nextLine();
        Staff p = Cinema.getStaffByPESEL(pesel);
        if(p!= null){
            p.setSchedule();
        }else{
            System.out.printf("%n no staff found.");
        }
    }

}  
