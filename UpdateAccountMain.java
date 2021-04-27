package com.java.mphasis.bankproj;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateAccountMain {
	public static void main(String[] args) {
		int accountNo;
		String city,state;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account No ");
		accountNo=Integer.parseInt(sc.nextLine());
		System.out.println("Enter City  ");
		city=sc.nextLine();
		System.out.println("Enter State  ");
		state = sc.nextLine();
		try {
			System.out.println(new AccountDao().updateAccount(accountNo, city, state));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}
}
