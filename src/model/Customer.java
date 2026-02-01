package model;
import exception.InvalidInputException;
public class Customer extends BaseEntity{
    private String phone;private String email;
    public Customer(){}public Customer(int id,String name,String phone,String email){
        super(id,name);this.phone=phone;this.email=email;}
    public String getPhone(){return phone;}public void setPhone(String phone){this.phone=phone;}
    public String getEmail(){return email;}public void setEmail(String email){this.email=email;}
    @Override public void validate()throws InvalidInputException{
        if(name==null||name.isBlank())throw new InvalidInputException("Customer name required");
        if(phone==null||phone.isBlank())throw new InvalidInputException("Phone required");
    }
    @Override public String entityType(){return "Customer";}
}
