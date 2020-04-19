/**
 * 
 */
package com.healthcare.laboratory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oshadi
 *
 */
public class testTypeRepository {

	Connection con = null;

	public testTypeRepository() {
		String url = "jdbc:mysql://localhost:3307/test";
		String username = "root";
		String password = "root";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {

			System.out.println(e);

		}
	}

	// Create
	public void create(testType type) {

		String sql = "insert into testType values(?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, type.getLabRegID());
			st.setString(2, type.getTestName());
			st.setString(3, type.getTestFee());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// Retrieve list
	public List<testType> getTypes() {
		List<testType> types = new ArrayList<testType>();
		String sql = "select * from testType";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				testType type = new testType();

				type.setLabRegID(rs.getString(1));
				type.setTestName(rs.getString(2));
				type.setTestFee(rs.getString(3));

				types.add(type);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return types;
	}

	// Get specific details
	public testType getType(String labRegID) {
		String sql = "select * from testType where labRegID=" + labRegID;
		testType type = new testType();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {

				type.setLabRegID(rs.getString(1));
				type.setTestName(rs.getString(2));
				type.setTestFee(rs.getString(3));

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return type;
	}

	// update
	public void updateType(testType type) {
		String sql = "update testType set testName = ?, testFee = ? where labRegID = ?;";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, type.getTestName());
			st.setString(2, type.getTestFee());
			st.setString(3, type.getLabRegID());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	// Delete
		public void deleteType(String labRegID) {
			String sql = "delete from testType where labRegID=?;";

			try {
				PreparedStatement st = con.prepareStatement(sql);

				st.setString(1, labRegID);

				st.executeUpdate();

			} catch (Exception e) {
				System.out.println(e);
			}

		}
	
}