package Service;
import model.Order;
import exception.InvalidInputException;
public class OrderService{
    private repository.OrderRepository repo;
    public OrderService(repository.OrderRepository repo){this.repo=repo;}
    public void create(Order o)throws InvalidInputException{o.validate();o.calculateTotal();repo.create(o);}
    public java.util.List<Order> getAll(){return repo.getAll();}
}
