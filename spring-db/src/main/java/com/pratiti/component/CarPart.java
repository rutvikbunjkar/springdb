package com.pratiti.component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_part")
public class CarPart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int part_no;
	private String part_name;
	private String car_model;
	private double price;
	private int quantity;
	
	
	
	public int getPart_no() {
		return part_no;
	}
	public void setPart_no(int part_no) {
		this.part_no = part_no;
	}
	public String getPart_name() {
		return part_name;
	}
	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}
	public String getCar_model() {
		return car_model;
	}
	public void setCar_model(String carModel) {
		this.car_model = carModel;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
