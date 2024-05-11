package com.main;

import java.util.Scanner;

import com.service.Rbi;

public class Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		Rbi r=new Rbi();
		while(true)
		{
			System.out.println("1:save .");
			System.out.println("2:view.");
			System.out.println("3:update.");
			System.out.println("4:delete.");
			System.out.println("5:Transfer.");
			System.out.println("enter your choice.");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1: 
				r.save();
				break;
			case 2:
				r.view();
				break;
			case 3:
				r.update();
				break;
			case 4:
				r.delete();
				break;
			case 5:
				r.transfer();
				break;
			case 6:
				System.exit(0);
			}
		}
	}
}
