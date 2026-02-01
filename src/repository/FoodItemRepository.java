package repository;
import repository.interfaces.CrudRepository;
import model.FoodItem;
import utils.DatabaseConnection;
import java.sql.*;import java.util.*;
public class FoodItemRepository implements CrudRepository<FoodItem>{
    private DatabaseConnection db;
    public FoodItemRepository(DatabaseConnection db){this.db=db;}
    @Override public void create(FoodItem f){
        String sql="INSERT INTO menu_item(name,price,type,vegetarian,calories_per_100g) VALUES (?,?,?,?,?)";
        try(Connection c=db.getConnection();PreparedStatement p=c.prepareStatement(sql)){
            p.setString(1,f.getName());p.setDouble(2,f.getPrice());
            p.setString(3,"FOOD");p.setBoolean(4,f.isVegetarian());p.setDouble(5,f.getCaloriesPer100g());
            p.executeUpdate();
        }catch(SQLException e){throw new RuntimeException(e);}
    }
    @Override public List<FoodItem> getAll(){
        List<FoodItem> list=new ArrayList<>();
        String sql="SELECT * FROM menu_item WHERE type='FOOD'";
        try(Connection c=db.getConnection();PreparedStatement p=c.prepareStatement(sql);ResultSet r=p.executeQuery()){
            while(r.next()){
                list.add(new FoodItem(
                        r.getInt("id"),r.getString("name"),r.getDouble("price"),
                        r.getBoolean("vegetarian"),r.getDouble("calories_per_100g")
                ));
            }
        }catch(SQLException e){throw new RuntimeException(e);}
        return list;
    }
    @Override public FoodItem getById(int id){
        String sql="SELECT * FROM menu_item WHERE id=? AND type='FOOD'";
        try(Connection c=db.getConnection();PreparedStatement p=c.prepareStatement(sql)){
            p.setInt(1,id);ResultSet r=p.executeQuery();
            if(r.next())return new FoodItem(
                    r.getInt("id"),r.getString("name"),r.getDouble("price"),
                    r.getBoolean("vegetarian"),r.getDouble("calories_per_100g")
            );
        }catch(SQLException e){throw new RuntimeException(e);}
        return null;
    }
    @Override public void update(int id,FoodItem f){
        String sql="UPDATE menu_item SET name=?,price=?,vegetarian=?,calories_per_100g=? WHERE id=? AND type='FOOD'";
        try(Connection c=db.getConnection();PreparedStatement p=c.prepareStatement(sql)){
            p.setString(1,f.getName());p.setDouble(2,f.getPrice());
            p.setBoolean(3,f.isVegetarian());p.setDouble(4,f.getCaloriesPer100g());
            p.setInt(5,id);p.executeUpdate();
        }catch(SQLException e){throw new RuntimeException(e);}
    }
    @Override public void delete(int id){
        String sql="DELETE FROM menu_item WHERE id=? AND type='FOOD'";
        try(Connection c=db.getConnection();PreparedStatement p=c.prepareStatement(sql)){
            p.setInt(1,id);p.executeUpdate();
        }catch(SQLException e){throw new RuntimeException(e);}
    }
}
