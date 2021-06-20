package models;

import java.sql.*;
import java.util.ArrayList;
import utils.DBBoard;


public class Property{
    private Integer propertyId;
    private String propertyName;
    private String propertyDescription;
    private Integer propertyPrice;
    private Integer perPrice;
    private String address;
    private String propertyArea;
    private City city;
    private User user;
    private PropertyStatus propertyStatus;
    private PropertyType propertyType;
    private PropertyFor propertyFor;
    private Float latitude;
    private Float longitude;


    public Property(){
        super();
    }
    public Property(Integer propertyId){
        super();
        this.propertyId = propertyId;
    }

    public Property(Integer propertyId,User user,String propertyName,String propertyArea,Integer propertyPrice,Integer perPrice,Float latitude,Float longitude,City city,PropertyType propertyType,PropertyFor propertyFor){
        this.propertyId = propertyId;
        this.user = user;
        this.propertyName = propertyName;
        this.propertyPrice = propertyPrice;
        this.propertyArea = propertyArea;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.propertyFor = propertyFor;
        this.perPrice = perPrice;
        this.propertyType = propertyType;
    }
    
    public Property(Integer propertyId,String propertyName,String propertyArea,Integer propertyPrice,Integer perPrice,City city,PropertyType propertyType,PropertyFor propertyFor,User user){
        this.propertyId = propertyId;
        this.user = user;
        this.propertyName = propertyName;
        this.propertyPrice = propertyPrice;
        this.propertyArea = propertyArea;
        this.city = city;
        this.propertyFor = propertyFor;
        this.perPrice = perPrice;
        this.propertyType = propertyType;
    }

    public Property(Integer propertyId,User user,String propertyName,String propertyArea,Integer propertyPrice,Integer perPrice,City city,PropertyType propertyType,PropertyFor propertyFor){
        this.propertyId = propertyId;
        this.user = user;
        this.propertyName = propertyName;
        this.propertyPrice = propertyPrice;
        this.propertyArea = propertyArea;
        this.city = city;
        this.propertyFor = propertyFor;
        this.perPrice = perPrice;
        this.propertyType = propertyType;
    }

    public Property(Integer propertyId,String propertyName,String propertyArea,Integer propertyPrice,Integer perPrice,City city,PropertyType propertyType,PropertyFor propertyFor){
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.propertyPrice = propertyPrice;
        this.propertyArea = propertyArea;
        this.city = city;
        this.propertyFor = propertyFor;
        this.perPrice = perPrice;
        this.propertyType = propertyType;
    }

    public Property(User user,PropertyFor propertyFor, PropertyStatus propertyStatus, PropertyType propertyType, String propertyName,Integer perPrice, Integer propertyPrice, String propertyArea){
        super();
        this.user = user;
        this.propertyFor = propertyFor;
        this.propertyStatus = propertyStatus;
        this.propertyType = propertyType;
        this.propertyName = propertyName;
        this.perPrice = perPrice;
        this.propertyPrice = propertyPrice;
        this.propertyArea = propertyArea;
    }
    //----------------------------------------------------------------------------------------------------------


    public static boolean deleteProperty(Integer propertyId,Integer userId){
        boolean flag = false;
        Connection con = null;

        try{
            con = DBBoard.getConnection();
            String query = "";
            PreparedStatement pst = null;
  
                query = " delete from properties where property_id=? and user_id=?";
            
                pst = con.prepareStatement(query);
                pst.setInt(1,propertyId);
                pst.setInt(2,userId);


            int res = pst.executeUpdate();
            if(res==1){
                flag = true;
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
        return flag;
    }


    
    public static ArrayList<Property> getNearByProperty(Integer user_Id){
		ArrayList<Property> properties = new ArrayList<Property>();
		Connection con = null;

        try{
            con = DBBoard.getConnection();
            System.out.println(user_Id);
            String query = "select property_id,user_id,property_name,property_area,property_price,per_price,lat,lng,cities.city,property_type.property_type,property_for.for_type from properties inner join cities on properties.city_id = cities.city_id inner join property_type on properties.property_type_id=property_type.property_type_id inner join property_for on properties.for_id=property_for.for_id where not user_id=?";
            
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,user_Id);
            
            ResultSet rs = pst.executeQuery();

			while(rs.next()){
				properties.add(new Property(rs.getInt(1),new User(rs.getInt(2)),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getFloat(7),rs.getFloat(8),new City(rs.getString(9)),new PropertyType(rs.getString(10)),new PropertyFor(rs.getString(11))));
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
        return properties;
    }


    public static ArrayList<Property> searchProperty(String city,Integer price,Integer type){
		ArrayList<Property> properties = new ArrayList<Property>();
		Connection con = null;

        try{
            con = DBBoard.getConnection();
            System.out.println("SEarch");
            String query ="select property_id,user_id,property_name,property_area,property_price,per_price,cities.city,property_type.property_type,property_for.for_type from properties inner join cities on properties.city_id = cities.city_id inner join property_type on properties.property_type_id=property_type.property_type_id inner join property_for on properties.for_id=property_for.for_id where (city like '%"+city+"%' and property_type.property_type_id="+type+") and property_price <="+price+"";                  
           
            PreparedStatement pst = con.prepareStatement(query);
            
            ResultSet rs = pst.executeQuery();

			while(rs.next()){
				properties.add(new Property(rs.getInt(1),new User(rs.getInt(2)),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),new City(rs.getString(7)),new PropertyType(rs.getString(8)),new PropertyFor(rs.getString(9))));
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
        return properties;
    }


    public static ArrayList<Property> searchProperty(String byKey,String searchKey,Integer user_Id){
		ArrayList<Property> properties = new ArrayList<Property>();
		Connection con = null;

        try{
            con = DBBoard.getConnection();
            System.out.println(user_Id);
            String query = "";
            
            if(byKey.equals("Location")){
                query ="select property_id,user_id,property_name,property_area,property_price,per_price,cities.city,property_type.property_type,property_for.for_type from properties inner join cities on properties.city_id = cities.city_id inner join property_type on properties.property_type_id=property_type.property_type_id inner join property_for on properties.for_id=property_for.for_id where cities.city like '%"+searchKey+"%' and not user_id=?";              
            }else if(byKey.equals("Property Type")){
                query ="select property_id,user_id,property_name,property_area,property_price,per_price,cities.city,property_type.property_type,property_for.for_type from properties inner join cities on properties.city_id = cities.city_id inner join property_type on properties.property_type_id=property_type.property_type_id inner join property_for on properties.for_id=property_for.for_id where property_type.property_type like '%"+searchKey+"%'and not user_id=?";                         
            }else if(byKey.equals("Price")){
                int searchedPrice = Integer.parseInt(searchKey);
                query ="select property_id,user_id,property_name,property_area,property_price,per_price,cities.city,property_type.property_type,property_for.for_type from properties inner join cities on properties.city_id = cities.city_id inner join property_type on properties.property_type_id=property_type.property_type_id inner join property_for on properties.for_id=property_for.for_id where property_price <="+searchedPrice+" and not user_id=?";              
            }else{
                query ="select property_id,user_id,property_name,property_area,property_price,per_price,cities.city,property_type.property_type,property_for.for_type from properties inner join cities on properties.city_id = cities.city_id inner join property_type on properties.property_type_id=property_type.property_type_id inner join property_for on properties.for_id=property_for.for_id where (city like '%"+searchKey+"%' or property_type like '%"+searchKey+"%') and not user_id=?";                  
            }
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,user_Id);
            
            ResultSet rs = pst.executeQuery();

			while(rs.next()){
				properties.add(new Property(rs.getInt(1),new User(rs.getInt(2)),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),new City(rs.getString(7)),new PropertyType(rs.getString(8)),new PropertyFor(rs.getString(9))));
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
        return properties;
    }



    
    public void getPropertyInfo(){
        Connection con = null;
      
        try{
            con = DBBoard.getConnection();
            String query = " select property_name,property_area,property_price,per_price,property_description,cities.city,states.state,countries.country_name,property_type.property_type,property_for.for_type,address from properties inner join cities on properties.city_id = cities.city_id inner join property_type on properties.property_type_id=property_type.property_type_id inner join property_for on properties.for_id=property_for.for_id inner join states on cities.state_id = states.state_id inner join countries on states.country_id = countries.country_id where properties.property_id=?;";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1,propertyId);
           
            ResultSet rs = pst.executeQuery();
 //System.out.println("1 propertyId");
			if(rs.next()){
                propertyName = rs.getString(1);
                propertyArea =  rs.getString(2);
                propertyPrice = rs.getInt(3);
                perPrice = rs.getInt(4);
                propertyDescription = rs.getString(5);
                city = new City(rs.getString(6),new State(rs.getString(7),new Country(rs.getString(8))));
                propertyType = new PropertyType(rs.getString(9));
                propertyFor = new PropertyFor(rs.getString(10));
                address = rs.getString(11);
			}	
            System.out.println("2 propertyId");
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




    public static ArrayList<Property> collectAllProperty(int userId){
        Connection con = null;
        ArrayList<Property> properties = new ArrayList<Property>(); 
        try{
            con = DBBoard.getConnection();
            String query = " select property_id,property_name,property_area,property_price,per_price,cities.city,property_type.property_type,property_for.for_type from properties inner join cities on properties.city_id = cities.city_id inner join property_type on properties.property_type_id=property_type.property_type_id inner join property_for on properties.for_id=property_for.for_id where user_id=? order by property_id desc";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1,userId);
           
            ResultSet rs = pst.executeQuery();
System.out.println("we widd");
			while(rs.next()){
				properties.add(new Property(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),new City(rs.getString(6)),new PropertyType(rs.getString(7)),new PropertyFor(rs.getString(8))));
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
        return properties;
    }


    public boolean saveotherDetails(){
        boolean flag = false;
        Connection con = null;

        try{
            con = DBBoard.getConnection();
            String query = "update properties set address=?,city_id=?,property_description=?,lat=?,lng=? where property_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            System.out.println(propertyName);
            pst.setString(1,address);
            pst.setInt(2,city.getCityId());
            pst.setString(3,propertyDescription);
            pst.setFloat(4,latitude);
            pst.setFloat(5,longitude);
            
            pst.setInt(6,propertyId);
           
            int res = pst.executeUpdate();
            if(res==1){
                flag = true;
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
        return flag;
    }



    public boolean saveProperty(){
        boolean flag = false;
        Connection con = null;

        try{
            con = DBBoard.getConnection();
            String query = "insert into properties(property_name,property_price,property_area,property_status_id,user_id,property_type_id,per_price,for_id) value(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            System.out.println(propertyName);
            pst.setString(1,propertyName);
            pst.setInt(2,propertyPrice);
            pst.setString(3,propertyArea);
            pst.setInt(4,propertyStatus.getPropertyStatusId());
            pst.setInt(5,user.getUserId());
            pst.setInt(6,propertyType.getPropertyTypeId());
            pst.setInt(7,perPrice);
            pst.setInt(8,propertyFor.getForId());

            int res = pst.executeUpdate();
            if(res==1){
                flag = true;
				ResultSet rs = pst.getGeneratedKeys();
				if(rs.next()){
                    propertyId = rs.getInt(1);
                    
				}
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

        return flag;
    }

    //----------------------------------------------------------------------------------------------------------

    public Integer getPropertyId(){
       return this.propertyId;
    }
    public String getPropertyName(){
        return this.propertyName;
    }
    public String getPropertyDescription(){
        return this.propertyDescription;
    }
    public Integer getpropertyPrice(){
         return this.propertyPrice;
    }
    public String getAddress(){
        return this.address;
    }
    public Integer getPerPrice(){
         return this.perPrice;
    }
    public String getPropertyArea(){
        return this.propertyArea;
    }
    public City getCity(){
        return this.city;
    }
    public User getUser(){
        return this.user;
    }
    public PropertyStatus getPropertyStatus(){
        return this.propertyStatus;
    }
    public PropertyType getPropertyType(){
        return this.propertyType;
    }
    public PropertyFor getPropertyFor(){
        return this.propertyFor;
    }
    public Float getLatitude(){
        return this.latitude;
    }
    public Float getLongitude(){
        return this.longitude;
    }


    public void  setPropertyId(Integer propertyId){
         this.propertyId = propertyId;
     }

     public void setPropertyName(String propertyName){
          this.propertyName = propertyName;
     }
     public void setPropertyDescription(String propertyDescription){
          this.propertyDescription = propertyDescription;
     }
     public void setpropertyPrice(Integer propertyPrice){
           this.propertyPrice = propertyPrice;
     }
     public void setAddress(String address){
          this.address = address;
     }
     public void setPerPrice( Integer perPrice){
           this.perPrice = perPrice;
     }
     public void setCity(City city){
          this.city = city;
     }
     public void setUser(User user){
          this.user = user;
     }
     public void setPropertyStatus(PropertyStatus propertyStatus){
         this.propertyStatus= propertyStatus;
     }
     public void setPropertyType(PropertyType propertyType){
         this.propertyType = propertyType;
     }
     public void setLatitude(Float latitude){
        this.latitude = latitude;
     }
    public void setLongitude(Float longitude){
        this.longitude = longitude;
     }

}