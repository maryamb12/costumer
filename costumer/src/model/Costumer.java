package model;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Costumer {
    private static final AtomicInteger ID_COUNTER =new AtomicInteger(1);
    private Integer id;
    private String name;
    private String address;
    private String postalCode;
    private String phoneNumber;
    private CostumerType type;
    private Boolean deleted;

    public Costumer (String name, String address,String postalCode, String phoneNumber,
                     CostumerType type){
        this.id=ID_COUNTER.getAndIncrement();
        this.name=name;
        this.address=address;
        this.postalCode=postalCode;
        this.phoneNumber=phoneNumber;
        this.type=type;
        this.deleted=false;
    }


    @Override
    public String toString(){
        return "ID: "+this.id+"\tname:"+ this.name +"\t address: "+this.address+"\tpostal code: "
                + this.postalCode+"\nPhone number: "+ this.phoneNumber;
    }


    //getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

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
