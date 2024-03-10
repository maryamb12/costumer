package model;

import Util.Exception.CostumerTypeException;

public enum CostumerType {
    REALCOSTUMER(1),
    LEGALCOSTUMER(2);

    public final int value;

    CostumerType(int value) {
        this.value=value;
    }

    public static CostumerType fromValue(int value) throws CostumerTypeException {
        for(CostumerType type:values()) {
            if (type.value == value)
                return type;
        }
        throw new CostumerTypeException();
    }

}
