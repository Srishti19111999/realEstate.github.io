package models;

import java.sql.*;
import java.util.ArrayList;
import utils.DBBoard;

public class PropertyFor{
    private Integer forId;
    private String forType;

    public PropertyFor(){
        super();
    }
    public PropertyFor(Integer forId){
        super();
        this.forId = forId;
    }
    public PropertyFor(String forType){
        super();
        this.forType = forType;
    }
    public PropertyFor(Integer forId,String forType){
        super();
        this.forId = forId;
        this.forType = forType;
    }
    //------------------------------------------------------------

    public static ArrayList<PropertyFor> collectFor(){
        ArrayList<PropertyFor> propFors = new ArrayList<PropertyFor>();
        Connection con = null;
        
        try{
            con = DBBoard.getConnection();
            String query = "select * from property_for";
            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                propFors.add(new PropertyFor(rs.getInt(1),rs.getString(2)));
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
        return propFors;
    }

    //-------------------------------------------------------------

    public Integer getForId(){
        return this.forId;
    }
    public String getForType(){
        return this.forType;
    }


    public void setForId(Integer forId){
        this.forId = forId ;
    }
    public void setForType(String forType){
        this.forType = forType;
    }

}