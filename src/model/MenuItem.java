package model;
import exception.InvalidInputException;
public abstract class MenuItem extends BaseEntity implements PricedItem{
    protected double price;
    public MenuItem(){}public MenuItem(int id,String name,double price){super(id,name);this.price=price;}
    public double getPrice(){return price;}public void setPrice(double price){this.price=price;}
    @Override public double price(){return price;}
    public abstract double calculateCalories();
    @Override public void validate()throws InvalidInputException{
        super.validate();
        if(name==null||name.isBlank())throw new InvalidInputException("Name required");
        if(price<=0)throw new InvalidInputException("Price must be > 0");
    }
    @Override public String entityType(){return "MenuItem";}
}
