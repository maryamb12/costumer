package service;


import model.Costumer;
import model.CostumerType;
import model.LegalCostumer;
import model.RealCostumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Account {
    public ArrayList<Costumer> costumers = new ArrayList<>();
    private Scanner scanner=new Scanner(System.in);

    public void Runner(){
        int quit=1;
        do{
            Menu();
            quit=SelectFromMenu();
            switch (quit){
                case 0:
                    quit=0;
                    break;
                case 1:
                    EnterCostumer();
                    break;
                case 2:
                    ShowCostumer();
                    break;
                case 3:
                    EditCostumer();
                    break;
                case 4:
                    SearchCostumer();
                    break;
                case 5:
                    DeletCostumer();
                    break;
                default:
                    System.out.println("you chose wrong number!! select again");
            }
        }while(quit!=0);
    }

    public String getUserInfo(String str) {
        System.out.println(str);
        return scanner.nextLine();
    }

    public int SelectFromMenu() {
        System.out.println("Select from above menu: ");
        int menuSelected=scanner.nextInt();
        scanner.nextLine();
        return menuSelected;
    }


    public void Menu(){
        System.out.println("-----------Menu-------------");
        System.out.println("0. Exit ");
        System.out.println("1. Enter new costumer");
        System.out.println("2. Show costumer ");
        System.out.println("3. Edit costumer by name");
        System.out.println("4. search costumer by name");
        System.out.println("5. delete costumer by name");
        System.out.println("----------------------------");
    }

    public void EnterCostumer(){
        System.out.println("1.Real costumer:");
        System.out.println("2.Legal costumer  (or other number ):");
        int costumerkind=scanner.nextInt();
        scanner.nextLine();
        if(costumerkind==1){
            String name = getUserInfo("Enter Costumer name:");
            String family=getUserInfo("Enter family:");
            String address = getUserInfo("Enter Costumer address:");
            String postalcode=getUserInfo("Enter postal code:");
            String phoneNumber=getUserInfo("Enter phone number:");
            String nationalCode=getUserInfo("Enter national code:");
            String workingMoblieNumber=getUserInfo("Enter working mobile number:");
            String personalMoblieNumber=getUserInfo("Enter personal mobile number:");
            String workingEmail=getUserInfo("Enter working Email:");
            String personalEmail=getUserInfo("Enter personal Email:");
            RealCostumer newRealCostumer=new RealCostumer(name,address,postalcode,phoneNumber,
                    family,nationalCode,workingMoblieNumber,personalMoblieNumber,
                    workingEmail,personalEmail);
            costumers.add(newRealCostumer);
            System.out.println("costumer add successfully.");
        }
        else {
            String name = getUserInfo("Enter Costumer name:");
            String address = getUserInfo("Enter Costumer address:");
            String postalcode=getUserInfo("Enter postal code:");
            String phoneNumber=getUserInfo("Enter phone number:");
            String faxNumber=getUserInfo("Enter fax number: ");
            String businessNumber=getUserInfo("Enter your business number: ");
            String mangerNumber=getUserInfo("Enter manager phone number:");
            String webSiteAddress= getUserInfo("Enter websibe address:");
            LegalCostumer newLegalNumber = new LegalCostumer(name,address,postalcode,
                    phoneNumber,faxNumber,businessNumber,mangerNumber,webSiteAddress);
            costumers.add(newLegalNumber);
            System.out.println("costumer add successfully.");

        }
    }

    public void ShowCostumer(){
        System.out.println("------------Costumers------------");
        costumers.stream()
                .forEach(System.out::println);

    }

    public void EditCostumer(){
        String name=getUserInfo("Enter name of costumer you want change information:");
        boolean isThere=false;
        for(Costumer costumer:costumers){
            if(costumer.getName().equalsIgnoreCase(name)){
                isThere=true;
                if(costumer.getType()== CostumerType.REALCOSTUMER){
                    String family=getUserInfo("Enter family:");
                    ((RealCostumer)costumer).setFamily(family);
                    String address = getUserInfo("Enter Costumer address:");
                    costumer.setAddress(address);
                    String postalcode=getUserInfo("Enter postal code:");
                    costumer.setPostalCode(postalcode);
                    String phoneNumber=getUserInfo("Enter phone number:");
                    costumer.setPhoneNumber(phoneNumber);
                    String nationalCode=getUserInfo("Enter national code:");
                    ((RealCostumer) costumer).setNationalCode(nationalCode);
                    String workingMoblieNumber=getUserInfo("Enter working mobile number:");
                    ((RealCostumer) costumer).setWorkingMobileNumber(workingMoblieNumber);
                    String personalMoblieNumber=getUserInfo("Enter personal mobile number:");
                    ((RealCostumer) costumer).setPersonalMobileNumber(personalMoblieNumber);
                    String workingEmail=getUserInfo("Enter working Email:");
                    ((RealCostumer) costumer).setWorkingEmail(workingEmail);
                    String personalEmail=getUserInfo("Enter personal Email:");
                    ((RealCostumer) costumer).setPersonalEmail(personalEmail);
                }
                else {
                    String address = getUserInfo("Enter Costumer address:");
                    costumer.setAddress(address);
                    String postalcode=getUserInfo("Enter postal code:");
                    costumer.setPostalCode(postalcode);
                    String phoneNumber=getUserInfo("Enter phone number:");
                    costumer.setPhoneNumber(phoneNumber);
                    String faxNumber=getUserInfo("Enter fax number: ");
                    ((LegalCostumer)costumer).setFaxNumber(faxNumber);
                    String businessNumber=getUserInfo("Enter your business number: ");
                    ((LegalCostumer) costumer).setBusinessNumber(businessNumber);
                    String mangerNumber=getUserInfo("Enter manager phone number:");
                    ((LegalCostumer) costumer).setManagerMobileNumber(mangerNumber);
                    String webSiteAddress= getUserInfo("Enter website address:");
                    ((LegalCostumer) costumer).setWebSiteAddress(webSiteAddress);
                }
            }
        }
        if(isThere){
            System.out.println("there is not costumer with name "+ name);
        }
    }

    public void SearchCostumer(){
        String name=getUserInfo("Enter name of costumer you want change information:");
        List<Costumer> searchList=new ArrayList<>();
        searchList=costumers.stream()
                .filter(costumer -> costumer.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        searchList.stream()
                .forEach(System.out::println);
        if(searchList.isEmpty()){
            System.out.println("there is not costumer with name "+ name);
        }
    }


    public void DeletCostumer(){
        String name=getUserInfo("Enter name of costumer you want delete:");
        List<Costumer> deletedCostumers=costumers.stream()
                .filter(costumer -> costumer.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        if(deletedCostumers.isEmpty()){
            System.out.println("there is no costumer with this name:");
        }
        else {
            costumers.removeAll(deletedCostumers);
            System.out.println("It delete successfully.");
        }

    }
}
