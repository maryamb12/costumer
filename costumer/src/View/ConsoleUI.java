package View;

import Util.Exception.*;
import Util.ScannerWrapper;
import View.component.AbstractCostumerUI;
import model.Costumer;
import model.CostumerType;
import service.CostumerService;

import java.util.List;
import java.util.function.Function;

public class ConsoleUI implements AutoCloseable {

    private ScannerWrapper scannerWrapper =ScannerWrapper.getInstance();
    private CostumerService costumerService= CostumerService.getInstance();

    public int startMenu(){
        Integer quit;
        do {
            Menu();
            quit = selectFromMenu();
            try {
                switch (quit) {
                    case 0:
                        quit = 0;
                        break;
                    case 1:
                        enterCostumer();
                        break;
                    case 2:
                        showCostumer();
                        break;
                    case 3:
                        editCostumersByID();
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
            }catch (CostumerIDNotFindException | NoActiveCostumerException e ){
                System.out.println(e.getMessage());
            }
        }while(quit!=0);
        return quit;
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


    private int selectFromMenu() {
        int menuSelected= scannerWrapper.
                getUserInfo("Select from above menu: ",Integer::valueOf);
        return menuSelected;
    }


    private void enterCostumer(){
        int costumerKind= scannerWrapper.getUserInfo("1.Real costumer: \n" +
                        "2.Legal costumer :",Integer::valueOf);
        try {
            costumerService.enterCostumer(AbstractCostumerUI.
                    fromCostumerType(CostumerType.fromValue(costumerKind)).generateCostumer());
            System.out.println("costumer add successfully.");
        } catch (DuplicateCostumerException e) {
            System.out.println("Error: similar costumers!");
            enterCostumer();
        }catch (CostumerTypeException e){
            System.out.println("Error: Wrong number! select again.");
            enterCostumer();
        }
    }

    private void showCostumer() throws NoActiveCostumerException {
        System.out.println("------------Costumers------------");
        costumerService.getActiveCostumers().forEach(System.out::println);
    }

    private void searchAndPrintCostumersByName(){
        String name= scannerWrapper.getUserInfo
                ("Enter name of costumer you want information:",
                        Function.identity());
        List<Costumer> searchList=costumerService.searchCostumerByName(name);
        searchList.forEach(System.out::println);
        if(searchList.isEmpty()){
            System.out.println("there is not costumer with name "+ name);
        }
    }

    public void editCostumersByID() throws CostumerIDNotFindException {
        String id= scannerWrapper.getUserInfo("Enter ID of costumer you want " +
                "change information:",Function.identity());
        Costumer costumer=costumerService.getCostumerById(Integer.valueOf(id));
        AbstractCostumerUI abstractCostumerUI=
                AbstractCostumerUI.fromCostumerType(costumer.getType());
        if(costumer!=null){

            abstractCostumerUI.editCostumer(costumer);
        }
        else{
            System.out.println("there is not costumer with name "+ id);
        }
    }

    public void deleteCostumersById()throws CostumerIDNotFindException{
        String id= scannerWrapper.getUserInfo("Enter ID of costumer" +
                " you want delete:",Function.identity());
        costumerService.deleteCostumer(Integer.valueOf(id));
    }

    public void showDeletedCostumers() throws NoActiveCostumerException{
        costumerService.getDeletedCostumers().forEach(System.out::println);
    }

    public void close(){
        scannerWrapper.close();
    }

}
