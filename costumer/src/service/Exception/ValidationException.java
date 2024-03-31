package service.Exception;

import java.lang.reflect.Executable;

public class ValidationException extends Exception {
    public ValidationException (String massage){
        super(massage);
    }
}
