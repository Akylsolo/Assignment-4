package Service;
import model.FoodItem;
import repository.interfaces.CrudRepository;
import exception.InvalidInputException;
import java.util.List;

public class FoodService{
    private CrudRepository<FoodItem> repo;
    public FoodService(CrudRepository<FoodItem> repo){this.repo=repo;}
    public void create(FoodItem f)throws InvalidInputException{f.validate();repo.create(f);}
    public List<FoodItem> getAll(){return repo.getAll();}
    public FoodItem getById(int id){return repo.getById(id);}
    public void update(int id,FoodItem f)throws InvalidInputException{f.validate();repo.update(id,f);}
    public void delete(int id){repo.delete(id);}
}
