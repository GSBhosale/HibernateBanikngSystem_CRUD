package com.entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.*;
@Entity
public class UserAccount {
	@Id
	private int uid;
	private String uname;
	private String accType;
	private double balance;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Banks> sb=new HashSet();
	@ManyToOne(cascade = CascadeType.ALL)
	private Address ad;
	@Transient
	private double debit;
	@Transient
	private double credit;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Set<Banks> getSb() {
		return sb;
	}
	public void setSb(Set<Banks> sb) {
		this.sb = sb;
	}
	public Address getAd() {
		return ad;
	}
	public void setAd(Address ad) {
		this.ad = ad;
	}
	public double getDebit() {
		return debit;
	}
	public void setDebit(double debit) {
		this.debit = debit;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	
}
