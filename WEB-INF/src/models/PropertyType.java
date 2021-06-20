package models;

import java.sql.*;
import java.util.ArrayList;
import utils.DBBoard;


public class PropertyType{
    private Integer propertyTypeId;
    private String propertyType;
    private String propertyTypeDesc;

    public PropertyType(){
        super();
    }
    public PropertyType(Integer propertyTypeId){
		this.propertyTypeId = propertyTypeId;
    }
    public PropertyType(String propertyType){
		this.propertyType = propertyType;
    }
    public PropertyType(Integer propertyTypeId,String propertyType){
        this.propertyTypeId = propertyTypeId;
		this.propertyType = propertyType;
    }
    
    public static ArrayList<PropertyType> collectTypes(){
        ArrayList<PropertyType> propTypes = new ArrayList<PropertyType>();
		Connection con = null;
        
        try{
            con = DBBoard.getConnection();
            String query = "select * from property_type";
            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                propTypes.add(new PropertyType(rs.getInt(1),rs.getString(2)));
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
        return propTypes;
    }


    //----------------------------------------------------------------------------------------
    public Integer getPropertyTypeId(){
        return this.propertyTypeId;
    }
    public String getPropertyType(){
        return this.propertyType;
    }
    public String getPropertyTypeDesc(){
        return this.propertyTypeDesc;
    }

    public void setPropertyPicId(Integer propertyTypeId){
        this.propertyTypeId = propertyTypeId ;
    }
    public void setPropertyType(String propertyType){
        this.propertyType = propertyType;
    }
    public void setPropertyTypeDesc(String propertyTypeDesc){
        this.propertyTypeDesc = propertyTypeDesc;
    }
    
}