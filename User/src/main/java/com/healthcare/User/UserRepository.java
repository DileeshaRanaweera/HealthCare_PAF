package com.healthcare.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

	Connection con = null;

	public UserRepository() {
		String url = "jdbc:mysql://localhost:3306/userdb";
		String username = "root";
		String password = "root";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {

			System.out.println(e);

		}
	}
	
	//get All users from database	
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		String sql = "select * from usertable";//table name******

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				User user = new User();

				user.setFname(rs.getString(1));
				user.setLname(rs.getString(2));
				user.setNic(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setUsername(rs.getString(5));
				user.setGender(rs.getString(6));
				user.setAddress(rs.getString(7));
				user.setContact(rs.getString(8));
				user.setPassword(rs.getString(9));
				
				users.add(user);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return users;
	}
	
	//get a single user from db
	public User getUser(String nic) {
		String sql = "select * from usertable where nic=" + nic;//table****
		User person = new User();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {

				person.setFname(rs.getString(1));
				person.setLname(rs.getString(2));
				person.setNic(rs.getString(3));
				person.setEmail(rs.getString(4));
				person.setUsername(rs.getString(5));
				person.setGender(rs.getString(6));
				person.setAddress(rs.getString(7));
				person.setContact(rs.getString(8));
				person.setPassword(rs.getString(9));

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return person;
	}
	
	//create a user
	public void create(User user1) {

		String sql = "insert into usertable values(?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, user1.getFname());
			st.setString(2, user1.getLname());
			st.setString(3, user1.getNic());
			st.setString(4, user1.getEmail());
			st.setString(5, user1.getUsername());
			st.setString(6, user1.getGender());
			st.setString(7, user1.getAddress());
			st.setString(8, user1.getContact());
			st.setString(9, user1.getPassword());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	//update a user
	public void update(User user1) {

		String sql = "update usertable set address = ?, contact = ?,email = ?,username = ?,password = ? where nic = ?;";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, user1.getAddress());
			st.setString(2, user1.getContact());
			st.setString(3, user1.getEmail());
			st.setString(4, user1.getUsername());
			st.setString(5, user1.getPassword());
			
			st.setString(6, user1.getNic());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void deleteUser(String nic) {
		String sql = "delete from usertable where nic =?;";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, nic);

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void updateUserPwdandName(User person) {
		
		String sql = "update usertable set username = ?,password = ? where nic = ?;";
		
		
		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, person.getUsername());
			st.setString(2, person.getPassword());
			
			st.setString(3, person.getNic());
			
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
