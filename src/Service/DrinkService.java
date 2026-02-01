package Service;
import model.DrinkItem;
import repository.interfaces.CrudRepository;
import exception.InvalidInputException;
import java.util.List;
public class DrinkService{
    private CrudRepository<DrinkItem> repo;
    public DrinkService(CrudRepository<DrinkItem> repo){this.repo=repo;}
    public void create(DrinkItem d)throws InvalidInputException{d.validate();repo.create(d);}
    public List<DrinkItem> getAll(){return repo.getAll();}
    public DrinkItem getById(int id){return repo.getById(id);}
    public void update(int id,DrinkItem d)throws InvalidInputException{d.validate();repo.update(id,d);}
    public void delete(int id){repo.delete(id);}
}

