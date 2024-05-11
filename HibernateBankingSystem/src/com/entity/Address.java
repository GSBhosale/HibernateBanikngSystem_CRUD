package com.entity;

import javax.persistence.CascadeType;

import java.util.*;

import javax.persistence.*;

@Entity
public class Address {
	@Id
	private int pincode;
	private String street;
	private String city;
	private String state;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<UserAccount> u=new HashSet();
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Employee> e=new HashSet();
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Banks> b=new HashSet();
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Set<UserAccount> getU() {
		return u;
	}
	public void setU(Set<UserAccount> u) {
		this.u = u;
	}
	public Set<Employee> getE() {
		return e;
	}
	public void setE(Set<Employee> e) {
		this.e = e;
	}
	public Set<Banks> getB() {
		return b;
	}
	public void setB(Set<Banks> b) {
		this.b = b;
	}
	
}
