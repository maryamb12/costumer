package View.component;

import Util.ScannerWrapper;
import model.Costumer;
import model.LegalCostumer;

import java.util.function.Function;


public class LegalCostumerUI extends AbstractCostumerUI {


    public LegalCostumerUI() {
        super();
    }


    @Override
    public Costumer generateCostumer() {
        String name = scannerWrapper.
                getUserInfo("Enter Costumer name:", Function.identity());
        String address = scannerWrapper.
                getUserInfo("Enter Costumer address:",Function.identity());
        String postalcode=scannerWrapper.
                getUserInfo("Enter postal code:",Function.identity());
        String phoneNumber=scannerWrapper.
                getUserInfo("Enter phone number:",Function.identity());
        String faxNumber=scannerWrapper.
                getUserInfo("Enter fax number: ",Function.identity());
        String businessNumber=scannerWrapper.
                getUserInfo("Enter your business code: ",Function.identity());
        String mangerNumber=scannerWrapper.
                getUserInfo("Enter manager phone number:",Function.identity());
        String webSiteAddress= scannerWrapper.
                getUserInfo("Enter websibe address:",Function.identity());
        LegalCostumer newLegalNumber = new LegalCostumer(name,address,postalcode,
                phoneNumber,faxNumber,businessNumber,mangerNumber,webSiteAddress);
        return newLegalNumber;
    }

    @Override
    public void editCostumer(Costumer costumer) {
        String name=scannerWrapper.getUserInfo("Enter name:",Function.identity());
        costumer.setName(name);
        String address = scannerWrapper.
                getUserInfo("Enter Costumer address:",Function.identity());
        costumer.setAddress(address);
        String postalcode=scannerWrapper.
                getUserInfo("Enter postal code:",Function.identity());
        costumer.setPostalCode(postalcode);
        String phoneNumber=scannerWrapper.
                getUserInfo("Enter phone number:",Function.identity());
        costumer.setPhoneNumber(phoneNumber);
        String faxNumber=scannerWrapper.
                getUserInfo("Enter fax number: ",Function.identity());
        ((LegalCostumer)costumer).setFaxNumber(faxNumber);
        String businessNumber=scannerWrapper.
                getUserInfo("Enter your business code: ",Function.identity());
        ((LegalCostumer) costumer).setBusinessCode(businessNumber);
        String mangerNumber=scannerWrapper.
                getUserInfo("Enter manager phone number:",Function.identity());
        ((LegalCostumer) costumer).setManagerMobileNumber(mangerNumber);
        String webSiteAddress= scannerWrapper.
                getUserInfo("Enter website address:",Function.identity());
        ((LegalCostumer) costumer).setWebSiteAddress(webSiteAddress);
    }

}
