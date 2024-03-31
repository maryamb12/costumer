package service.validation;

import Util.EmailValidate;
import Util.NumberValidate;
import model.Costumer;
import model.LegalCostumer;
import model.RealCostumer;
import service.Exception.ValidationException;

public class CostumerValidationContext extends ValidationContext<Costumer> {

    public CostumerValidationContext(){
        //Name validation
        addValidation(costumer -> {
            String name = costumer.getName();
            if (name == null || name.trim().isEmpty()) {
                throw new ValidationException("Name can not be null or empty.");
            }
        });

        //Family validation
        addValidation(costumer ->  {
            if(costumer instanceof RealCostumer){
                String family=((RealCostumer) costumer).getFamily();
                if(family==null || family.trim().isEmpty()){
                    throw new  ValidationException("Family can not be null or empty.");
                }
            }
        });


        //Phone number validation
        addValidation(costumer ->  {
            String number=costumer.getPhoneNumber();
            if(NumberValidate.validate(number)){
                throw new ValidationException("Phone number wrong format.");
            }
        });

        //Fax validation
        addValidation(costumer -> {
                    if (costumer instanceof LegalCostumer) {
                        String fax = ((LegalCostumer) costumer).getFaxNumber();
                        if (fax == null || !fax.matches("^0\\d{10}$|^00\\d{12}$|^\\+\\d{12}$")) {
                            throw new ValidationException("Fax format is incorrect!");
                        }
                    }
                });

        //Manager mobile validation
        addValidation(costumer -> {
            if (costumer instanceof LegalCostumer) {
                String mangerNumber = ((LegalCostumer) costumer).getManagerMobileNumber();
                if (mangerNumber == null ||
                        !mangerNumber.matches("^0\\d{10}$|^00\\d{12}$|^\\+\\d{12}$")) {
                    throw new ValidationException("Manager phone number format is incorrect!");
                }
            }
        });


            //Working mobile validation
            addValidation(costumer -> {
                if (costumer instanceof RealCostumer) {
                    String workingNumber = ((RealCostumer) costumer).getWorkingMobileNumber();
                    if (NumberValidate.validate(workingNumber)) {
                        throw new ValidationException("Working mobile Number format is incorrect!");
                    }
                }
            });


            //Personal mobile validation
            addValidation(costumer -> {
                if (costumer instanceof RealCostumer) {
                    String personalNumber = ((RealCostumer) costumer).getPersonalMobileNumber();
                    if (NumberValidate.validate(personalNumber)) {
                        throw new ValidationException("Personal phone number format is incorrect!");
                    }
                }
            });


            //Working email validation
            addValidation(costumer -> {
                if (costumer instanceof RealCostumer) {
                    String email = ((RealCostumer) costumer).getWorkingEmail();
                    if (EmailValidate.validate(email)) {
                        throw new ValidationException("Working Email format is incorrect!");
                    }
                }
            });


            //Personal email validation
            addValidation(costumer -> {
                if (costumer instanceof RealCostumer) {
                    String personalEmail = ((RealCostumer) costumer).getPersonalEmail();
                    if (EmailValidate.validate(personalEmail)) {
                        throw new ValidationException("Personal email format is incorrect!");
                    }
                }
            });


            //Web validation
            addValidation(costumer -> {
                if (costumer instanceof LegalCostumer) {
                    String web = ((LegalCostumer) costumer).getWebSiteAddress();
                    if (web == null || !web.matches("^www\\..+\\..+$")) {
                        throw new ValidationException("Web format is incorrect!");
                    }
                }
            });
        }
}
