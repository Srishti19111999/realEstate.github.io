package utils;
import java.sql.*;

public class WishCount{
    public static Integer getWishCount(int propertyId){
        Connection con = null;
        Integer wishCount = 0;
        try{
            con = DBBoard.getConnection();
            String query = " select max(wish_count) from user_property where property_id=?";
            PreparedStatement pst = con.prepareStatement(query);
    
            pst.setInt(1,propertyId);
           
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
               wishCount = rs.getInt(1);
            }	
    
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return wishCount;
    }

    public static void decreaseWishCount(Integer propertyId,Integer wish){
        Connection con = null;
       
        try{
            con = DBBoard.getConnection();
            String query = "update user_property set wish_count=? where property_id=? and prop_action_id=2";
            PreparedStatement pst = con.prepareStatement(query);
            wish--;
            pst.setInt(1,wish);
            pst.setInt(2,propertyId);
           
            ResultSet rs = pst.executeQuery();	
    
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}

