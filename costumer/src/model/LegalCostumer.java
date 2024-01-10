package model;

public class LegalCostumer extends Costumer{
    private String faxNumber;
    private String businessNumber;
    private String managerMobileNumber;
    private String webSiteAddress;

    public LegalCostumer(String name, String address,String postalCode, String phoneNumber,
                         String faxNumber, String businessNumber,
                         String managerMobileNumber, String webSiteAddress){
        super(name,address,postalCode,phoneNumber,CostumerType.LEGALCOSTUMER);
        this.faxNumber=faxNumber;
        this.businessNumber=businessNumber;
        this.managerMobileNumber=managerMobileNumber;
        this.webSiteAddress=webSiteAddress;

    }
    @Override
    public String toString(){
        return super.toString() +"\tfax number: "+this.faxNumber +"\tbusiness number:"
                + this.businessNumber + "\twebsite:" + this.webSiteAddress+"\n\n";
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
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
