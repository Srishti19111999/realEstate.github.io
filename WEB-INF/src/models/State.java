package models;

public class State{
    private Integer stateId;
    private String state;
    private Country country;
//-----------------------------------------------------------
    
    public State(){
        super();
    }
    public State(Integer stateId,String state, Country country){
        this.stateId = stateId;
        this.state = state;
        this.country = country;
    }
    public State(String state, Country country){
        this.state = state;
        this.country = country;
    }

//-----------------------------------------------------------
    public void setStateId(Integer stateId ){
        this.stateId = stateId;
    }
    public void setCountry(Country country){
        this.country = country;
    }
    public Country getCountry(){
        return this.country;
     }
    public void setState(String state){
        this.state = state;
    }
    public Integer getStateId(){
        return this.stateId;
     }
    public String getState(){
       return this.state;
    }
    
}