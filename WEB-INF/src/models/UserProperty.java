package models;

import java.sql.*;
import java.util.ArrayList;

import utils.WishCount;
import utils.BidCount;
import utils.DBBoard;

public class UserProperty{
    private Integer userPropertyId;
    private Property property;
    private User user;
    private PropertyAction propertyAction;
    private Integer count;
    private Integer bidAmount;


    public UserProperty(){
        super();
    }
    public UserProperty(Integer userPropertyId){
        super();
        this.userPropertyId = userPropertyId;
    }
    public UserProperty( Property property, User user){
        super();
        this.property = property;
        this.user = user;

    }

    public UserProperty(Integer userPropertyId,Integer bidAmount,User user){
        super();
        this.userPropertyId = userPropertyId;
        this.user = user;
        this.bidAmount = bidAmount;

    }

    public UserProperty(Property property, User user, PropertyAction propertyAction,Integer count){
        super();
        this.property = property;
        this.user = user;
        this.propertyAction = propertyAction;
        this.count = count;
    }

    public UserProperty(Property property, User user, PropertyAction propertyAction,Integer count,Integer bidAmount){
        super();
        this.property = property;
        this.user = user;
        this.propertyAction = propertyAction;
        this.count = count;
        this.bidAmount = bidAmount;
    }
    public UserProperty(Integer userPropertyId,User user,Property property){
        super();
        this.property = property;
        this.user = user;
        this.userPropertyId = userPropertyId;

    }
    public UserProperty(Integer userPropertyId,User user,Property property,Integer bidAmount){
        super();
        this.property = property;
        this.user = user;
        this.userPropertyId = userPropertyId;
        this.bidAmount = bidAmount;
    }
    //------------------------------------------------------------



    public static boolean deleteProperty(Integer propertyId,Integer userId){
        boolean flag = false;
        Connection con = null;

        try{
            con = DBBoard.getConnection();
            String query = "";
            PreparedStatement pst = null;
  
                query = " delete from user_property where property_id=?";
            
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



        
    public static boolean deleteFromBids(Integer propertyId,Integer userId){
        boolean flag = false;
        Connection con = null;

        try{
            con = DBBoard.getConnection();
            String query = "";
            PreparedStatement pst = null;
  
                query = " delete from user_property where user_id=? and prop_action_id=3 and property_id=?";
            
                pst = con.prepareStatement(query);
                
                pst.setInt(1,userId);
                pst.setInt(2,propertyId);


            int res = pst.executeUpdate();
            
            if(res==1){

                Integer bid = BidCount.getBidCount(propertyId);
                BidCount.decreaseBidCount(propertyId,bid);
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



    public static ArrayList<UserProperty> getAllBidders(int propertyId){
        Connection con = null;
        ArrayList<UserProperty> list = new ArrayList<UserProperty>(); 
        try{
            con = DBBoard.getConnection();
            String query = "  select user_property_id,user_property.bid_amount,user_property.user_id,users.user_name,users.email,users.first_name,users.last_name,users.profpic from user_property inner join users on user_property.user_id=users.user_id where user_property.property_id=? and prop_action_id = 3";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1,propertyId);
           
            ResultSet rs = pst.executeQuery();

			while(rs.next()){
				list.add(new UserProperty(rs.getInt(1),rs.getInt(2),new User(rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8))));
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
        return list;
    }


    
    public static boolean deleteFromWish(Integer propertyId,Integer userId){
        boolean flag = false;
        Connection con = null;

        try{
            con = DBBoard.getConnection();
            String query = "";
            PreparedStatement pst = null;
  
                query = " delete from user_property where user_id=? and prop_action_id=2 and property_id=?";
            
                pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS );
                
                pst.setInt(1,userId);
                pst.setInt(2,propertyId);


            int res = pst.executeUpdate();
            
            if(res==1){

                Integer wish = WishCount.getWishCount(propertyId);
                WishCount.decreaseWishCount(propertyId,wish);
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


    public void deleteFromWishList(){
        boolean flag = false;
        Connection con = null;

        try{
            con = DBBoard.getConnection();
            String query = "";
            PreparedStatement pst = null;
  
                query = " delete from user_property where user_id=? and prop_action_id=2 and property_id=?";
            
                pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS );
                
                pst.setInt(1,user.getUserId());
                pst.setInt(2,property.getPropertyId());


            int res = pst.executeUpdate();
            
            if(res==1){

                Integer wish = WishCount.getWishCount(property.getPropertyId());
                WishCount.decreaseWishCount(property.getPropertyId(),wish);
                flag = true;
				ResultSet rs = pst.getGeneratedKeys();
				if(rs.next()){
                    userPropertyId = rs.getInt(1);
                    System.out.println(userPropertyId);
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
    }



    
    public static ArrayList<UserProperty> getBids(int userId){
        Connection con = null;
        ArrayList<UserProperty> bids = new ArrayList<UserProperty>(); 
        try{
            con = DBBoard.getConnection();
            String query = "  select user_property_id,user_property.user_id,user_property.property_id,property_name,property_area,property_price,per_price,cities.city,property_type.property_type,property_for.for_type,properties.user_id,users.user_name,users.profpic,bid_amount from properties inner join user_property on properties.property_id=user_property.property_id inner join cities on properties.city_id = cities.city_id inner join property_type on properties.property_type_id=property_type.property_type_id inner join property_for on properties.for_id=property_for.for_id inner join users on users.user_id=properties.user_id where user_property.user_id=? and prop_action_id = 3";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1,userId);
           
            ResultSet rs = pst.executeQuery();

			while(rs.next()){
				bids.add(new UserProperty(rs.getInt(1),new User(rs.getInt(2)),new Property(rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),new City(rs.getString(8)),new PropertyType(rs.getString(9)),new PropertyFor(rs.getString(10)),new User(rs.getInt(11),rs.getString(12),rs.getString(13))),rs.getInt(14)));
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
        return bids;
    }



    
    public boolean addToBids(){
        boolean flag = false;
        Connection con = null;

        try{
            con = DBBoard.getConnection();
            String query = "";
            PreparedStatement pst = null;
  
                query = "insert into user_property(property_id,user_id,prop_action_id,bid_count,bid_amount) value (?,?,?,?,?)";
            
                pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS );
                pst.setInt(1,property.getPropertyId());
                pst.setInt(2,user.getUserId());
                pst.setInt(3,propertyAction.getPropertyActionId());
                   count++;
                pst.setInt(4,count);
                pst.setInt(5,bidAmount);



            int res = pst.executeUpdate();
            if(res==1){
                flag = true;
				ResultSet rs = pst.getGeneratedKeys();
				if(rs.next()){
                    userPropertyId = rs.getInt(1);
                    System.out.println(userPropertyId);
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


    public static ArrayList<UserProperty> getWishlist(int userId){
        Connection con = null;
        ArrayList<UserProperty> wishlists = new ArrayList<UserProperty>(); 
        try{
            con = DBBoard.getConnection();
            String query = "  select user_property_id,user_property.user_id,user_property.property_id,property_name,property_area,property_price,per_price,cities.city,property_type.property_type,property_for.for_type from properties inner join user_property on properties.property_id=user_property.property_id inner join cities on properties.city_id = cities.city_id inner join property_type on properties.property_type_id=property_type.property_type_id inner join property_for on properties.for_id=property_for.for_id where user_property.user_id=? and prop_action_id = 2";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1,userId);
           
            ResultSet rs = pst.executeQuery();

			while(rs.next()){
				wishlists.add(new UserProperty(rs.getInt(1),new User(rs.getInt(2)),new Property(rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),new City(rs.getString(8)),new PropertyType(rs.getString(9)),new PropertyFor(rs.getString(10)))));
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
        return wishlists;
    }




    public boolean addToWishlist(){
        boolean flag = false;
        Connection con = null;

        try{
            con = DBBoard.getConnection();
            String query = "";
            PreparedStatement pst = null;
           
                query = "insert into user_property(property_id,user_id,prop_action_id,wish_count) value (?,?,?,?)";
            
                pst = con.prepareStatement(query);
                pst.setInt(1,property.getPropertyId());
                pst.setInt(2,user.getUserId());
                pst.setInt(3,propertyAction.getPropertyActionId());
                   count++;
                pst.setInt(4,count);
            
            


            int res = pst.executeUpdate();
            if(res==1){
                flag = true;
				ResultSet rs = pst.getGeneratedKeys();
				if(rs.next()){
                    userPropertyId = rs.getInt(1);
                    System.out.println(userPropertyId);
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




    //----------------------------------------------------------------
    public Integer getUserPropertyId(){
        return this.userPropertyId;
    }
    public Property getProperty(){
        return this.property;
    }
    public User getUser(){
        return this.user;
    }
    public PropertyAction getPropertyAction(){
        return this.propertyAction;
    }
    public Integer getCount(){
        return this.count;
    }
    public Integer getBidAmount(){
        return this.bidAmount;
    }


    public void setUserPropertyId(Integer userPropertyId){
        this.userPropertyId = userPropertyId ;
    }
    public void setProperty(Property property){
         this.property = property;
    }
    public void setUser(User user){
         this.user = user;
    }
    public void setPropertyAction(PropertyAction propertyAction){
        this.propertyAction = propertyAction;
    }
    public void setCount(Integer count){
        this.count = count;
   }
   public void setBidAmount(Integer bidAmount){
    this.bidAmount = bidAmount;
}




}