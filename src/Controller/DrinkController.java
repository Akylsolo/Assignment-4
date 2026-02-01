package Controller;
import Service.DrinkService;
import model.DrinkItem;
import exception.InvalidInputException;
import java.util.List;
public class DrinkController{
    private DrinkService service;
    public DrinkController(DrinkService service){this.service=service;}
    public void list(){
        List<DrinkItem> list=service.getAll();
        for(DrinkItem d:list)System.out.println(d.getId()+" | "+d.getName()+" | "+d.getPrice());
    }
    public void add(DrinkItem d)throws InvalidInputException{service.create(d);}
}
