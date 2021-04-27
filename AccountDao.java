package com.java.mphasis.bankproj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
	
	Connection con;
	PreparedStatement pst;
	
	public String minStatemnt(int account_no) throws SQLException {
		Account account = searchAccount(account_no);
		String result = "";
		if(account!= null) {
			con = ConnectionHelper.getConnection();
			String cmd = "select ac.first_name, ac.last_name, ac.account_no, t.trans_id, t.tran_amount, t.trans_type, t.transdate from transaction t inner join account ac on ac.account_no = t.account_no order by trans_id";
			pst = con.prepareStatement(cmd);
			pst.setMaxRows(10);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println("First Name "+rs.getString("first_name"));
				System.out.println("Last Name "+rs.getString("last_name"));
				System.out.println("Account No. "+rs.getInt("account_no"));
				System.out.println("Transaction ID "+rs.getInt("trans_id"));
				System.out.println("Transaction Amount "+rs.getInt("tran_amount"));
				System.out.println("Transaction Type "+rs.getString("trans_type"));
				System.out.println("Transaction Date "+rs.getDate("transdate"));
				System.out.println("-------------------------------------------------");
			}
			result = "Mini Statement Created";
		}
		else {
			result = "Account does not exist";
		}
		return result;
	}
	public String closeAccount(int account_no, String status) throws SQLException {
		Account account = searchAccount(account_no);
		String result = "";
		if(account!=null) {
			con = ConnectionHelper.getConnection();
			String cmd ="update account set status=? where account_no =?";
			pst = con.prepareStatement(cmd);
			pst.setString(1, status);
			pst.setInt(2, account_no);
			pst.executeUpdate();
			result = "Account's Status has been changed Successfully....";
		}
		else {
			result = "Account does not exist...";
		}
		return result;
	}
	public int generateTransId() throws SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "select case when max(trans_id) is NULL then 1 "
				+ " else max(trans_id)+1 end tid from Transaction";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int accNo=rs.getInt("tid");
		return accNo;
	}
	public String depositAccount(int account_no, int depositAmount) throws SQLException {
		Account account = searchAccount(account_no);
		String result="";
		int tid = generateTransId();
		if (account!=null) {
			con = ConnectionHelper.getConnection();
			String cmd = "update account set amount=amount+?  "
					+ " where account_no=?";
			pst = con.prepareStatement(cmd);
			pst.setInt(1, depositAmount);
			pst.setInt(2, account_no);
			pst.executeUpdate();
			cmd = "Insert into transaction(trans_id,account_no,tran_amount,Trans_type) "
					+ " values(?,?,?,?)";
			pst = con.prepareStatement(cmd);
			pst.setInt(1, tid);
			pst.setInt(2, account_no);
			pst.setInt(3, depositAmount);
			pst.setString(4, "C");
			pst.executeUpdate();
			result = "Amount Credited...";
		} else {
			result = "Account No Not Found...";
		}
		return result;
	}
	
	public String withdrawAccount(int account_no,int amount, int withdrawAmount) throws SQLException {
		Account account = searchAccount(account_no);
		String result = "";
		int tid = generateTransId();
		if(account!= null) {
			int minAmount;
			amount = account.getAmount();
			minAmount = amount -withdrawAmount;
			if(minAmount>1000) {
			con = ConnectionHelper.getConnection();
			String cmd = "update account set amount=amount-?  "
					+ " where account_no=?";
			pst = con.prepareStatement(cmd);
			pst.setInt(1, withdrawAmount);
			pst.setInt(2, account_no);
			pst.executeUpdate();
			cmd = "Insert into transaction(trans_id,account_no,tran_amount,trans_type) "
					+ " values(?,?,?,?)";
			pst = con.prepareStatement(cmd);
			pst.setInt(1, tid);
			pst.setInt(2, account_no);
			pst.setInt(3, withdrawAmount);
			pst.setString(4, "D");
			pst.executeUpdate();
			result = "Amount Debited...";
			}
			else {
				result = "Insufficient balance";
			}
		
	}
		else {
			result = "Account Not Found";
		}
		return result;
}
	
	public String updateAccount(int account_no, String city, String state) throws SQLException {
		Account account = searchAccount(account_no);
		String result = "";
		if (account!=null) {
			con = ConnectionHelper.getConnection();
			String cmd = "update account set City=?, State=? WHERE account_no=?";
			pst = con.prepareStatement(cmd);
			pst.setString(1, city);
			pst.setString(2, state);
			pst.setInt(3, account_no);
			pst.executeUpdate();
			result ="Account Updated successfully...";
		} else {
			result = "Invalid Account No...";
		}
		return result;
	}
	public Account searchAccount(int account_no) {
		Account account = null;
		con = ConnectionHelper.getConnection();
		String cmd = "select * from Account where account_no=?";
		try {
			pst = con.prepareStatement(cmd);
			pst.setInt(1, account_no);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				account = new Account();
				account.setAccount_no(rs.getInt("account_no"));
				account.setFirst_name(rs.getString("first_name"));
				account.setLast_name(rs.getString("last_name"));
				account.setCity(rs.getString("city"));
				account.setState(rs.getString("State"));
				account.setAmount(rs.getInt("amount"));
				account.setCheq_facil(rs.getString("cheq_facil"));
				account.setAccount_type(rs.getString("account_type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
	public String createAccount(Account account) throws SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "insert into Account(account_no,first_name,last_name,city,state, "
				+ "amount,cheq_facil,Account_type) values(?,?,?,?,?,?,?,?)";
		int accNo = generateAccountNo();
		pst = con.prepareStatement(cmd);
		pst.setInt(1, accNo);
		pst.setString(2, account.getFirst_name());
		pst.setString(3, account.getLast_name());
		pst.setString(4, account.getCity());
		pst.setString(5, account.getState());
		pst.setInt(6, account.getAmount());
		pst.setString(7, account.getCheq_facil());
		pst.setString(8, account.getAccount_type());
		pst.executeUpdate();
		return "Account Created Successfully...";
	}
	public int generateAccountNo() throws SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "select case when max(account_no) is NULL then 1 "
				+ " else max(account_no)+1 end accno from Account";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int accNo=rs.getInt("accno");
		return accNo;
	}
}
