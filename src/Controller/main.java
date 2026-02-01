package Controller;
import utils.DatabaseConnection;
import repository.*;
import repository.interfaces.CrudRepository;
import Service.*;
import model.*;
import exception.InvalidInputException;
import java.util.*;
public class main{
    public static void main(String[]args)throws Exception{
        DatabaseConnection db=new DatabaseConnection(
                "jdbc:postgresql://localhost:5432/java",
                "postgres",
                "Akyl2008"
        );
        CrudRepository<FoodItem> foodRepo=new FoodItemRepository(db);
        CrudRepository<DrinkItem> drinkRepo=new DrinkItemRepository(db);
        CrudRepository<Customer> customerRepo=new CustomerRepository(db);
        OrderRepository orderRepo=new OrderRepository(db);
        FoodService foodService=new FoodService(foodRepo);
        DrinkService drinkService=new DrinkService(drinkRepo);
        CustomerService customerService=new CustomerService(customerRepo);
        OrderService orderService=new OrderService(orderRepo);
        Сontroller.FoodController foodController=new Сontroller.FoodController(foodService);
        DrinkController drinkController=new DrinkController(drinkService);
        CustomerController customerController=new CustomerController(customerService);
        OrderController orderController=new OrderController(orderService);
        System.out.println("FOODS:");
        foodController.list();
        System.out.println("\nDRINKS:");
        drinkController.list();
        System.out.println("\nCUSTOMERS:");
        customerController.list();
        System.out.println("\nORDERS:");
        orderController.list();
    }
}
