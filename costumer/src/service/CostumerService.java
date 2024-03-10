package service;


import Util.Exception.CostumerIDNotFindException;
import Util.Exception.DuplicateCostumerException;
import Util.Exception.NoActiveCostumerException;
import model.Costumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CostumerService {
    public ArrayList<Costumer> costumers = new ArrayList<>();

    private static final CostumerService INSTANCE;

    static {
        INSTANCE= new CostumerService();
    }

    public static final CostumerService getInstance(){
        return INSTANCE;
    }

    private CostumerService(){

    }

    public void enterCostumer(Costumer costumer) throws DuplicateCostumerException{
        Optional<Costumer> any = costumers.stream()
                .filter(it -> it.equals(costumer))
                .findAny();
        if(any.isPresent()){
            throw new DuplicateCostumerException();
        }
        costumers.add(costumer);
    }

    public List<Costumer> getActiveCostumers() throws NoActiveCostumerException {
        List<Costumer> activeList= costumers.stream()
                .filter(costumer -> !costumer.getDeleted())
                .collect(Collectors.toList());
        if(activeList.isEmpty()){
            throw new NoActiveCostumerException();
        }
        return activeList;
    }


    public List<Costumer> searchCostumerByName(String name){
        List<Costumer> searchList=new ArrayList<>();
        searchList=costumers.stream()
                .filter(costumer -> !costumer.getDeleted())
                .filter(costumer -> costumer.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        return searchList;
    }


    public void deleteCostumer(Integer id) throws CostumerIDNotFindException {
        getCostumerById(id).setDeleted(true);
    }

    public List<Costumer> getDeletedCostumers() throws NoActiveCostumerException{
        List<Costumer> collect = costumers.stream()
                .filter(costumer -> costumer.getDeleted())
                .collect(Collectors.toList());
        if(collect.isEmpty())
            throw new NoActiveCostumerException();
        return collect;
    }

    public Costumer getCostumerById(Integer id)throws CostumerIDNotFindException{
         return costumers.stream()
                .filter(costumer -> !costumer.getDeleted())
                .filter(costumer -> costumer.getId().equals(id))
                 .findFirst().orElseThrow(CostumerIDNotFindException::new);

    }

}
