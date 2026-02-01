package model;
import exception.InvalidInputException;
import java.util.*;
public class Order extends BaseEntity{
    private Customer customer;private List<OrderItem> items=new ArrayList<>();private double totalPrice;
    public Order(){super(0,"ORDER");}public Order(int id,Customer customer){super(id,"ORDER");this.customer=customer;}
    public Customer getCustomer(){return customer;}public void setCustomer(Customer customer){this.customer=customer;}
    public List<OrderItem> getItems(){return items;}public void setItems(List<OrderItem> items){this.items=items;}
    public double getTotalPrice(){return totalPrice;}public void setTotalPrice(double totalPrice){this.totalPrice=totalPrice;}
    public void addItem(OrderItem oi){items.add(oi);}
    public double calculateTotal(){
        double sum=0;for(OrderItem oi:items)sum+=oi.lineTotal();totalPrice=sum;return sum;
    }
    @Override public void validate()throws InvalidInputException{
        if(customer==null)throw new InvalidInputException("Customer required");
        customer.validate();
        if(items==null||items.isEmpty())throw new InvalidInputException("Order must have items");
        for(OrderItem oi:items)oi.validate();
    }
    @Override public String entityType(){return "Order";}
}
