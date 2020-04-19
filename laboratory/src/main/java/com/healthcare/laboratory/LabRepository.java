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
public class LabRepository {
	
	Connection con = null;

	public LabRepository() {
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
	public void create(Lab lab) {

		String sql = "insert into lab values(?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, lab.getLabRegID());
			st.setString(2, lab.getLabName());
			st.setString(3, lab.getLabAddress());
			st.setString(4, lab.getLabCity());
			st.setString(5, lab.getLabDestrict());
			st.setString(6, lab.getLabProvince());
			st.setString(7, lab.getLabEmail());
			st.setString(8, lab.getLabContactNum());
			st.setString(9, lab.getLabUsername());
			st.setString(10, lab.getLabPassword());
			st.setString(11, lab.getOpenTime());
			st.setString(12, lab.getCloseTime());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// Retrieve list
	public List<Lab> getLabs() {
		List<Lab> labs = new ArrayList<Lab>();
		String sql = "select * from lab";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Lab l = new Lab();

				l.setLabRegID(rs.getString(1));
				l.setLabName(rs.getString(2));
				l.setLabAddress(rs.getString(3));
				l.setLabCity(rs.getString(4));
				l.setLabDestrict(rs.getString(5));
				l.setLabProvince(rs.getString(6));
				l.setLabEmail(rs.getString(7));
				l.setLabContactNum(rs.getString(8));
				l.setLabUsername(rs.getString(9));
				l.setLabPassword(rs.getString(10));
				l.setOpenTime(rs.getString(11));
				l.setCloseTime(rs.getString(12));

				labs.add(l);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return labs;
	}

	// Get specific details
	public Lab getLab(String labRegID) {
		String sql = "select * from lab where labRegID=" + labRegID;
		Lab l = new Lab();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {

				l.setLabRegID(rs.getString(1));
				l.setLabName(rs.getString(2));
				l.setLabAddress(rs.getString(3));
				l.setLabCity(rs.getString(4));
				l.setLabDestrict(rs.getString(5));
				l.setLabProvince(rs.getString(6));
				l.setLabEmail(rs.getString(7));
				l.setLabContactNum(rs.getString(8));
				l.setLabUsername(rs.getString(9));
				l.setLabPassword(rs.getString(10));
				l.setOpenTime(rs.getString(11));
				l.setCloseTime(rs.getString(12));

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return l;
	}

	// Update
	public void update(Lab l) {

		String sql = "update lab set labName=?, labAddress=?, labCity=?, labDestrict=?, labProvince=?, labEmail=?, labContactNum=? , labUsername=?, labPassword=?, OpenTime=?, CloseTime=? where labRegID=?;";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, l.getLabName());
			st.setString(2, l.getLabAddress());
			st.setString(3, l.getLabCity());
			st.setString(4, l.getLabDestrict());
			st.setString(5, l.getLabProvince());
			st.setString(6, l.getLabEmail());
			st.setString(7, l.getLabContactNum());
			st.setString(8, l.getLabUsername());
			st.setString(9, l.getLabPassword());
			st.setString(10, l.getOpenTime());
			st.setString(11, l.getCloseTime());
			st.setString(12, l.getLabRegID());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// Reset Password
	public void reset(Lab l) {

		String sql = "update lab set labUsername=?, labPassword=? where labRegID=?;";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, l.getLabUsername());
			st.setString(2, l.getLabPassword());
			st.setString(3, l.getLabRegID());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// Delete
	public void deleteLab(String labRegID) {
		String sql = "delete from lab where labRegID=?;";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, labRegID);

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
