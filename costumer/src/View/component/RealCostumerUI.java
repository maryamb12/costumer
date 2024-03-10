package View.component;

import Util.ScannerWrapper;
import model.Costumer;
import model.RealCostumer;

import java.util.function.Function;

public class RealCostumerUI extends AbstractCostumerUI {

    public RealCostumerUI() {
        super();
    }

    @Override
    public Costumer generateCostumer() {
        String name = scannerWrapper.getUserInfo("Enter Costumer name:",
                Function.identity());
        String family=scannerWrapper.getUserInfo("Enter family:",Function.identity());
        String address = scannerWrapper.
                getUserInfo("Enter Costumer address:",Function.identity());
        String postalcode=scannerWrapper.
                getUserInfo("Enter postal code:",Function.identity());
        String phoneNumber=scannerWrapper.
                getUserInfo("Enter phone number:",Function.identity());
        String nationalCode=scannerWrapper.
                getUserInfo("Enter national code:",Function.identity());
        String workingMoblieNumber=scannerWrapper.
                getUserInfo("Enter working mobile number:",Function.identity());
        String personalMoblieNumber=scannerWrapper.
                getUserInfo("Enter personal mobile number:",Function.identity());
        String workingEmail=scannerWrapper.
                getUserInfo("Enter working Email:",Function.identity());
        String personalEmail=scannerWrapper.
                getUserInfo("Enter personal Email:",Function.identity());
        RealCostumer newRealCostumer=new RealCostumer(name,address,postalcode,phoneNumber,
                family,nationalCode,workingMoblieNumber,personalMoblieNumber,
                workingEmail,personalEmail);
        return newRealCostumer;
    }

    @Override
    public void editCostumer(Costumer costumer) {
        String name=scannerWrapper.getUserInfo("Enter name:",Function.identity());
        costumer.setName(name);
        String family=scannerWrapper.getUserInfo("Enter family:",Function.identity());
        ((RealCostumer)costumer).setFamily(family);
        String address = scannerWrapper.
                getUserInfo("Enter Costumer address:",Function.identity());
        costumer.setAddress(address);
        String postalcode=scannerWrapper.
                getUserInfo("Enter postal code:",Function.identity());
        costumer.setPostalCode(postalcode);
        String phoneNumber=scannerWrapper.
                getUserInfo("Enter phone number:",Function.identity());
        costumer.setPhoneNumber(phoneNumber);
        String nationalCode=scannerWrapper.
                getUserInfo("Enter national code:",Function.identity());
        ((RealCostumer) costumer).setNationalCode(nationalCode);
        String workingMoblieNumber=scannerWrapper.
                getUserInfo("Enter working mobile number:",Function.identity());
        ((RealCostumer) costumer).setWorkingMobileNumber(workingMoblieNumber);
        String personalMoblieNumber=scannerWrapper.
                getUserInfo("Enter personal mobile number:",Function.identity());
        ((RealCostumer) costumer).setPersonalMobileNumber(personalMoblieNumber);
        String workingEmail=scannerWrapper.
                getUserInfo("Enter working Email:",Function.identity());
        ((RealCostumer) costumer).setWorkingEmail(workingEmail);
        String personalEmail=scannerWrapper.
                getUserInfo("Enter personal Email:",Function.identity());
        ((RealCostumer) costumer).setPersonalEmail(personalEmail);
    }


}
