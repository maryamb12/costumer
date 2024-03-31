package Util;

public class EmailValidate {
    public static boolean validate(String email){
        return (email==null || !email.matches("^.+@.+\\..+$"));
    }
}
