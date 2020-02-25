import javax.swing.*;

public class Password {

    public static void main(String[] args){

        Validation validation = new Validation();

        String password = JOptionPane.showInputDialog("Enter Password");

        while (!validation.passwordIsValid(password)){

            for (String error :validation.getErrors()) {
                System.out.println(error);
            }
            System.out.println("-------------------");
            if(validation.bonus()){
                System.out.println("The password is never OK if it is empty and 8 or more characters are not met.");
            }
            else if(validation.passwordIsOk()){
                System.out.println("Password OK!");
            }
            System.out.println("-------------------");
            validation.getErrors().clear();
            validation.getBonus().clear();


            password = JOptionPane.showInputDialog("Re-enter password.");

        }
        if(validation.passwordIsValid(password) && validation.passwordIsOk()){
            System.out.println("Password approved!\nPassword OK!");
        }

    }
}
