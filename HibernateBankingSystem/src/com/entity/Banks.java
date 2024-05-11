package com.entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.*;
@Entity
public class Banks {
	@Id
	private int bid;
	private String bname;
	private String branchname;
	private double assets;
	private double NPA;
	private double PA;
	@ManyToOne(cascade = CascadeType.ALL)
	private Address ad;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Employee> se=new HashSet();
	@ManyToMany(cascade = CascadeType.ALL)
	private  Set<UserAccount> su=new HashSet();
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public double getAssets() {
		return assets;
	}
	public void setAssets(double assets) {
		this.assets = assets;
	}
	public double getNPA() {
		return NPA;
	}
	public void setNPA(double nPA) {
		NPA = nPA;
	}
	public double getPA() {
		return PA;
	}
	public void setPA(double pA) {
		PA = pA;
	}
	
	public Address getAd() {
		return ad;
	}
	public void setAd(Address ad) {
		this.ad = ad;
	}
	public String getBranchname() {
		return branchname;
	}
	public Set<Employee> getSe() {
		return se;
	}
	public void setSe(Set<Employee> se) {
		this.se = se;
	}
	public Set<UserAccount> getSu() {
		return su;
	}
	public void setSu(Set<UserAccount> su) {
		this.su = su;
	}
	
	
}
