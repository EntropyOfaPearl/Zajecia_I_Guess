package src.UIs;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import src.Managment;
import src.Cafe.Cafe;
import src.CinemaManagment.Cinema;
import src.People.Customers;
import src.Reservations.Program;
import src.Reservations.Reservation;

//splited into many functions to make the code more clear.

public class CustomerUI {
    public static void customerUI(Customers p) throws NoSuchAlgorithmException{
        Scanner userInput = new Scanner(System.in);
        System.out.printf("%s WELCOME, %S !!!! %s",Managment.BACKGROUND_MAGENTA,p.getName(),Managment.ANSI_RESET);
        while(true){
            try{
                System.out.printf("What would you like to do our dear? %n");
                System.out.printf("[1].Display the schedule %n");
                System.out.printf("[2].See the cafe menu %n");
                System.out.printf("[3].See your reservations %n");
                System.out.printf("[4].Account settings %n");
                System.out.printf("[0]. Log out. %n");
                int choice = userInput.nextInt();
                switch (choice) {
                    case 1:
                        ArrayList<Program> schedule = Cinema.getSchedule();
                        for(Program temp : schedule){
                            temp.displayInfo();
                            System.out.printf("%n %n");
                        }
                        break;
                    case 2:
                        Cafe.displayListStatic();
                        break;
                    case 3:
                        ArrayList<Reservation> pReservations = Cinema.getAllCustomerReservations(p);
                        System.out.printf("%s Displaying all the reservations placed: %n %s",Managment.MAGENTA,Managment.ANSI_RESET);
                        for(Reservation r : pReservations){
                            r.displayInfo();
                            System.out.printf("%n %n");
                        }
                        break;
                    case 4:
                        userSettings(p);
                        break;
                    case 0:
                        return;
                    default:
                    System.out.printf("%s Please input a proper choice :( %s",Managment.RED, Managment.ANSI_RESET);
                }
            }catch(NumberFormatException e){
                System.out.printf("%s Please input a proper value :( %s",Managment.RED, Managment.ANSI_RESET);
            }
        }

    }
    private static void userSettings(Customers p) throws NoSuchAlgorithmException{
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.printf("%s displaying the settings for the user: %n %s", Managment.BACKGROUND_MAGENTA, Managment.ANSI_RESET);
            System.out.printf("%s [0]return. %n", Managment.MAGENTA);
            System.out.printf(" [1]Change user data %n");
            System.out.printf(" [2]Purchase premium/revoke subscription %n");
            System.out.printf(" [3]Change credit card details %n");
            System.out.printf(" [4]Delete credit/debit card info %n");
            System.out.printf(" [5]Delete user %n %s", Managment.ANSI_RESET);

            try {
                int choice = userInput.nextInt();
                userInput.nextLine();

                switch (choice) {
                    case 1:
                        changeUserDataUI(p);
                        break;

                    case 2:
                        if (p.getMembershipStatus()) {
                            System.out.printf("%nAre you sure?? [y/n]: ");
                            String c = userInput.nextLine().trim();
                            if (c.equalsIgnoreCase("y")) {
                                p.revokeMembership();
                                System.out.println("We are greatly sorry to lose a valuable customer :( Please come back someday!");
                            }
                        } else {
                            System.out.println("Thank you for your purchase~! <3");
                            p.setPremiumMember();
                        }
                        break;

                    case 3:
                        try {
                            System.out.printf("%nCard number: ");
                            String cNum = userInput.nextLine().trim();
                            System.out.printf("%nCVC: ");
                            String cvc = userInput.nextLine().trim();
                            System.out.printf("%nExp date (mm/yy): ");
                            String exp = userInput.nextLine().trim();
                            p.setCreditCard(cNum, cvc, exp);
                            System.out.println("Credit card set up successfully :)");
                        } catch (IllegalArgumentException e) {
                            System.out.printf("There has been a problem setting up your credit card: %s %n", e);
                        }
                        break;

                    case 4:
                        System.out.printf("%nAre you sure?? [y/n]: ");
                        String c4 = userInput.nextLine().trim();
                        if (c4.equalsIgnoreCase("y")) {
                            p.clearCardInfo();
                            System.out.println("Info cleared successfully.");
                        }
                        break;

                    case 5:
                        System.out.printf("%nAre you sure?? [y/n]: ");
                        String ch = userInput.nextLine().trim();
                        if (ch.equalsIgnoreCase("y")) {
                            Cinema.deleteCustomer(p);
                        }
                        break;

                    case 0:
                        return;

                    default:
                        System.out.printf("%s Invalid input %s%n", Managment.RED, Managment.ANSI_RESET);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.printf("%s %s :( %s%n", Managment.RED, e.toString(), Managment.ANSI_RESET);
            }
        }
    }
    private static void changeUserDataUI(Customers p) throws NoSuchAlgorithmException{
        while(true){
            System.out.printf("%n [0]return %n");
            System.out.printf("[1]Change name %n");
            System.out.printf("[2]Change surname %n");
            System.out.printf("[3]Change email %n");
            System.out.printf("[4]Change password %n");
            int  choice;
            Scanner skan = new Scanner(System.in);
            try{
                choice = skan.nextInt();
                if(choice == 0){
                    return;
                }
                changeUserData(p, choice);
            }catch(NumberFormatException e){
                System.out.printf("%s Please provide a valid input %s", Managment.RED, Managment.ANSI_RESET);
            }

        }
    }
    public static void changeUserData(Customers p, int choice) throws NoSuchAlgorithmException{
        Scanner skan = new Scanner(System.in);
        try{
            String userData;
            switch (choice) {
                case 1:
                    System.out.printf("to what name would you like to change it to? ");
                    userData = skan.nextLine();
                    p.setName(userData);
                    break;
                case 2:
                    System.out.printf("to what surname would you like to change it to? ");
                    userData = skan.nextLine();
                    p.setSurname(userData);
                    break;
                case 3:
                    System.out.printf("to what name would you like to change it to? ");
                    userData = skan.nextLine();
                    p.setEmail(userData);
                    break;
                case 4:
                    System.out.printf("to what name would you like to change it to? ");
                    userData = skan.nextLine();
                    p.setPassword(userData);
                    break;
                default:
                    System.out.printf("$s Please provide valid input:( %s %n",Managment.RED, Managment.ANSI_RESET);
                    break;
            }
        }catch(IllegalArgumentException e){
                    System.out.printf("%s %s %s", Managment.RED, e.toString(), Managment.ANSI_RESET);
        }
    }
}
