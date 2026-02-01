package model;
import exception.InvalidInputException;
public abstract class BaseEntity implements Validatable{
    protected int id;protected String name;
    public BaseEntity(){}public BaseEntity(int id,String name){this.id=id;this.name=name;}
    public int getId(){return id;}public void setId(int id){this.id=id;}
    public String getName(){return name;}public void setName(String name){this.name=name;}
    public abstract String entityType();
    public String info(){return entityType()+": "+id+" "+(name==null?"":name);}
    @Override public void validate()throws InvalidInputException{
        if(name!=null&&name.isBlank())throw new InvalidInputException("Name cannot be empty");
    }
}
