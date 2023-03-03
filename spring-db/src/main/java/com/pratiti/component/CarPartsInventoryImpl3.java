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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("carPartsInv3")
public class CarPartsInventoryImpl3 implements CarPartsInventory{		//since this class is communicating with database is called DAO calss
	@Autowired
	private DataSource dataSource;
	
	public void addNewPart(CarPart carpart) {
		//new way of writing the jdbc code for inserting the car part data in database
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql = "insert into car_part( part_name , car_model, price, quantity) values ( ?, ?, ?, ?)";
		jt.update(sql, carpart.getPart_name(), carpart.getCar_model(), carpart.getPrice(), carpart.getQuantity());
		
	}
	public List<CarPart> getAvailableParts(){
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql = "Select* from car_part";
		List<CarPart> list = jt.query(sql, BeanPropertyRowMapper.newInstance(CarPart.class));
		return list;
	}//we can also do autowired for jdbc template

}
