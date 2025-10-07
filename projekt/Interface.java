import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public interface Interface {
    final String PASSWORD_REGEX = "\"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$\"";
    public void add_bonus();
    public void change_value_by_precent(float precent);
    public void display_info();
    public void set_Schedule();
    public void display_list();
    public boolean log_in();
    public static String hash_String(String text) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashbytes = digest.digest(text.getBytes(StandardCharsets.UTF_8));
        String hex = HexFormat.of().formatHex(hashbytes);
        return hex;
    }
   public static boolean validate_data(String data, String reg_Exp){
        boolean valid = true;
        Pattern pattern = Pattern.compile(reg_Exp);
        if (data == null) {
            valid = false;
        }
        Matcher matcher = pattern.matcher(data);
        if(!matcher.matches()){
            valid = false;
        }
        return valid;

    }
    public static String getNameDay(int day_number){
        switch(day_number){
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wensday";
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
}