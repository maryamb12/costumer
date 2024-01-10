package model;

public abstract class Costumer {
    private String name;
    private String address;
    private String postalCode;
    private String phoneNumber;
    private CostumerType type;

    public Costumer (String name, String address,String postalCode, String phoneNumber,
                     CostumerType type){
        this.name=name;
        this.address=address;
        this.postalCode=postalCode;
        this.phoneNumber=phoneNumber;
        this.type=type;
    }


    @Override
    public String toString(){
        return "name:"+ this.name +"\t address: "+this.address+"\tpostal code: "
                + this.postalCode+"\nPhone number: "+ this.phoneNumber;
    }


    //getters and setters
    public CostumerType getType() {
        return type;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
