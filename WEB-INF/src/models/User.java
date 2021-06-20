package models;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.jasypt.util.password.StrongPasswordEncryptor;
import utils.DBBoard;


 public class User{
     private Integer userId;
     private String username;
     private String email;
     private String password;
     private String activationCode;
     private String firstName;
     private String lastName;
     private Date dob;
     private String mobile;
     private String profpic;
     private Status status;

//--------------------------- Constructors-------------------------------------------------
  public User(){
        super();
    }
    public User(Integer userId){
      super();
      this.userId = userId;
  }
  public User(Integer userId,String username,String profpic){
   super();
   this.userId = userId;
   this.username = username;
   this.profpic = profpic;
   }
  public User(Integer userId,String username,String email,String firstName,String lastName,String profpic){
   super();
   this.userId = userId;
   this.username = username;
   this.email = email;
   this.firstName = firstName;
   this.lastName = lastName;
   this.profpic = profpic;
 }
 public User(String username,String email,String password,String activationCode){
      super();
      this.username = username;
      this.email = email;
      this.password = password;
      this.activationCode = activationCode;
    }

//---------------------other methods--------------------------------------------------------

    public void saveProfpic(){

      Connection con = null;
     
      try{
         con = DBBoard.getConnection();
         String query = "update users set profpic=? where user_id=?";
         PreparedStatement pst = con.prepareStatement(query);
         pst.setString(1,profpic);
         pst.setInt(2,userId);
      
        pst.executeUpdate();
      }catch(SQLException e){ 
         e.printStackTrace();
      }
      finally{
         try{con.close();}
         catch(SQLException e){e.printStackTrace();}
      }
   }




   public boolean saveProfile(){
      Connection con = null;
      boolean flag = false;
      try{
         con = DBBoard.getConnection();
         String query = "update users set user_name=?,email=?,first_name=?,last_name=?,dob=?,mobile=? where user_id=?";
         PreparedStatement pst = con.prepareStatement(query);
         pst.setString(1,username);
         pst.setString(2,email);
         pst.setString(3,firstName);
         pst.setString(4,lastName);
         pst.setDate(5,dob);
         pst.setString(6,mobile);
         pst.setInt(7,userId);

         int res = pst.executeUpdate();

         if(res==1){
            flag = true;
         }

      }catch(SQLException e){ 
         e.printStackTrace();
      }
      finally{
         try{con.close();}catch(SQLException e){e.printStackTrace();}
      }
      return flag;
   }


    public String loginUser(String nameemail,String password){
       String message  = null;
       Connection con = null;
      
       try{
         con = DBBoard.getConnection();

         String query = "select user_id,user_name,email,password,first_name,last_name,dob,status_id,profpic from users where user_name=? or email=?";
         PreparedStatement pst = con.prepareStatement(query);
         pst.setString(1,nameemail);
         pst.setString(2,nameemail);

         ResultSet rs = pst.executeQuery();

         if(rs.next()){
            String encPassword = rs.getString(4);
            StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
               if(spe.checkPassword(password,encPassword)){
                  if(rs.getInt(8)==1){
                     userId = rs.getInt(1);
                     username = rs.getString(2);
                     email = rs.getString(3);
                     password = encPassword;
                     firstName = rs.getString(5);
                     lastName = rs.getString(6);
                     dob = rs.getDate(7);
                     status = new Status(rs.getInt(8));
                     profpic = rs.getString(9);
                     message = "success";
                  }else{
                     message = "Either your account is inactive or blocked...";
                  }
               }else{
                  message = "Invalid Password...";
               }
            }else{
               message = "Invalid Username/Email...";
            }
         }catch(SQLException e){
            message = "Some internal problem...";
         e.printStackTrace();
       }finally{
          try{con.close();}catch(SQLException e){ e.printStackTrace();}
       }
       return message;
    }


    public static boolean uniqueKey(String key){
       Connection con = null;
       boolean flag = false;
       try{
         con = DBBoard.getConnection();
         String query = "select user_id from users where user_name=? or email=?";
          PreparedStatement pst = con.prepareStatement(query);
          pst.setString(1,key);
          pst.setString(2,key);
          ResultSet rs = pst.executeQuery();
          if(rs.next()){
             flag = true;
          }  
       }catch(SQLException e){
          e.printStackTrace();
       }finally{
          try{con.close();}catch(SQLException e){e.printStackTrace();}
       }
       return flag;
    }


    public static boolean activateAccount(String username,String activationCode){
       Connection con = null;
       boolean flag = false;
       
       try{
         con = DBBoard.getConnection();
         String query = "update users set status_id=1,activation_code='' where user_name=? and activation_code=?";
            
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1,username);
            pst.setString(2,activationCode);

            int res = pst.executeUpdate();
            if(res==1)
               flag = true;
         }catch(SQLException e){
            e.printStackTrace();
         }finally{
            try{con.close();}catch(SQLException e){e.printStackTrace();}
         }
         return flag;
    }


    public boolean saveUser(){
        Connection con = null;
        boolean flag = false;
        try{
         con = DBBoard.getConnection();
         String query = "insert into users(user_name,email,password,activation_code)value(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,username);
            pst.setString(2,email);
            StrongPasswordEncryptor enc = new StrongPasswordEncryptor();
            pst.setString(3,enc.encryptPassword(password));
            pst.setString(4,activationCode);
            
            pst.executeUpdate();
            flag = true;
        }catch(SQLException e){ 
            e.printStackTrace();
        }
        finally{
            try{con.close();}catch(SQLException e){e.printStackTrace();}
        }
        return flag;
       }

//---------------------------Getter Setter --------------------------------------------------
     public Integer getUserId(){
        return this.userId;
     }
     public String getUsername(){
        return this.username; 
     }
     public String getEmail(){
        return this.email;
     }
     public String getPassword(){
        return this.password; 
     }
     public String getFirstName(){
        return this.firstName;
     }
     public String getlastName(){
        return this.lastName; 
     }
     public Date getDOB(){
       return this.dob;  
     }
     public String getMobile(){
      return this.mobile; 
     }
     public String getProfpic(){
        System.out.println(this.profpic);
		return profpic;
	  }
     public Status getStatusId(){
         return this.status;
     }


     public void setUserId(Integer userId){
        this.userId = userId;
     }
     public void setUsername(String username){
        this.username = username; 
     }
     public void setEmail(String email){
        this.email = email;
     }
     public void setPassword(String password){
        this.password = password; 
     }
     public void setFirstName(String firstName){
        this.firstName = firstName;
     }
     public void setLastName(String lastName){
        this.lastName = lastName; 
     }
     public void setDOB(Date dob){
        this.dob = dob ;  
     }
     public void setMobile(String mobile){
       this.mobile = mobile; 
     }
     public void setProfpic(String profpic){
      System.out.println(profpic);
		this.profpic = profpic;
	  }

     public void setStatusId(Status status){
        this.status = status;
     }

     
 }