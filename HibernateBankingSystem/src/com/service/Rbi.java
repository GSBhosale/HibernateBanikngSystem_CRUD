package com.service;

import java.util.*;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.entity.*;

public class Rbi {

	Scanner sc=new Scanner(System.in);
	Address a=new Address();
	UserAccount ua=new UserAccount();
	Employee e=new Employee();
	Banks b=new Banks();

	int n;
	int x;
	
	
	public void save()
	{ int x=1;
		while(x==1)
		{
			System.out.println("1:save_Address");
			System.out.println("2:create_Account");
			System.out.println("3:save_employee");
			System.out.println("4:save_bank");
			System.out.println("enter your choice");
			int ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				save_Address();
				break;
			case 2:
				save_userAccount();
				break;
			case 3:
				save_Employee();
				break;
			case 4:
				save_banks();
				break;
			case 5:
				System.out.println("thank you!!");
				System.out.println("-----------------------------");
				x=2;
			}
		}
	}
	public void save_Address()
	{
		Session ssn=HibernateUtil.getSesssionFactory().openSession();
	n=1;
			System.out.println("save address!!");
			System.out.println("---------------------------");
			
			while(n==1) {
				//Address a=new Address();
				System.out.println("enter pincode.");
				a.setPincode(sc.nextInt());
				System.out.println("enter Street.");
				a.setStreet(sc.next());
				System.out.println("enter city.");
				a.setCity(sc.next());
				System.out.println("enter state.");
				a.setState(sc.next());
				ssn.save(a);
				ssn.beginTransaction().commit();
				System.out.println("address successfully saved!!");
				System.out.println("---------------------------");
				System.out.println("1:add one more address OR 2: add employee at this address."+"\n"+" 3: add user at this address OR 4: add bank at this address OR 100: main menu");
				 n=sc.nextInt();
				System.out.println("---------------------------");
			}
			while(n==2)
			{
				System.out.println("add employee!!");
				System.out.println("---------------------------");	
				System.out.println("enter employee id.");
				int eid=sc.nextInt();
				Employee e1=ssn.get(Employee.class, eid);
				a.getE().add(e1);
				e1.setAd(a);
				ssn.save(e1);
				ssn.save(a);
				ssn.beginTransaction().commit();
				System.out.println("---------------------------");
				System.out.println("1:add one more address OR 2: add employee at this address "+"\n"+" 3: add user at this address OR 4: add bank at this address OR 100: main menu");
				 n=sc.nextInt();
				System.out.println("---------------------------");
			}
			while(n==3)
			{
				System.out.println("add user!!");
				System.out.println("---------------------------");	
				System.out.println("enter user id.");
				int eid=sc.nextInt();
				UserAccount u1=ssn.get(UserAccount.class, eid);
				a.getU().add(u1);
				u1.setAd(a);
				ssn.save(u1);
				ssn.save(a);
				ssn.beginTransaction().commit();
				System.out.println("---------------------------");
				System.out.println("1:add one more address OR 2: add employee at this address "+"\n"+" 3: add user at this address OR 4: add bank at this address OR 100: main menu");
				 n=sc.nextInt();
				System.out.println("---------------------------");
			}
			while(n==4)
			{
				System.out.println("add bank!!");
				System.out.println("---------------------------");	
				System.out.println("enter bank id.");
				int eid=sc.nextInt();
				Banks u1=ssn.get(Banks.class, eid);
				a.getB().add(u1);
				u1.setAd(a);
				ssn.save(u1);
				ssn.save(a);
				ssn.beginTransaction().commit();
				System.out.println("---------------------------");
				System.out.println("1:add one more address OR 2: add employee at this address "+"\n"+" 3: add user at this address OR 4: add bank at this address OR 100: main menu");
				 n=sc.nextInt();
				System.out.println("---------------------------");
			}
	}
	
	public void save_userAccount()
	{
		Session ssn=HibernateUtil.getSesssionFactory().openSession();
		n=1;

				System.out.println("create user Account!!");
				System.out.println("---------------------------");
				while(n==1)
				{
					
					System.out.println("enter user id.");
					ua.setUid(sc.nextInt());
					System.out.println("enter user name.");
					ua.setUname(sc.next());
					System.out.println("enter user account type.");
					ua.setAccType(sc.next());
					System.out.println("enter user account balance.");
					ua.setBalance(sc.nextDouble());
					ssn.save(ua);
					ssn.beginTransaction().commit();
					
					System.out.println("account successfully created!!");
					System.out.println("---------------------------");
					System.out.println("1:create one more account OR 2: add bank to this account "+"\n"+" 3: add address of this account OR 100: main menu");
					 n=sc.nextInt();
					System.out.println("---------------------------");
				}
				while(n==2)
				{
					System.out.println("add bank!!");
					System.out.println("---------------------------");	
					System.out.println("enter bank id.");
					int eid=sc.nextInt();
					Banks b1=ssn.get(Banks.class, eid);
					ua.getSb().add(b1);
					b1.getSu().add(ua);
					ssn.save(b1);
					ssn.save(ua);
					ssn.beginTransaction().commit();
					System.out.println("---------------------------");
					System.out.println("1:create one more account OR 2: add bank to this account "+"\n"+" 3: add address of this account OR 100: main menu");
					 n=sc.nextInt();
					System.out.println("---------------------------");
				}
				while(n==3)
				{
					System.out.println("add address!!");
					System.out.println("---------------------------");	
					System.out.println("enter pincode.");
					int eid=sc.nextInt();
					Address ad1=ssn.get(Address.class, eid);
					ua.setAd(ad1);
					ad1.getU().add(ua);
					ssn.save(ad1);
					ssn.save(ua);
					ssn.beginTransaction().commit();
					System.out.println("---------------------------");
					System.out.println("1:create one more account OR 2: add bank to this account "+"\n"+" 3: add address of this account OR 100: main menu");
					 n=sc.nextInt();
					System.out.println("---------------------------");
				}
	}
	public void save_Employee()
	{
		Session ssn=HibernateUtil.getSesssionFactory().openSession();
		n=1;

		System.out.println("create  employee profile!!");
		System.out.println("---------------------------");
		System.out.println("---------------------------");
		System.out.println("1:create one more employee profile OR 2: add bank of employee "+"\n"+" 3: add address of employee OR 100: main menu");
		 n=sc.nextInt();
		System.out.println("---------------------------");
		
		while(n==1)
		{
			System.out.println("enter employee id.");
			e.setEid(sc.nextInt());
			System.out.println("enter employee name.");
			e.setEname(sc.next());
			System.out.println("enter employee designation.");
			e.setDesignation(sc.next());
			System.out.println("enter employee salary.");
			e.setEsalary(sc.nextDouble());
			ssn.save(e);
			ssn.beginTransaction().commit();
			System.out.println("---------------------------");
			System.out.println("1:create one more employee profile OR 2: add bank of employee "+"\n"+" 3: add address of employee OR 100: main menu");
			 n=sc.nextInt();
			System.out.println("---------------------------");
		}
		while(n==2)
		{
			System.out.println("add bank!!");
			System.out.println("---------------------------");	
			System.out.println("enter bank id.");
			int eid=sc.nextInt();
			Banks b2=ssn.get(Banks.class, eid);
			e.setB(b2);
			b2.getSe().add(e);
			ssn.save(b2);
			ssn.save(e);
			ssn.beginTransaction().commit();
			System.out.println("---------------------------");
			System.out.println("1:create one more employee profile OR 2: add bank of employee "+"\n"+" 3: add address of employee OR 100: main menu");
			 n=sc.nextInt();
			System.out.println("---------------------------");
		}
		while(n==3)
		{
			System.out.println("add address!!");
			System.out.println("---------------------------");	
			System.out.println("enter pincode.");
			int eid=sc.nextInt();
			Address ad2=ssn.get(Address.class, eid);
			e.setAd(ad2);
			ad2.getE().add(e);
			ssn.save(ad2);
			ssn.save(e);
			ssn.beginTransaction().commit();
			System.out.println("---------------------------");
			System.out.println("1:create one more employee profile OR 2: add bank of employee "+"\n"+" 3: add address of employee OR 100: main menu");
			 n=sc.nextInt();
			System.out.println("---------------------------");
		}
	}
	
	public void save_banks()
	{	n=1;

		Session ssn=HibernateUtil.getSesssionFactory().openSession();
		System.out.println("save bank details!!");
		System.out.println("---------------------------");
		while(n==1)
		{
			System.out.println("add bank!!");
			System.out.println("---------------------------");
			System.out.println("enter bank id.");
			b.setBid(sc.nextInt());
			System.out.println("enter bank name.");
			b.setBname(sc.next());
			System.out.println("enter branch name.");
			b.setBranchname(sc.next());
			System.out.println("enter non performinf assets.");
			b.setNPA(sc.nextDouble());
			System.out.println("enter performing assets.");
			b.setPA(sc.nextDouble());
			b.setAssets(b.getNPA()+b.getPA());
			ssn.save(b);
			ssn.beginTransaction().commit();
			System.out.println("---------------------------");
			System.out.println("1:save one more bank details OR 2: add employee in this bank "+"\n"+" 3: add user in this bank OR 4:add address of bank OR 100: main menu");
			 n=sc.nextInt();
			System.out.println("---------------------------");
		}
		while(n==2)
		{
			System.out.println("add employee!!");
			System.out.println("---------------------------");	
			System.out.println("enter employee id.");
			int eid=sc.nextInt();
			Employee e2=ssn.get(Employee.class, eid);
			b.getSe().add(e2);
			e2.setB(b);
			ssn.save(b);
			ssn.save(e2);
			ssn.beginTransaction().commit();
			System.out.println("---------------------------");
			System.out.println("1:save one more bank details OR 2: add employee in this bank "+"\n"+" 3: add user in this bank 4:add address of bank OR 100: main menu");
			 n=sc.nextInt();
			System.out.println("---------------------------");
		}
		while(n==3)
		{
			System.out.println("add user!!");
			System.out.println("---------------------------");	
			System.out.println("enter user id.");
			int eid=sc.nextInt();
			UserAccount u2=ssn.get(UserAccount.class, eid);
			b.getSu().add(u2);
			u2.getSb().add(b);
			ssn.save(u2);
			ssn.save(b);
			ssn.beginTransaction().commit();
			System.out.println("---------------------------");
			System.out.println("1:save one more bank details OR 2: add employee in this bank "+"\n"+" 3: add user in this bank 4:add address of bank OR 100: main menu");
			 n=sc.nextInt();
			System.out.println("---------------------------");
		}
		while(n==4)
		{
			System.out.println("add Address!!");
			System.out.println("---------------------------");	
			System.out.println("enter pincode.");
			int eid=sc.nextInt();
			Address u2=ssn.get(Address.class, eid);
			b.setAd(u2);
			u2.getB().add(b);
			ssn.save(u2);
			ssn.save(b);
			ssn.beginTransaction().commit();
			System.out.println("---------------------------");
			System.out.println("1:save one more bank details OR 2: add employee in this bank "+"\n"+" 3: add user in this bank 4:add address of bank OR 100: main menu");
			 n=sc.nextInt();
			System.out.println("---------------------------");
		}
		
	}
	
	public void view()
	{
		Session ssn=HibernateUtil.getSesssionFactory().openSession();

		while(n==0)
		{
			System.out.println("1:to see all bank's list.");
			System.out.println("2:to see bank wise employee list.");
			System.out.println("3:to see bank wise user list.");
			System.out.println("4:to see address list.");
			System.out.println("5:to see banks in your area.");
			System.out.println("6:to see area wise user list.");
			System.out.println("7:to see area wise employee list.");
			System.out.println("8:to see single account details.");
			System.out.println("9:to see single employee details.");
			n=sc.nextInt();
			while(n==1)
			{
				System.out.println("BANKS LIST!!");
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("bank id  |   bank name  |  branch   |  address   |   assets(lakh)  |  PA(lakh)  |  NPA(lakh)");
				System.out.println("---------------------------------------------------------------------------------------------");
				List<Banks> list=ssn.createCriteria(Banks.class).list();
				List<Banks> al=list.stream().filter(a->a.getBid()>1).collect(Collectors.toList());
				al.forEach(a->{
				System.out.println(a.getBid()+"  "+a.getBname()+"   "+a.getBranchname()+"   "+a.getAd().getCity()+"   "+a.getAssets()+"   "+a.getPA()+"  "+a.getNPA());
				});
				System.out.println("---------------------------");
				System.out.println("1:to see one more time  OR 0:menu OR  100:main menu");
				 n=sc.nextInt();
				System.out.println("---------------------------");
			}
			while(n==2)
			{
				System.out.println("BANK WISE EMPLOYEE LIST!!");
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println("enter bank id.");
				int bid=sc.nextInt();
				Banks b=ssn.get(Banks.class, bid);
				System.out.println("total employee works in"+b.getBname()+":"+b.getSe().size());
				System.out.println("-----------------------------------------------------------------------");
				System.out.println("employee id  |  employee name  |  employee desig. |  employee salary");
				System.out.println("-----------------------------------------------------------------------");
				Set<Employee> se=b.getSe();
				for(Employee e:se)
				{
					System.out.println(e.getEid()+"   "+e.getEname()+"   "+e.getDesignation()+"   "+e.getEsalary());
				}
				System.out.println("---------------------------");
				System.out.println("2:to see other bank's employee lsit OR 0:menu OR 100: main menu");
				 n=sc.nextInt();
				System.out.println("---------------------------");
			}
			
			while(n==3)
			{
				System.out.println("BANK WISE USER LIST!!");
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println("enter bank id.");
				int bid=sc.nextInt();
				Banks b=ssn.get(Banks.class, bid);
				System.out.println("total USER in"+b.getBname()+":"+b.getSu().size());
				System.out.println("-----------------------------------------------------------------------");
				System.out.println("user id  |  user name  |  account type |  account balance");
				System.out.println("-----------------------------------------------------------------------");
				Set<UserAccount> se=b.getSu();
				for(UserAccount e:se)
				{
					System.out.println(e.getUid()+"   "+e.getUname()+"   "+e.getAccType()+"   "+e.getBalance());
				}
				System.out.println("---------------------------");
				System.out.println("2:to see other bank's user lsit OR 0:menu OR 100: main menu");
				 n=sc.nextInt();
				System.out.println("---------------------------");
			}
			while(n==4)
			{
				System.out.println("ADDRESS LIST!!");
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println("pincode  |   street  |  city   |  state");
				System.out.println("---------------------------------------------------------------------------------------");
				List<Address> list=ssn.createCriteria(Address.class).list();
				List<Address> al=list.stream().filter(a->a.getPincode()>1).collect(Collectors.toList());
				al.forEach(a->{
				System.out.println(a.getPincode()+"  "+a.getStreet()+"   "+a.getCity()+"   "+a.getState());
				});
				System.out.println("---------------------------");
				System.out.println("4:to see one more time  OR 0:menu OR  100:main menu");
				 n=sc.nextInt();
				System.out.println("---------------------------");
			}
			while(n==5)
			{
				System.out.println("BANKS AVAILABLE IN YOUR AREA!!");
				System.out.println("------------------------------------");
				System.out.println("enter your pincode.");
				int pin=sc.nextInt();
				Address ad=ssn.get(Address.class, pin);
				Set<Banks> sb=ad.getB();
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("bank id  |   bank name  |  branch   |  address   |   assets(lakh)  |  PA(lakh)  |  NPA(lakh)");
				System.out.println("---------------------------------------------------------------------------------------------");
				for(Banks b:sb)
				{
					System.out.println(b.getBid()+"  "+b.getBname()+"  "+b.getBranchname()+"  "+b.getAd().getCity()+"  "+b.getAssets()+"  "+b.getPA()+"  "+b.getNPA());
				}
				System.out.println("---------------------------");
				System.out.println("5:to see at another address  OR 0:menu OR  100:main menu");
				 n=sc.nextInt();
				System.out.println("---------------------------");
			}
			while(n==6)
			{
				System.out.println("AREA WISE USER LIST.!!");
				System.out.println("------------------------------------");
				System.out.println("enter pincode.");
				int pin=sc.nextInt();
				Address ad=ssn.get(Address.class, pin);
				Set<UserAccount> su=ad.getU();
				System.out.println("----------------------------------------------------------");
				System.out.println("user id  |  user name  |  account type |  account balance");
				System.out.println("----------------------------------------------------------");
				for(UserAccount e:su)
				{
					System.out.println(e.getUid()+"   "+e.getUname()+"   "+e.getAccType()+"   "+e.getBalance());
				}
				System.out.println("---------------------------");
				System.out.println("6:to see at another address  OR 0:menu OR  100:main menu");
				 n=sc.nextInt();
				System.out.println("---------------------------");
			}
			while(n==7)
			{
				System.out.println("AREA WISE EMPLOYEE LIST.!!");
				System.out.println("------------------------------------");
				System.out.println("enter pincode.");
				int pin=sc.nextInt();
				Address ad=ssn.get(Address.class, pin);
				Set<Employee> se=ad.getE();
				System.out.println("-----------------------------------------------------------------------");
				System.out.println("employee id  |  employee name  |  employee desig. |  employee salary");
				System.out.println("-----------------------------------------------------------------------");
				for(Employee e:se)
				{
					System.out.println(e.getEid()+"   "+e.getEname()+"   "+e.getDesignation()+"   "+e.getEsalary());
				}
				System.out.println("---------------------------");
				System.out.println("7:to see at another address  OR 0:menu OR  100:main menu");
				 n=sc.nextInt();
				System.out.println("---------------------------");
			}
			while(n==8)
			{
				System.out.println("USER ACCOUNT DETAILS.");
				System.out.println("------------------------------");
				System.out.println("enter user id.");
				int uid=sc.nextInt();
				UserAccount e=ssn.get(UserAccount.class, uid);
				System.out.println("----------------------------------------------------------");
				System.out.println("user id  |  user name  |  account type |  account balance");
				System.out.println("----------------------------------------------------------");
				System.out.println(e.getUid()+"   "+e.getUname()+"   "+e.getAccType()+"   "+e.getBalance());
				System.out.println("---------------------------");
				System.out.println("8:to see another account  OR 10: to see address of user. OR 0:menu OR  100:main menu");
				 n=sc.nextInt();
				System.out.println("---------------------------");
				while(n==10)
				{
					System.out.println("ADDRESS DETAILS.");
					System.out.println("------------------------");
					
					System.out.println("---------------------------------------------------------------------------------------");
					System.out.println("pincode  |   street  |  city   |  state");
					System.out.println("---------------------------------------------------------------------------------------");
					System.out.println(e.getAd().getPincode()+"  "+e.getAd().getStreet()+"   "+e.getAd().getCity()+"   "+e.getAd().getState());
					System.out.println("---------------------------");
					System.out.println("8:to see another account OR 0:menu OR 100:main menu");
					 n=sc.nextInt();
					System.out.println("---------------------------");
				}
			}
			while(n==9)
			{
				System.out.println("EMPLOYEE PROFILE.");
				System.out.println("----------------------------");
				System.out.println("enter employee id.");
				int eid=sc.nextInt();
				Employee e=ssn.get(Employee.class, eid);
				System.out.println("-----------------------------------------------------------------------");
				System.out.println("employee id  |  employee name  |  employee desig. |  employee salary");
				System.out.println("-----------------------------------------------------------------------");
				System.out.println(e.getEid()+"   "+e.getEname()+"   "+e.getDesignation()+"   "+e.getEsalary());
				System.out.println("---------------------------");
				System.out.println("9:to see another profile  OR 11: to see address of employee. OR 0:menu OR  100:main menu");
				 n=sc.nextInt();
				System.out.println("---------------------------");
				while(n==11)
				{
					System.out.println("ADDRESS DETAILS.");
					System.out.println("------------------------");
					
					System.out.println("---------------------------------------------------------------------------------------");
					System.out.println("pincode  |   street  |  city   |  state");
					System.out.println("---------------------------------------------------------------------------------------");
					System.out.println(e.getAd().getPincode()+"  "+e.getAd().getStreet()+"   "+e.getAd().getCity()+"   "+e.getAd().getState());
					System.out.println("---------------------------");
					System.out.println("9:to see another account OR 0:menu OR 100:main menu");
					 n=sc.nextInt();
					System.out.println("---------------------------");
				}
			}
			
		}
	}
	
	public void update()
	{
		Session ssn=HibernateUtil.getSesssionFactory().openSession();
		Transaction ts=ssn.beginTransaction();
		
		while(n==0)
		{
			System.out.println("1:to update employee profile.");
			System.out.println("2:to manage user account.");
			System.out.println("3:to manage bank account.");
			n=sc.nextInt();
			while(n==1)
			{
				System.out.println("UPDATE EMPLOYEE PROFILE.");
				System.out.println("-----------------------------");
				System.out.println("enter employee id.");
				int eid=sc.nextInt();
				
				Employee e=ssn.get(Employee.class, eid);
				System.out.println("employee's privious salary: "+e.getEsalary());
				System.out.println("-------------------------------------------------");
				System.out.println("enter updated salary.");
				e.setEsalary(sc.nextDouble());
				ssn.update(e);
				ts.commit();
				System.out.println("salary successfully updated!!");
				System.out.println("---------------------------");
				System.out.println("1:to update another employee salary OR 0:menu OR 100:main menu");
				 n=sc.nextInt();
				System.out.println("---------------------------");	
			}
			while(n==2)
			{
				System.out.println("MANAGE USER ACCOUNT.");
				System.out.println("-----------------------------");
				System.out.println("enter user account id.");
				int uid=sc.nextInt();
				UserAccount ua=ssn.get(UserAccount.class, uid);
				System.out.println("-----------------------------");
				System.out.println("current account balance of uid ::"+ua.getUid()+":: "+ua.getBalance());
				System.out.println("------------------------------------------------------------------------");
				System.out.println("1:to credit ammount in account");
				System.out.println("2:to debit ammount from account.");
				x=sc.nextInt();
				if(x==1)
				{
					System.out.println("enter aamount you want to credit in account.");
					double c=sc.nextDouble();
					ua.setCredit(c);
					ua.setBalance(ua.getBalance()+c);
					ssn.update(ua);
					ts.commit();
					System.out.println("Thank you for transaction.!!");
					System.out.println("---------------------------");
					System.out.println("current account balance after credit::"+ua.getBalance());
				}
				else if(x==2)
				{
					System.out.println("enter aamount you want to debit from account.");
					double d=sc.nextDouble();
					ua.setDebit(d);
					ua.setBalance(ua.getBalance()-d);
					ssn.update(ua);
					ts.commit();
					System.out.println("Thank you for transaction.!!");
					System.out.println("---------------------------");
					System.out.println("current account balance after debit::"+ua.getBalance());
				}
				System.out.println("---------------------------");
				System.out.println("2:to manage another user account OR 0:menu OR 100:main menu");
				 n=sc.nextInt();
				System.out.println("---------------------------");	
			}
			while(n==3)
			{
				System.out.println("MANAGE BANK ACCOUNT.");
				System.out.println("------------------------------");
				System.out.println("enter bank id.");
				int bid=sc.nextInt();
				Banks b=ssn.get(Banks.class, bid);
				System.out.println("total assets of bank id:"+b.getBid()+" : "+b.getAssets());
				System.out.println("-----------------------------------------------------------");
				System.out.println("1:to update performing assets.");
				System.out.println("2:to update non-performing assets.");
				x=sc.nextInt();
				if(x==1)
				{
					System.out.println("enter revised performing assets.");
					double pa=sc.nextDouble();
					b.setPA(pa);
					b.setAssets(b.getPA()+b.getNPA());
					ssn.update(b);
					ts.commit();
					System.out.println("performing assets revised!!");
					System.out.println("---------------------------");
					System.out.println("total assets of bank id:"+b.getBid()+" : "+b.getAssets());
					System.out.println("-----------------------------------------------------------");
				}
				else if(x==2)
				{
					System.out.println("enter revised non-performing assets.");
					double npa=sc.nextDouble();
					b.setNPA(npa);
					b.setAssets(b.getPA()+b.getNPA());
					ssn.update(b);
					ts.commit();
					System.out.println("non-performing assets revised!!");
					System.out.println("---------------------------");
					System.out.println("total assets of bank id:"+b.getBid()+" : "+b.getAssets());
					System.out.println("-----------------------------------------------------------");
				}
				System.out.println("---------------------------");
				System.out.println("3:to manage another bank's account OR 0:menu OR 100:main menu");
				 n=sc.nextInt();
				System.out.println("---------------------------");
			}
			
		}

	}
	
	public void transfer() {
		
		Session ssn=HibernateUtil.getSesssionFactory().openSession();
		Transaction ts=ssn.beginTransaction();
		
		System.out.println("TRANSFER EMPLOYEE.");
		System.out.println("-----------------------------");
		System.out.println("enter employee id.");
		int eid=sc.nextInt();
		
		Employee e=ssn.get(Employee.class, eid);
		int bid = e.getB().getBid();
		Banks b = ssn.get(Banks.class, bid);
		 
		b.getSe().forEach(s->{
			if(s.getEid() == eid) {
				b.getSe().remove(s);
			}
		});
		
		System.out.println("enter New Bank id.");
		int nbid=sc.nextInt();
		Banks nb = ssn.get(Banks.class, nbid);
		e.setB(nb);
		nb.getSe().add(e);
		ssn.update(e);
		ssn.update(b);
		ts.commit();
		
		System.out.println("Employee Transfered to new Bank.");
	}
	
	
	public void delete()
	{
		Session ssn=HibernateUtil.getSesssionFactory().openSession();
		Transaction ts=ssn.beginTransaction();
		
		System.out.println("REMOVE BANK FROM LIST.");
		System.out.println("---------------------------");
		System.out.println("enter bank id.");
		int bid=sc.nextInt();
		
		Banks b=ssn.get(Banks.class, bid);
		ssn.delete(b);
		ts.commit();
	}

}
