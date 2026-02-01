package Controller;
import Service.OrderService;
import model.Order;
import exception.InvalidInputException;
import java.util.List;
public class OrderController{
    private OrderService service;
    public OrderController(OrderService service){this.service=service;}
    public void create(Order o)throws InvalidInputException{service.create(o);}
    public void list(){
        List<Order> list=service.getAll();
        for(Order o:list)System.out.println("Order "+o.getId()+" total="+o.getTotalPrice());
    }
}
