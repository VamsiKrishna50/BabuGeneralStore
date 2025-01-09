package com.babustore.www.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class SaveDailyDairy {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private int uniqueId;
	private int amount;
	private String month;
	private String date;
	private String type;
	private String endPoint;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public SaveDailyDairy(int id, int uniqueId, int amount, String month, String date, String type, String endPoint) {
		super();
		this.id = id;
		this.uniqueId = uniqueId;
		this.amount = amount;
		this.month = month;
		this.date = date;
		this.type = type;
		this.endPoint = endPoint;
	}
	public SaveDailyDairy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
