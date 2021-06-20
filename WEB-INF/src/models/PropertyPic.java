package models;

import java.sql.*;
import java.util.ArrayList;
import utils.DBBoard;

public class PropertyPic{
    private Integer propertyPicId;
    private Property property;
    private String propertyPic;

    PropertyPic(){
        super();
    }
    PropertyPic(Integer propertyPicId,String propertyPic){
        super();
        this.propertyPicId = propertyPicId;
        this.propertyPic = propertyPic;
    }
    //-----------------------------------------------------------------------------------
    public static boolean deleteProperty(Integer propertyId){
        boolean flag = false;
        Connection con = null;

        try{
            con = DBBoard.getConnection();
            String query = "";
            PreparedStatement pst = null;
  
                query = " delete from property_pics where property_id=?";
            
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
    


    public static ArrayList<PropertyPic> getAllPropertyPics(Integer propertyId){
		ArrayList<PropertyPic> propertyPics = new ArrayList<PropertyPic>();

		Connection con = null;

		try{
            con = DBBoard.getConnection();
            String query = "select property_pic_id, property_pic from property_pics where property_id=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1,propertyId);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
				propertyPics.add(new PropertyPic(rs.getInt(1),rs.getString(2)));
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

		return propertyPics;
	}




    public static String getSinglePropertyPic(Integer propertyId){
		String picPath = null;

		Connection con = null;

		try{
            con = DBBoard.getConnection();
            String query = "select property_pic from property_pics where property_id=? limit 1";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1,propertyId);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
				picPath = rs.getString(1);
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

		return picPath;
	}



    public static void savePropertyPics(Integer propertyId,ArrayList<String> propertyPics){
        Connection con = null;

        try{
            con = DBBoard.getConnection();
            String query = "insert into property_pics (property_id,property_pic) value (?,?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1,propertyId);

            for(String proPic : propertyPics){
                pst.setString(2,proPic);
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

    //--------------------------------------------------------------------------------
    public Integer getPropertyPicId(){
        return this.propertyPicId;
    }
    public String getPropertyPic(){
        return this.propertyPic;
    }
    public Property getProperty(){
        return this.property;
    }

    public void setPropertyPicId(Integer propertyPicId){
        this.propertyPicId = propertyPicId ;
    }
    public void setPropertyPic(String propertyPic){
        this.propertyPic = propertyPic;
    }
    public void setProperty(Property property){
        this.property = property;
    }
    
}