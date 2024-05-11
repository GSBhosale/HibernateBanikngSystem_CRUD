package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.*;

@Entity
public class Employee {
	@Id
	private int eid;
	private String ename;
	private String designation;
	private double esalary;
	@ManyToOne(cascade = CascadeType.ALL)
	private Address ad;
	@ManyToOne(cascade = CascadeType.ALL)
	private Banks b;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getEsalary() {
		return esalary;
	}
	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}
	public Address getAd() {
		return ad;
	}
	public void setAd(Address ad) {
		this.ad = ad;
	}
	public Banks getB() {
		return b;
	}
	public void setB(Banks b) {
		this.b = b;
	}
	
}
