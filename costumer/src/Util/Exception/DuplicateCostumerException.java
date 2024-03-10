package Util.Exception;

public class DuplicateCostumerException extends CostumerBasicException {

    public DuplicateCostumerException(){
        super("ERROR: Same costumer name and family is impossible");
    }
}
