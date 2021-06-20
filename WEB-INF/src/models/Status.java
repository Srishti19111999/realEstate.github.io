package models;

public class Status{
    private Integer statusId;
    private String statusType;
//-----------------------------------------------------------
    
    Status(){
        super();
    }
    Status(Integer statusId){
        this.statusId = statusId;
    }
    Status(String statusType){
        this.statusType = statusType;
    }

//-----------------------------------------------------------
    public void setstatusId(Integer statusId ){
        this.statusId = statusId;
    }
    public void setstatusType(String statusType ){
        this.statusType = statusType;
    }
    public Integer getstatusId(){
        return this.statusId;
     }
    public String getstatusType(){
       return this.statusType;
    }
    
}