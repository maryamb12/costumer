package Util.Exception;

public class NoActiveCostumerException extends CostumerBasicException {

    public NoActiveCostumerException(){
        super("ERROR: there is no active costumer!");
    }
}
