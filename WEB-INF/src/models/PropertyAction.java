package models;

import java.sql.*;
import java.util.ArrayList;

public class PropertyAction{
    private Integer propertyActionId;
    private String action;

    public PropertyAction(){
        super();
    }
    public PropertyAction(Integer propertyActionId){
        super();
        this.propertyActionId = propertyActionId;
    }
    public PropertyAction(String action){
        super();
        this.action = action;
    }
    public PropertyAction(Integer propertyActionId,String action){
        super();
        this.propertyActionId = propertyActionId;

        this.action = action;

    }
    //------------------------------------------------------------

    //-------------------------------------------------------------

    public Integer getPropertyActionId(){
        return this.propertyActionId;
    }
    public String getAction(){
        return this.action;
    }


    public void setPropertyActionId(Integer propertyActionId){
        this.propertyActionId = propertyActionId ;
    }
    public void setAction(String action){
        this.action = action;
    }

}