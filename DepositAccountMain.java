package com.java.mphasis.bankproj;

import java.sql.SQLException;
import java.util.Scanner;

public class DepositAccountMain {
	
	public static void main(String[] args) {
		int accountNo, depositAmount;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter AccountNo  ");
		accountNo=sc.nextInt();
		System.out.println("Enter Deposit Amount  ");
		depositAmount =sc.nextInt();
		try {
			System.out.println(new AccountDao().depositAccount(accountNo, depositAmount));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}
}
