package Controller;
import Service.CustomerService;
import model.Customer;
import exception.InvalidInputException;
import java.util.List;
public class CustomerController{
    private CustomerService service;
    public CustomerController(CustomerService service){this.service=service;}
    public void list(){
        List<Customer> list=service.getAll();
        for(Customer c:list)System.out.println(c.getId()+" | "+c.getName()+" | "+c.getPhone());
    }
    public void add(Customer c)throws InvalidInputException{service.create(c);}
}
