package com.pratiti.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carPartsInv2")
public class CarPartsInventoryImpl2 implements CarPartsInventory{		//since this class is communicating with database is called DAO calss
	@Autowired
	private DataSource dataSource;
	
	public void addNewPart(CarPart carpart) {
		
		//write the jdbc code for inserting the car part data in database
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = dataSource.getConnection();
			String sql = "insert into car_part( part_name , car_model, price, quantity) values ( ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, carpart.getPart_name());
			stmt.setDouble(3, carpart.getPrice());
			stmt.setString(2, carpart.getCar_model());
			stmt.setInt(4, carpart.getQuantity());
			stmt.executeUpdate();
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {conn.close();} catch(Exception e) {}
		}
	}
	public List<CarPart> getAvailableParts(){
		List<CarPart> lm  = new ArrayList<CarPart>();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "Select * from car_part ";
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				
				CarPart c = new CarPart();
				
				c.setPart_no( res.getInt(1));
				c.setPart_name( res.getString(2));
				c.setCar_model(res.getString(3));
				c.setPrice(res.getDouble(4));
				c.setQuantity( res.getInt(5));
				
				lm.add(c);
				
			}
			
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {conn.close();} catch(Exception e) {}
		}
		return lm;
	}

}
