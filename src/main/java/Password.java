import javax.swing.*;
import java.util.ArrayList;

public class Password {

    private static ArrayList<String> errors = new ArrayList<>();

    public static void main(String[] args){

        String password = JOptionPane.showInputDialog("Enter Password");

        while (!passwordIsValid(password)){

            for (String error :errors) {
                System.out.println(error);
            }
            System.out.println("-------------------");
            if(passwordIsOk()){
                System.out.println("Password OK!");
            }
            System.out.println("-------------------");
            errors.clear();

            password = JOptionPane.showInputDialog("Re-enter password.");

        }
        if(passwordIsValid(password) && passwordIsOk()){
            System.out.println("Password approved!\nPassword OK!");
        }

    }
    public static Boolean passwordIsValid(String password){

        Boolean checkLength = false;
        Boolean checkUpper = false;
        Boolean checkLower = false;
        Boolean checkDigit = false;
        Boolean checkSpecialChar = false;
        Boolean success = false;

        for(int i = 0 ; i <= 0 ; i++){

            for(int x = 0; x < password.length(); x++){

                char character = password.charAt(x);

                if(Character.isUpperCase(character)){
                    checkUpper = true;
                }
                if(Character.isLowerCase(character)){
                    checkLower = true;
                }
                if(Character.isDigit(character)){
                    checkDigit = true;
                }
                if(password.length() > 8){
                    checkLength = true;
                }
                if(password.matches("(?=.*[~!@#$%^&*()_-]).*")){
                    checkSpecialChar = true;
                }
            }

            if(!checkUpper) {
                errors.add("Password must contain at least 1 Uppercase.");
            }
            if(!checkLower) {
                errors.add("Password must contain at least 1 Lowercase.");
            }
            if(!checkDigit) {
                errors.add("Password must contain at least 1 Digit.");
            }
            if(!checkLength) {
                errors.add("Password must be longer than 8 characters.");
            }
            if(!checkSpecialChar) {
                errors.add("Password must contain at least 1 character.");
            }

            if(checkUpper && checkLower && checkDigit && checkLength && checkSpecialChar){
                success = true;
            }
        }


    return success;

    }
    public static Boolean passwordIsOk(){

        return errors.size() < 3;
    }

}
