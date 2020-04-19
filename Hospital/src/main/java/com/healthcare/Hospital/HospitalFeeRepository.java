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
public class HospitalFeeRepository {
	
	Connection con = null;

	public HospitalFeeRepository() {
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
		public void createFee(HospitalFee fee) {

			String sql = "insert into hospitalFee values(?,?,?)";

			try {
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, fee.getHFeeID());
				st.setString(2, fee.getHRegID());
				st.setString(3, fee.getHFee());
			
				st.executeUpdate();

			} catch (Exception e) {
				System.out.println(e);
			}

		}

		// Retrieve list
		public List<HospitalFee> getHospitalFees() {
			List<HospitalFee> hospitals = new ArrayList<HospitalFee>();
			String sql = "select * from hospitalFee";

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);

				while (rs.next()) {
					HospitalFee fee = new HospitalFee();

					fee.setHFeeID(rs.getString(1));
					fee.setHRegID(rs.getString(2));
					fee.setHFee(rs.getString(3));
					
					hospitals.add(fee);
				}

			} catch (Exception e) {
				System.out.println(e);
			}

			return hospitals;
		}

		//Get specific details
				public HospitalFee getHospitalFee(String HFeeID) {
					String sql = "select * from hospitalFee where HFeeID=" + HFeeID;
					HospitalFee fee = new HospitalFee();

					try {
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery(sql);

						if (rs.next()) {

							fee.setHFeeID(rs.getString(1));
							fee.setHRegID(rs.getString(2));
							fee.setHFee(rs.getString(3));
							

						}

					} catch (Exception e) {
						System.out.println(e);
					}

					return fee;
				}
				
				
				//Update
				public void updateHospitalFeeDetails(HospitalFee fee) {

					String sql = "update hospitalFee set HRegID=?, Fee=? where HFeeID=?;";

					try {
						PreparedStatement st = con.prepareStatement(sql);

						st.setString(1, fee.getHRegID());
						st.setString(2, fee.getHFee());	
						st.setString(3, fee.getHFeeID());
						
						
						st.executeUpdate();

					} catch (Exception e) {
						System.out.println(e);
					}

				}
						
				

				
				//Delete
				public void deleteHospitalFee(String HFeeID) {
					String sql = "delete from hospitalFee where HFeeID=?;";

					try {
						PreparedStatement st = con.prepareStatement(sql);

						st.setString(1, HFeeID);

						st.executeUpdate();

					} catch (Exception e) {
						System.out.println(e);
					}

				}


}
