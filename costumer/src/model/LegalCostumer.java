package model;

public class LegalCostumer extends Costumer{
    private String faxNumber;
    private String businessCode;
    private String managerMobileNumber;
    private String webSiteAddress;

    public LegalCostumer(String name, String address,String postalCode, String phoneNumber,
                         String faxNumber, String businessCode,
                         String managerMobileNumber, String webSiteAddress){
        super(name,address,postalCode,phoneNumber,CostumerType.LEGALCOSTUMER);
        this.faxNumber=faxNumber;
        this.businessCode = businessCode;
        this.managerMobileNumber=managerMobileNumber;
        this.webSiteAddress=webSiteAddress;

    }
    @Override
    public String toString(){
        return super.toString() +"\tfax number: "+this.faxNumber +"\tbusiness code:"
                + this.businessCode + "\twebsite:" + this.webSiteAddress+"\n\n";
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getManagerMobileNumber() {
        return managerMobileNumber;
    }

    public void setManagerMobileNumber(String managerMobileNumber) {
        this.managerMobileNumber = managerMobileNumber;
    }

    public String getWebSiteAddress() {
        return webSiteAddress;
    }

    public void setWebSiteAddress(String webSiteAddress) {
        this.webSiteAddress = webSiteAddress;
    }
}
