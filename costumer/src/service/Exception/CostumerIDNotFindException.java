package service.Exception;

public class CostumerIDNotFindException extends CostumerBasicException {

    public CostumerIDNotFindException(){
        super("ERROR: Wrong ID");
    }
}
