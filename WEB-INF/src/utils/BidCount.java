package utils;
import java.sql.*;

public class BidCount{
    public static Integer getBidCount(int propertyId){
        Connection con = null;
        Integer bidCount = 0;
        try{
            con = DBBoard.getConnection();
            String query = " select max(bid_count) from user_property where property_id=?";
            PreparedStatement pst = con.prepareStatement(query);
    
            pst.setInt(1,propertyId);
           
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
               bidCount = rs.getInt(1);
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
        return bidCount;
    }

    public static void decreaseBidCount(Integer propertyId,Integer bid){
        Connection con = null;
       
        try{
            con = DBBoard.getConnection();
            String query = "update user_property set bid_count=? where property_id=? and prop_action_id=3";
            PreparedStatement pst = con.prepareStatement(query);
            bid--;
            pst.setInt(1,bid);
            pst.setInt(2,propertyId);
           
            int rs = pst.executeUpdate();	
    
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

