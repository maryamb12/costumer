package Util;

import service.Exception.ValidationException;

public class NumberValidate {

    public static Boolean validate(String number) {
        return (number==null ||
                !number.matches("^0\\d{10}$| ^00\\d{12}$ ^+\\d{12}$"));
    }
}
