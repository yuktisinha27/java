package com.java.mphasis.bankproj;

import java.sql.SQLException;
import java.util.Scanner;

public class WithdrawAccountMain {
	public static void main(String[] args) {
		int accountNo,amount, withdrawAmount;
		amount = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter AccountNo  ");
		accountNo=sc.nextInt();
		System.out.println("Enter Withdraw Amount  ");
		withdrawAmount =sc.nextInt();
		try {
			System.out.println(new AccountDao().withdrawAccount(accountNo,amount, withdrawAmount));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}
}
