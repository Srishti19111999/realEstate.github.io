package models;

import java.sql.*;

import java.util.ArrayList;
import utils.DBBoard;

public class PropertyPoint{
    private Integer propertyPointsId;
    private Property propertyId;
    private String descriptionPoint;

    PropertyPoint(){
        super();
    }
    PropertyPoint(String descriptionPoint){
        super();
        this.descriptionPoint = descriptionPoint;
    }
    //-----------------------------------------------------------------------------------------------------

    public static boolean deleteProperty(Integer propertyId){
        boolean flag = false;
        Connection con = null;

        try{
            con = DBBoard.getConnection();
            String query = "";
            PreparedStatement pst = null;
  
                query = " delete from property_points where property_id=?";
            
                pst = con.prepareStatement(query);
                pst.setInt(1,propertyId);


            int res = pst.executeUpdate();
            

                flag = true;

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return flag;
    }
    
    public static ArrayList<PropertyPoint> collectAllPropertyPoints(Integer propertyId){
		ArrayList<PropertyPoint> propertyPoints = new ArrayList<PropertyPoint>();
		
		Connection con = null;

        try{
            con = DBBoard.getConnection();
            String query = "select description_point from property_points where property_id = ?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1,propertyId);

            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                propertyPoints.add(new PropertyPoint(rs.getString(1)));
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

		return propertyPoints;
	}


    public static void savePropertyFeaturePoints(Integer propertyId,String[] descriptionPoint){
        Connection con = null;

        try{
            con = DBBoard.getConnection();
            String query = "insert into property_points (property_id,description_point) value (?,?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1,propertyId);

            for(int i =0; i<descriptionPoint.length;i++){

                pst.setString(2,descriptionPoint[i]);

                pst.executeUpdate();
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
    }

  //---------------------------------------------------------------------------------------------
   
    public Integer getPropertyPointsId(){
        return this.propertyPointsId;
    }
    public String getDescriptionPoint(){
        return this.descriptionPoint;
    }
    public Property getPropertyId(){
        return this.propertyId;
    }

    public void setPropertyPointsId(Integer propertyPointsId){
        this.propertyPointsId = propertyPointsId ;
    }
    public void setDescriptionPoint(String descriptionPoint){
        this.descriptionPoint = descriptionPoint;
    }
    public void setPropertyId(Property propertyId){
        this.propertyId = propertyId;
    }
    
}