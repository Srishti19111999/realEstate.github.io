package models;

public class Country{
    private Integer countryId;
    private String country;
//-----------------------------------------------------------
    
    public Country(){
        super();
    }
    public Country(Integer countryId,String country){
        this.countryId = countryId;
        this.country = country;
    }
    public Country(String country){
        this.country = country;
    }

//-----------------------------------------------------------
    public void setCountryId(Integer CountryId ){
        this.countryId = countryId;
    }
    public void setCountry(String Country){
        this.country = country;
    }
    public Integer getCountryId(){
        return this.countryId;
     }
    public String getCountry(){
       return this.country;
    }
    
}