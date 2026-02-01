package repository;
import model.*;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.*;
public class OrderRepository {
    private DatabaseConnection db;
    public OrderRepository(DatabaseConnection db){
        this.db=db;
    }
    public void create(Order order){
        String sqlOrder="INSERT INTO order_table(customer_id,total_price) VALUES (?,?) RETURNING id";
        String sqlItem="INSERT INTO order_item(order_id,menu_item_id,quantity) VALUES (?,?,?)";

        try(Connection conn=db.getConnection();
            PreparedStatement psOrder=conn.prepareStatement(sqlOrder);
            PreparedStatement psItem=conn.prepareStatement(sqlItem)){

            psOrder.setInt(1,order.getCustomer().getId());
            psOrder.setDouble(2,order.getTotalPrice());

            ResultSet rs=psOrder.executeQuery();
            if(rs.next()){
                int orderId=rs.getInt(1);
                for(OrderItem oi:order.getItems()){
                    psItem.setInt(1,orderId);
                    psItem.setInt(2,oi.getItem().getId());
                    psItem.setInt(3,oi.getQuantity());
                    psItem.addBatch();
                }
                psItem.executeBatch();
            }
        }catch(SQLException e){e.printStackTrace();}
    }

    public List<Order> getAll(){
        List<Order> orders=new ArrayList<>();
        String sqlOrder="SELECT id,customer_id,total_price FROM order_table";
        String sqlItem="SELECT menu_item_id,quantity FROM order_item WHERE order_id=?";

        try(Connection conn=db.getConnection();
            PreparedStatement psOrder=conn.prepareStatement(sqlOrder);
            ResultSet rsOrder=psOrder.executeQuery()){

            while(rsOrder.next()){
                Order order=new Order();
                order.setId(rsOrder.getInt("id"));
                order.setTotalPrice(rsOrder.getDouble("total_price"));
                List<OrderItem> items=new ArrayList<>();
                try(PreparedStatement psItem=conn.prepareStatement(sqlItem)){
                    psItem.setInt(1,order.getId());
                    ResultSet rsItem=psItem.executeQuery();
                    while(rsItem.next()){
                        MenuItem mi=new MenuItem(
                                rsItem.getInt("menu_item_id"),
                                "",0
                        ){public double calculateCalories(){return 0;}};

                        items.add(new OrderItem(mi,rsItem.getInt("quantity")));
                    }
                }
                order.setItems(items);
                orders.add(order);
            }
        }catch(SQLException e){e.printStackTrace();}
        return orders;
    }
}
