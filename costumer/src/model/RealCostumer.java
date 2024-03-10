package model;

public class RealCostumer extends Costumer {
    private String family;
    private String nationalCode;
    private String workingMobileNumber;
    private String personalMobileNumber;
    private String workingEmail;
    private String personalEmail;

    public RealCostumer(String name, String address,String postalCode, String phoneNumber,
                        String family,String nationalCode,
                        String workingMobileNumber, String personalMobileNumber,
                        String workingEmail, String personalEmail ){
        super(name,address,postalCode, phoneNumber, CostumerType.REALCOSTUMER);
        this.family=family;
        this.nationalCode=nationalCode;
        this.workingMobileNumber=workingMobileNumber;
        this.personalMobileNumber = personalMobileNumber;
        this.workingEmail=workingEmail;
        this.personalEmail=personalEmail;
    }

    public String toString(){
        return super.toString()+"\tfamily:"+ this.family +"\tnational code:"+this.nationalCode
                +"\nWorking mobile number:"+this.workingMobileNumber+"\tPersonal mobile number:"+
                this.personalMobileNumber +"\tWorking Email:"+ this.workingEmail
                +"Personal email:"+this.personalEmail+"\n\n";
    }
@Override
    public boolean equals(Object object){
        return (object instanceof RealCostumer &&
                ((RealCostumer) object).getName().equals(getName())
        && ((RealCostumer) object).getFamily().equals(this.family));
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getWorkingMobileNumber() {
        return workingMobileNumber;
    }

    public void setWorkingMobileNumber(String workingMobileNumber) {
        this.workingMobileNumber = workingMobileNumber;
    }

    public String getPersonalMobileNumber() {
        return personalMobileNumber;
    }

    public void setPersonalMobileNumber(String personalMobileNumber) {
        this.personalMobileNumber = personalMobileNumber;
    }

    public String getWorkingEmail() {
        return workingEmail;
    }

    public void setWorkingEmail(String workingEmail) {
        this.workingEmail = workingEmail;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }
}
