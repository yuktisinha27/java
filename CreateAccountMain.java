package com.java.mphasis.bankproj;

import java.sql.SQLException;
import java.util.Scanner;

public class CreateAccountMain {
	public static void main(String[] args) {
		AccountDao dao = new AccountDao();
		Account account = new Account();
		int accno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name ");
		account.setFirst_name(sc.nextLine());
		System.out.println("Enter Last Name");
		account.setLast_name(sc.nextLine());
		System.out.println("Enter City ");
		account.setCity(sc.nextLine());
		System.out.println("Enter State");
		account.setState(sc.nextLine());
		System.out.println("Enter Amount");
		account.setAmount(Integer.parseInt(sc.nextLine()));
		System.out.println("Enter Cheque Facility('YES', 'NO')");
		account.setCheq_facil(sc.nextLine());
		System.out.println("Enter Account Type(SALARY/CURRENT/REGULAR/SAVINGS) in caps");
		account.setAccount_type(sc.nextLine());
		try {
			accno = dao.generateAccountNo();
			account.setAccount_no(accno);
			System.out.println(dao.createAccount(account));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sc.close();
	}
}
