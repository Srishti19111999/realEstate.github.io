package models;

import java.sql.*;
import java.util.ArrayList;
import utils.DBBoard;


public class PropertyStatus{
    private Integer propertyStatusId;
    private String propertyStatusType;
//-----------------------------------------------------------
    
    public PropertyStatus(){
        super();
    }
    public PropertyStatus(Integer propertyStatusId){
        this.propertyStatusId = propertyStatusId;
    }
    public PropertyStatus(String propertyStatusType){
        this.propertyStatusType = propertyStatusType;
    }
    public PropertyStatus(Integer propertyStatusId,String propertyStatusType){
        this.propertyStatusId = propertyStatusId;
        this.propertyStatusType = propertyStatusType;
    }

//------------------------------------------------------------

    public static ArrayList<PropertyStatus> collectStatus(){
        ArrayList<PropertyStatus> propStatuses = new ArrayList<PropertyStatus>();
        Connection con = null;
        
        try{
            con = DBBoard.getConnection();
            String query = "select * from property_status";
            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                propStatuses.add(new PropertyStatus(rs.getInt(1),rs.getString(2)));
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
        return propStatuses;
    }




//-----------------------------------------------------------
    public void setPropertyStatusId(Integer propertyStatusId ){
        this.propertyStatusId = propertyStatusId;
    }
    public void setPropertyStatusType(String propertyStatusType ){
        this.propertyStatusType = propertyStatusType;
    }
    public Integer getPropertyStatusId(){
        return this.propertyStatusId;
     }
    public String getPropertyStatusType(){
       return this.propertyStatusType;
    }
    
}