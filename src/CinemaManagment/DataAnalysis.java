package src.CinemaManagment;
import src.*;
import src.Cafe.*;
import src.People.*;
import src.Reservations.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class DataAnalysis{
    public static String getBestSellerDrinkName(){
        ArrayList<Drinks> drinks = Cafe.getDrinkMenu();
        SortedMap<Integer, String> nameAndAmountSold = new TreeMap<>();
        if(!drinks.isEmpty()){
            for(Drinks d:drinks){
                nameAndAmountSold.put(d.getAmountSold(), d.getName());
            }
            return nameAndAmountSold.values().toArray()[nameAndAmountSold.size()-1].toString(); 
        }else{ 
            System.out.printf("%s Sorry! there is no data included for this category yet :(( %s %n",Managment.RED, Managment.ANSI_RESET);
            return null;
        }
    } 
    public static String getBestSellerSnackName(){
        ArrayList<Snacks> snacks = Cafe.getSnackMenu();
        SortedMap<Integer, String> nameAndAmountSold = new TreeMap<>();
        if(!snacks.isEmpty()){
            for(Snacks s :snacks){
                nameAndAmountSold.put(s.getAmountSold(), s.getName());
            }
            return nameAndAmountSold.values().toArray()[nameAndAmountSold.size()-1].toString();
        }else{ 
            System.out.printf("%s Sorry! there is no data included for this category yet :(( %s %n",Managment.RED, Managment.ANSI_RESET);
            return null;
        }
    } 
    public static String getBestSellerSetName(){
        ArrayList<Sets> sets = Cafe.getSetMenu();
        SortedMap<Integer, String> nameAndAmountSold = new TreeMap<>();
        if(!sets.isEmpty()){
            for(Sets s:sets){
                nameAndAmountSold.put(s.getAmountSold(), s.getName());
            }
            return nameAndAmountSold.values().toArray()[nameAndAmountSold.size()-1].toString(); 
        }else{ 
            System.out.printf("%s Sorry! there is no data included for this category yet :(( %s %n",Managment.RED, Managment.ANSI_RESET);
            return null;
        }
    } 
    //function only accpets 'f' for female and 'm' for male. IT DOES NOT ACCEPT UPPERCASE LETTERS!!!!!
    public static ArrayList<Customers> getCustomersByGender(char gender){
        if(!(gender == 'f' || gender == 'm')){
            throw new IllegalArgumentException("Error: invalid gender provided or the gender is in uppercase :((");
        }
        ArrayList<Customers> sortedCustomers = new ArrayList<Customers>();
        if(!(Cinema.getCinemaCustomers().isEmpty())){
            for(Customers c: Cinema.getCinemaCustomers()){
                if(c.getGender() == gender){
                    sortedCustomers.add(c);
                }
            }
        }
        return sortedCustomers;
    }

    public static ArrayList<Customers> getCustomersByAgeRange(int start, int end){
        ArrayList<Customers> sortedCustomers = new ArrayList<Customers>();
        if(!(Cinema.getCinemaCustomers().isEmpty())){
            for(Customers c: Cinema.getCinemaCustomers()){
                int y= Integer.parseInt(String.valueOf(Year.from(c.getDateOfBirth())));
                int age = Integer.parseInt(String.valueOf(Year.now().minusYears(y)));
                if(age >= start && age <= end){
                    sortedCustomers.add(c);
                }
            }
        }else{
            System.out.println("ERROR: There are no customers to sort through currently.");
        }
        return sortedCustomers;


    }
    //the function dumps the customer info and all the reservations they made into a txt file.
    //file name shouldn't have any format. just plain name (ex."Kittens" is acceptable, but  "kittens.txt" is not). The function adds the extensions by itself.
    public static void dumpCustomerData(String filename, ArrayList<Customers>customerList)throws IOException{
        final String FILE_TYPE_REGEXP = "^[^\\s]+\\.[^\\s.]{1,10}$";
        if(!Cinema.validateData(filename, FILE_TYPE_REGEXP)){
            filename += ".txt";
            File dataDump = new File(filename);
            if (dataDump.createNewFile()) {
                System.out.println("File created: " + dataDump.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter dataWrite = new FileWriter(filename);
            dataWrite.write("Dumping the data of "+customerList.size()+" customers.");
            ArrayList<Reservation> reservationsData;
            int iterator;
            if(!customerList.isEmpty()){
                for(Customers c : customerList){
                    reservationsData = Cinema.getAllCustomerReservations(c);
                    dataWrite.write("Customer ["+c.getID()+"]: \n");
                    dataWrite.write(c.getName() + " " + c.getSurame()+"gender: "+c.getGender()+" date of birth: "+c.getDateOfBirth()+"\n");
                    dataWrite.write("Contact info: \n email: "+c.getEmail()+"\n");
                    dataWrite.write("Displaying the list of all reservations: \n");
                    if(!reservationsData.isEmpty()){
                        iterator = 0;
                        for(Reservation r: reservationsData){
                            dataWrite.write("["+iterator+"]: movie:"+r.getScreening().getFilm()+" date: "+r.getScreening().getDate()+" \n");
                        }
                    }else{
                        dataWrite.write("this customers hasn't placed any reservations yet. /n");
                    }
                }
            }else{
                dataWrite.write("There is no avalible data for this customer list.");
            }
            dataWrite.close();
        }else{
            throw new IllegalArgumentException("Error: the filename provided already has an extension.=");
        }

    }
    public static void sell(Object p){
        System.out.printf("%s Tencent Holdings Limited greatly appreciates your efforts to enchance both of our companies best interests.  %n %s",Managment.RED, Managment.ANSI_RESET);
        System.out.printf("%s data sucessfully sold to the People's Republic of China . Thank you for your service citizen %n %s",Managment.YELLOW, Managment.ANSI_RESET);
        System.out.print(Managment.BLUE);
        System.out.printf("     #++++++++++++++                                                                                \r\n" + //
                        "    ++++++++++++++++                                                                                \r\n" + //
                        "          +++#                                                                          +++         \r\n" + //
                        "          +++      +#+++++    ++   ++++++       ++#+++++    +#++#++     +   ++++++  +#+++++++       \r\n" + //
                        "         ++++    +++    ++++  +++++   ++++   ++###    ++  ++++   ++++  ++++++  ++++    ++++         \r\n" + //
                        "         ++++   +++      +++  +++      +++  +++#         +++      #++  +++#     +++    +++          \r\n" + //
                        "         +++   #++++++++++++ #+++     #+++ ++++         +++++++++++++  +++      +++   ++++          \r\n" + //
                        "        ++++   ++++          ++++     ++++  ++++        ++++          ++++     ++++   ++++          \r\n" + //
                        "        ++++    +++++++++++  +++      +++    ++++++#++   ++++++##+++  ++++     +++    +++           \r\n" + //
                        "                    ##+                         +#+          +++                                    \r\n" + //
                        "                                                                                                    ");
                System.out.print(Managment.ANSI_RESET);
                Cinema.addIncome(1770.13d);
            
    }


}
