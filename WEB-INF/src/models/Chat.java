package models;

import java.sql.*;
import java.util.ArrayList;
import utils.DBBoard;

public class Chat{
    private Integer chatId;
    private Integer senderId;
    private String sender;
    private Integer recieverId;
    private String reciever;
    private String message;
//-----------------------------------------------------------
    
    public Chat(){
        super();
    }
    public Chat(Integer senderId,String sender, Integer recieverId, String reciever, String message){
        this.senderId = senderId;
        this.sender = sender;
        this.recieverId = recieverId;
        this.reciever = reciever;
        this.message = message;
    }
    public Chat(String sender, String reciever, String message){
        this.sender = sender;
        this.reciever = reciever;
        this.message = message;
    }
    
//-----------------------------------------------------------

public static ArrayList<Chat> getChats(Integer senderId,Integer recieverId){
    Connection con = null;
    ArrayList<Chat> list = new ArrayList<Chat>(); 
    try{
       
        con = DBBoard.getConnection();
        String query = "select sender_name,reciever_name,message from chats where (sender_id=? and reciever_id=?)or(sender_id=? and reciever_id=?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1,senderId);
        pst.setInt(2,recieverId);
        pst.setInt(3,recieverId);
        pst.setInt(4,senderId);
       
        ResultSet rs = pst.executeQuery();

        while(rs.next()){
            list.add(new Chat(rs.getString(1),rs.getString(2),rs.getString(3)));
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



public boolean addToChats(){
    boolean flag = false;
    Connection con = null;

    try{
        con = DBBoard.getConnection();
        String query = "insert into chats(sender_id,sender_name,reciever_id,reciever_name,message) value(?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        
        pst.setInt(1,senderId);
        pst.setString(2,sender);
        pst.setInt(3,recieverId);
        pst.setString(4,reciever);
        pst.setString(5,message);

        int res = pst.executeUpdate();
        if(res==1){
            flag = true;
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next()){
                chatId = rs.getInt(1);
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


//-----------------------------------------------------------
    public void setSenderId(Integer senderId ){
        this.senderId = senderId;
    }
    public void setSender(String sender){
        this.sender = sender;
    }
    public void setRecieverId(Integer recieverId ){
        this.recieverId = recieverId;
    }
    public void setReciever(String reciever){
        this.reciever = reciever;
    }
    public void setMessage(String message){
        this.message = message;
    }


    public Integer getSenderId(){
        return this.senderId;
     }
    public String getSender(){
       return this.sender;
    }
    public Integer getRecieverId(){
        return this.senderId;
     }
    public String getReciever(){
       return this.sender;
    }
    public String getMessage(){
        return this.message;
     }
    
}