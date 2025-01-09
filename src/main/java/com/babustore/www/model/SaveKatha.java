package com.babustore.www.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class SaveKatha {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO	)
	private long id;
	@Column
	private long uniqueId;
	@Column
	private String name;
	@Column
	private String date;
	@Column
	private String month;
	@Column
	private String type;
	@Column
	private String amount;
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public SaveKatha(long id, long uniqueId, String name, String date, String month, String type, String amount) {
		super();
		this.id = id;
		this.uniqueId = uniqueId;
		this.name = name;
		this.date = date;
		this.month = month;
		this.type = type;
		this.amount = amount;
	}
	public SaveKatha() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
