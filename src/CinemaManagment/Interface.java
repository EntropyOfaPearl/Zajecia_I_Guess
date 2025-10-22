package src.CinemaManagment;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public interface Interface {
    final String PASSWORDREGEX = "\"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$\"";
    public void addBonus();
    public void changeValueByPrecent(float precent);
    public void displayInfo();
    public void setSchedule();
    public void displayList();
    public boolean logIn();
    public static String hashString(String text) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashbytes = digest.digest(text.getBytes(StandardCharsets.UTF_8));
        String hex = HexFormat.of().formatHex(hashbytes);
        return hex;
    }
   public static boolean validateData(String data, String reg_Exp){
        Pattern patternCheck = Pattern.compile(reg_Exp);
        Matcher matcher = patternCheck.matcher(data);
        if(matcher.matches()){
            return true;
        }
        return true;
    }
    public static String getNameDay(int day_number){
        switch(day_number){
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday??";
            case 7:
                return "Sunday (i think??)";
            default:
                throw new IllegalArgumentException("ERROR: not a valid day.");
        }
    }
    public void sell();
}