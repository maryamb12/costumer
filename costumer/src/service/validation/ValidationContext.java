package service.validation;


import service.Exception.ValidationException;
import java.util.ArrayList;
import java.util.List;

public class ValidationContext<T> {

    public List<Validation<T>> validations;

    public ValidationContext(){
        this.validations= new ArrayList();
    }

    public void addValidation(Validation<T> validation){
        validations.add(validation);
    }

    public void validate(T obj) throws ValidationException {
        for (Validation<T> validation : validations) {
            validation.validate(obj);
        }
    }
}
