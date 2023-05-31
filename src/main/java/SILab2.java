import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function (User user, List<User> allUsers) {
        if (user==null || user.getPassword()==null || user.getEmail()==null){
            throw new RuntimeException("Mandatory information missing!");
        }

        if (user.getUsername()==null){
            user.setUsername(user.getEmail());
        }

        int same = 1;
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) {  //proverka za validen email,mora da ima @ i tochka
            same = 0;
            for (int i=0;i<allUsers.size();i++) {
                User existingUser = allUsers.get(i);
                if (existingUser.getEmail() == user.getEmail()) { //od 49 do 52 treba , taka da razlichen email
                    same += 1;   // ako ima ist imejl same zgolemi za eden
                }
                if (existingUser.getUsername() == user.getUsername()) {  // od 52 do 54, treba da ima raclichen userjenm
                    same += 1;  // ako ima ist username zgolemi za eden
                }
            }
        }

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";
        String password = user.getPassword();
        String passwordLower = password.toLowerCase();

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) {
            return false;  // ako e prisuten usernejmot vo passwordot ili ako pasvordot e pomalce od 8 vrati false
        }
        else {  // ako e pravilen pasword
            if (!passwordLower.contains(" ")) { //ako pasvordot nema prazni mesta
                for (int i = 0; i < specialCharacters.length(); i++) {          //iterira na site specijalni karakteri
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) {      //
                        return same == 0;   // ako nema nieden ist usernejm ili pasvord togash ke vrati true , mora da ima specijalen karakter
                    }
                }
            }
        }  // 66-74
        return false;  // ovde e ako nema specijalen karakter i vrakja false
    }
}   // 66-74  znachi da ima pasvord sho ima prazno mesto
