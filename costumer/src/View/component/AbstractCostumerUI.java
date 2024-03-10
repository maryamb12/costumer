package View.component;

import Util.ScannerWrapper;
import model.Costumer;
import model.CostumerType;



public abstract class AbstractCostumerUI {

    protected ScannerWrapper scannerWrapper;

    public AbstractCostumerUI() {
        this.scannerWrapper = ScannerWrapper.getInstance();
    }


    public static AbstractCostumerUI fromCostumerType(CostumerType type){
        switch (type){
            case REALCOSTUMER: return new RealCostumerUI();
            case LEGALCOSTUMER: return new LegalCostumerUI();
        }
        return null;
    }

    public abstract Costumer generateCostumer();

    public abstract void editCostumer(Costumer costumer);
}
