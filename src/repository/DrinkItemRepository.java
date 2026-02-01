package repository;
import repository.interfaces.CrudRepository;
import model.DrinkItem;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.*;
public class DrinkItemRepository implements CrudRepository<DrinkItem>{
    private DatabaseConnection db;
    public DrinkItemRepository(DatabaseConnection db){
        this.db=db;
    }
    @Override
    public void create(DrinkItem d){
        String sql="INSERT INTO menu_item(name,price,type,volume_ml,alcoholic) VALUES (?,?,?,?,?)";
        try(Connection conn=db.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,d.getName());
            ps.setDouble(2,d.getPrice());
            ps.setString(3,"DRINK");
            ps.setInt(4,d.getVolumeMl());
            ps.setBoolean(5,d.isAlcoholic());
            ps.executeUpdate();
        }catch(SQLException e){throw new RuntimeException(e);}
    }
    @Override
    public List<DrinkItem> getAll(){
        List<DrinkItem> list=new ArrayList<>();
        String sql="SELECT * FROM menu_item WHERE type='DRINK'";
        try(Connection conn=db.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()){
            while(rs.next()){
                list.add(new DrinkItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("volume_ml"),
                        rs.getBoolean("alcoholic")
                ));
            }
        }catch(SQLException e){throw new RuntimeException(e);}
        return list;
    }
    @Override
    public DrinkItem getById(int id){
        String sql="SELECT * FROM menu_item WHERE id=? AND type='DRINK'";
        try(Connection conn=db.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return new DrinkItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("volume_ml"),
                        rs.getBoolean("alcoholic")
                );
            }
        }catch(SQLException e){throw new RuntimeException(e);}
        return null;
    }
    @Override
    public void update(int id,DrinkItem d){
        String sql="UPDATE menu_item SET name=?,price=?,volume_ml=?,alcoholic=? WHERE id=? AND type='DRINK'";
        try(Connection conn=db.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,d.getName());
            ps.setDouble(2,d.getPrice());
            ps.setInt(3,d.getVolumeMl());
            ps.setBoolean(4,d.isAlcoholic());
            ps.setInt(5,id);
            ps.executeUpdate();
        }catch(SQLException e){throw new RuntimeException(e);}
    }
    @Override
    public void delete(int id){
        String sql="DELETE FROM menu_item WHERE id=? AND type='DRINK'";
        try(Connection conn=db.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch(SQLException e){throw new RuntimeException(e);}
    }
}
