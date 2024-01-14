package service;


import model.Costumer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CostumerService {
    public ArrayList<Costumer> costumers = new ArrayList<>();

    private static final CostumerService INSTANCE;

    public static final CostumerService getInstance(){
        return INSTANCE;
    }

    static {
        INSTANCE= new CostumerService();
    }

    private CostumerService(){

    }

    public void enterCostumer(Costumer costumer){
        costumers.add(costumer);
    }

    public List<Costumer> getActiveCostumers(){
        return costumers.stream()
                .filter(costumer -> !costumer.getDeleted())
                .collect(Collectors.toList());
    }


    public List<Costumer> searchCostumerByName(String name){
        List<Costumer> searchList=new ArrayList<>();
        searchList=costumers.stream()
                .filter(costumer -> !costumer.getDeleted())
                .filter(costumer -> costumer.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        return searchList;
    }


    public List<Costumer> deleteCostumer(Integer id){
        List<Costumer> deletedList=new ArrayList<>();
        deletedList=costumers.stream()
                .filter(costumer -> !costumer.getDeleted())
                .filter(costumer -> costumer.getId().equals(id))
                .collect(Collectors.toList());

        costumers.stream()
                .filter(costumer -> !costumer.getDeleted())
                .filter(costumer -> costumer.getId().equals(id))
                .forEach(costumer -> costumer.setDeleted(true));

       return deletedList;
    }

    public List<Costumer> getDeletedCostumers(){
       return costumers.stream()
                .filter(costumer -> costumer.getDeleted())
                .collect(Collectors.toList());
    }

    public Costumer getCostumerById(Integer id){
        return costumers.stream()
                .filter(costumer -> !costumer.getDeleted())
                .filter(costumer -> costumer.getId().equals(id))
                .findFirst().get();
    }

}
