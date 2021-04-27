package com.java.mphasis.bankproj;

import java.sql.SQLException;
import java.util.Scanner;

public class CloseAccountMain {
	public static void main(String[] args) {
		int account_no;
		String status;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account No. ");
		account_no = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Status");
		status = sc.nextLine();
		
		try {
			System.out.println(new AccountDao().closeAccount(account_no, status));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}
}
