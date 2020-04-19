/**
 * 
 */
package com.healthcare.Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author user
 *
 */
public class HospitalRepository {
	
	Connection con = null;

	public HospitalRepository() {
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
	public void create(Hospital hospital) {

		String sql = "insert into hospital values(?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, hospital.getHRegID());
			st.setString(2, hospital.getHName());
			st.setString(3, hospital.getHAddress());
			st.setString(4, hospital.getHCity());
			st.setString(5, hospital.getHDestrict());
			st.setString(6, hospital.getHProvince());
			st.setString(7, hospital.getHEmail());
			st.setString(8, hospital.getHContactNum());
			st.setString(9, hospital.getHUsername());
			st.setString(10, hospital.getHPassword());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// Retrieve list
	public List<Hospital> getHospitals() {
		List<Hospital> hospitals = new ArrayList<Hospital>();
		String sql = "select * from hospital";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Hospital h = new Hospital();

				h.setHRegID(rs.getString(1));
				h.setHName(rs.getString(2));
				h.setHAddress(rs.getString(3));
				h.setHCity(rs.getString(4));
				h.setHDestrict(rs.getString(5));
				h.setHProvince(rs.getString(6));
				h.setHEmail(rs.getString(7));
				h.setHContactNum(rs.getString(8));
				h.setHUsername(rs.getString(9));
				h.setHPassword(rs.getString(10));

				hospitals.add(h);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return hospitals;
	}

	//Get specific details
			public Hospital getHospital(String HRegID) {
				String sql = "select * from hospital where HRegID=" + HRegID;
				Hospital h = new Hospital();

				try {
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);

					if (rs.next()) {

						h.setHRegID(rs.getString(1));
						h.setHName(rs.getString(2));
						h.setHAddress(rs.getString(3));
						h.setHCity(rs.getString(4));
						h.setHDestrict(rs.getString(5));
						h.setHProvince(rs.getString(6));
						h.setHEmail(rs.getString(7));
						h.setHContactNum(rs.getString(8));
						h.setHUsername(rs.getString(9));
						h.setHPassword(rs.getString(10));

					}

				} catch (Exception e) {
					System.out.println(e);
				}

				return h;
			}
			
			
			//Update
			public void update(Hospital h) {

				String sql = "update hospital set HName=?, HAddress=?, HCity=?, HDestrict=?, HProvince=?, HEmail=?, HContactNum=?, HUsername=?, HPassword=? where HRegID=?;";

				try {
					PreparedStatement st = con.prepareStatement(sql);

					st.setString(1, h.getHName());
					st.setString(2, h.getHAddress());
					st.setString(3, h.getHCity());
					st.setString(4, h.getHDestrict());
					st.setString(5, h.getHProvince());
					st.setString(6, h.getHEmail());
					st.setString(7, h.getHContactNum());
					st.setString(8, h.getHUsername());
					st.setString(9, h.getHPassword());
					st.setString(10, h.getHRegID());			
					
					
					st.executeUpdate();

				} catch (Exception e) {
					System.out.println(e);
				}

			}
			

			
			// Reset Password
			public void reset(Hospital h) {

				String sql = "update hospital set HUsername=?, HPassword=? where HRegID=?;";

				try {
					PreparedStatement st = con.prepareStatement(sql);

					st.setString(1, h.getHUsername());
					st.setString(2, h.getHPassword());
					st.setString(3, h.getHRegID());

					st.executeUpdate();

				} catch (Exception e) {
					System.out.println(e);
				}

			}
					
			

			
			//Delete
			public void deleteHospital(String HRegID) {
				String sql = "delete from hospital where HRegID=?;";

				try {
					PreparedStatement st = con.prepareStatement(sql);

					st.setString(1, HRegID);

					st.executeUpdate();

				} catch (Exception e) {
					System.out.println(e);
				}

			}

}
