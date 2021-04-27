package com.java.mphasis.bankproj;

import java.sql.SQLException;
import java.util.Scanner;

public class MinStatement {
	public static void main(String[] args) {
		int account_no;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account no");
		account_no = Integer.parseInt(sc.nextLine());
		try {
			System.out.println(new AccountDao().minStatemnt(account_no));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}
}
