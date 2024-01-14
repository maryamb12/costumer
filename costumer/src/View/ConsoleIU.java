package View;

import model.Costumer;
import model.CostumerType;
import model.LegalCostumer;
import model.RealCostumer;
import service.CostumerService;

import java.util.List;
import java.util.Scanner;

public class ConsoleIU implements AutoCloseable {

    private Scanner scanner=new Scanner(System.in);
    private CostumerService costumerService= CostumerService.getInstance();

    public void startMenu(){
        int quit;
        do{
            Menu();
            quit= selectFromMenu();
            switch (quit){
                case 0:
                    quit=0;
                    break;
                case 1:
                    enterCostumer();
                    break;
                case 2:
                    showCostumer();
                    break;
                case 3:
                    editCostumersByName();
                    break;
                case 4:
                    searchAndPrintCostumersByName();
                    break;
                case 5:
                    deleteCostumersById();
                    break;
                case 6:
                    showDeletedCostumers();
                    break;
                default:
                    System.out.println("you chose wrong number!! select again");
            }
        }while(quit!=0);
    }


    private void Menu(){
        System.out.println("-----------Menu-------------");
        System.out.println("0. Exit ");
        System.out.println("1. Enter new costumer");
        System.out.println("2. Show costumer ");
        System.out.println("3. Edit costumer by ID");
        System.out.println("4. search costumer by name");
        System.out.println("5. delete costumer by ID");
        System.out.println("6. Show deleted costumers");
        System.out.println("----------------------------");
    }

    private String getUserInfo(String str) {
        System.out.println(str);
        return scanner.nextLine();
    }

    private int selectFromMenu() {
        System.out.println("Select from above menu: ");
        int menuSelected=scanner.nextInt();
        scanner.nextLine();
        return menuSelected;
    }


    private void enterCostumer(){
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
            costumerService.enterCostumer(newRealCostumer);
            System.out.println("costumer add successfully.");
        }
        else {
            String name = getUserInfo("Enter Costumer name:");
            String address = getUserInfo("Enter Costumer address:");
            String postalcode=getUserInfo("Enter postal code:");
            String phoneNumber=getUserInfo("Enter phone number:");
            String faxNumber=getUserInfo("Enter fax number: ");
            String businessNumber=getUserInfo("Enter your business code: ");
            String mangerNumber=getUserInfo("Enter manager phone number:");
            String webSiteAddress= getUserInfo("Enter websibe address:");
            LegalCostumer newLegalNumber = new LegalCostumer(name,address,postalcode,
                    phoneNumber,faxNumber,businessNumber,mangerNumber,webSiteAddress);
            costumerService.enterCostumer(newLegalNumber);
            System.out.println("costumer add successfully.");

        }
    }

    private void showCostumer(){
        if(costumerService.getActiveCostumers().isEmpty()){
            System.out.println("There is no costumers!!");
        }
        else {
            System.out.println("------------Costumers------------");
            costumerService.getActiveCostumers().forEach(System.out::println);
        }
    }

    private void searchAndPrintCostumersByName(){
        String name=getUserInfo("Enter name of costumer you want change information:");
        List<Costumer> searchList=costumerService.searchCostumerByName(name);
        searchList.forEach(System.out::println);
        if(searchList.isEmpty()){
            System.out.println("there is not costumer with name "+ name);
        }
    }

    public void editCostumersByName(){
        String id=getUserInfo("Enter ID of costumer you want change information:");
        Costumer costumer=costumerService.getCostumerById(Integer.valueOf(id));
        if(costumer!=null){
            if(costumer.getType()== CostumerType.REALCOSTUMER){
                String name=getUserInfo("Enter name:");
                costumer.setName(name);
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
                String name=getUserInfo("Enter name:");
                costumer.setName(name);
                String address = getUserInfo("Enter Costumer address:");
                costumer.setAddress(address);
                String postalcode=getUserInfo("Enter postal code:");
                costumer.setPostalCode(postalcode);
                String phoneNumber=getUserInfo("Enter phone number:");
                costumer.setPhoneNumber(phoneNumber);
                String faxNumber=getUserInfo("Enter fax number: ");
                ((LegalCostumer)costumer).setFaxNumber(faxNumber);
                String businessNumber=getUserInfo("Enter your business code: ");
                ((LegalCostumer) costumer).setBusinessCode(businessNumber);
                String mangerNumber=getUserInfo("Enter manager phone number:");
                ((LegalCostumer) costumer).setManagerMobileNumber(mangerNumber);
                String webSiteAddress= getUserInfo("Enter website address:");
                ((LegalCostumer) costumer).setWebSiteAddress(webSiteAddress);
            }
        }
        else{
            System.out.println("there is not costumer with name "+ id);
        }
    }

    public void deleteCostumersById(){
        String id=getUserInfo("Enter ID of costumer you want delete:");
        List<Costumer> anyCostomerWithThatName = costumerService.deleteCostumer(Integer.valueOf(id));
        if(anyCostomerWithThatName.isEmpty()){
            System.out.println("there is no costumers with this name.");
        }
        else {
            System.out.println("Costumer delete successfully.");
        }
    }

    public void showDeletedCostumers(){
        costumerService.getDeletedCostumers().forEach(System.out::println);
    }

    public void close(){
        scanner.close();
    }

}
