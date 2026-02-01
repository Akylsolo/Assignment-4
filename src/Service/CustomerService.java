package Service;
import model.Customer;
import repository.interfaces.CrudRepository;
import exception.InvalidInputException;
import java.util.List;
public class CustomerService{
    private CrudRepository<Customer> repo;
    public CustomerService(CrudRepository<Customer> repo){this.repo=repo;}
    public void create(Customer c)throws InvalidInputException{c.validate();repo.create(c);}
    public List<Customer> getAll(){return repo.getAll();}
    public Customer getById(int id){return repo.getById(id);}
    public void update(int id,Customer c)throws InvalidInputException{c.validate();repo.update(id,c);}
    public void delete(int id){repo.delete(id);}
}
