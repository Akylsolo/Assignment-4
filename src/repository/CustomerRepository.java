package repository;
import repository.interfaces.CrudRepository;
import model.Customer;
import utils.DatabaseConnection;
import java.sql.*;import java.util.*;
public class CustomerRepository implements CrudRepository<Customer>{
    private DatabaseConnection db;
    public CustomerRepository(DatabaseConnection db){this.db=db;}
    @Override public void create(Customer c){
        String sql="INSERT INTO customer(name,phone,email) VALUES (?,?,?)";
        try(Connection cn=db.getConnection();PreparedStatement p=cn.prepareStatement(sql)){
            p.setString(1,c.getName());p.setString(2,c.getPhone());p.setString(3,c.getEmail());
            p.executeUpdate();
        }catch(SQLException e){throw new RuntimeException(e);}
    }
    @Override public List<Customer> getAll(){
        List<Customer> list=new ArrayList<>();
        try(Connection cn=db.getConnection();PreparedStatement p=cn.prepareStatement("SELECT * FROM customer");ResultSet r=p.executeQuery()){
            while(r.next()){
                list.add(new Customer(r.getInt("id"),r.getString("name"),r.getString("phone"),r.getString("email")));
            }
        }catch(SQLException e){throw new RuntimeException(e);}
        return list;
    }
    @Override public Customer getById(int id){
        try(Connection cn=db.getConnection();PreparedStatement p=cn.prepareStatement("SELECT * FROM customer WHERE id=?")){
            p.setInt(1,id);ResultSet r=p.executeQuery();
            if(r.next())return new Customer(r.getInt("id"),r.getString("name"),r.getString("phone"),r.getString("email"));
        }catch(SQLException e){throw new RuntimeException(e);}
        return null;
    }
    @Override public void update(int id,Customer c){
        String sql="UPDATE customer SET name=?,phone=?,email=? WHERE id=?";
        try(Connection cn=db.getConnection();PreparedStatement p=cn.prepareStatement(sql)){
            p.setString(1,c.getName());p.setString(2,c.getPhone());p.setString(3,c.getEmail());p.setInt(4,id);
            p.executeUpdate();
        }catch(SQLException e){throw new RuntimeException(e);}
    }
    @Override public void delete(int id){
        try(Connection cn=db.getConnection();PreparedStatement p=cn.prepareStatement("DELETE FROM customer WHERE id=?")){
            p.setInt(1,id);p.executeUpdate();
        }catch(SQLException e){throw new RuntimeException(e);}
    }
}
