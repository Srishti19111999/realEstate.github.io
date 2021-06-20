package models;

import java.sql.*;
import java.util.ArrayList;
import utils.DBBoard;


public class City{
	private Integer cityId;
	private String city;
	private State state;

	//############### Constructor ###############
	public City(String city){
		this.city = city;
	}
	public City(Integer cityId,String city,State state){
		this.cityId = cityId;
		this.city = city;
		this.state = state;
	}
	public City(String city,State state){
		this.city = city;
		this.state = state;
	}


	//############### Methods ###################
	public static ArrayList<City> searchCity(String skey){
		ArrayList<City> cities = new ArrayList<City>();
		Connection con = null;

		try{
			con = DBBoard.getConnection();
			String query = "select city_id,city,states.state_id,state,countries.country_id,country_name from cities inner join states on cities.state_id = states.state_id inner join countries on states.country_id = countries.country_id where city like '"+skey+"%'";

			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				cities.add(new City(rs.getInt(1),rs.getString(2),new State(rs.getInt(3),rs.getString(4),new Country(rs.getInt(5),rs.getString(6)))));
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

		return cities;
	}


	public void setState(State state){
		this.state = state;
	}

	public State getState(){
		return state;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;	
	}

	public void setCityId(Integer cityId){
		this.cityId = cityId;
	}

	public Integer getCityId(){
		return cityId;
	}
}