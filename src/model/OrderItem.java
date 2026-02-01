package model;
import exception.InvalidInputException;
public class OrderItem implements Validatable{
    private MenuItem item;private int quantity;
    public OrderItem(){}public OrderItem(MenuItem item,int quantity){this.item=item;this.quantity=quantity;}
    public MenuItem getItem(){return item;}public void setItem(MenuItem item){this.item=item;}
    public int getQuantity(){return quantity;}public void setQuantity(int quantity){this.quantity=quantity;}
    public double lineTotal(){return item.price()*quantity;}
    @Override public void validate()throws InvalidInputException{
        if(item==null)throw new InvalidInputException("Item required");
        item.validate();
        if(quantity<=0)throw new InvalidInputException("Quantity must be > 0");
    }
}
