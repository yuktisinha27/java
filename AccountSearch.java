package com.java.mphasis.bankproj;

import java.util.Scanner;

public class AccountSearch {
	public static void main(String[] args) {
		int account_no;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account No.  ");
		account_no = sc.nextInt();
		Account account = new AccountDao().searchAccount(account_no);
		if(account!= null) {
			System.out.println(account);
		}
		else {
			System.out.println("Record not found");
		}
		
		sc.close();
	}
}
