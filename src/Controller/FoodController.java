package Сontroller;
import Service.FoodService;
import model.FoodItem;
import exception.InvalidInputException;
import java.util.List;
public class FoodController{
    private FoodService service;
    public FoodController(FoodService service){this.service=service;}
    public void list(){
        List<FoodItem> list=service.getAll();
        for(FoodItem f:list)System.out.println(f.getId()+" | "+f.getName()+" | "+f.getPrice());
    }
    public void add(FoodItem f)throws InvalidInputException{service.create(f);}
}
