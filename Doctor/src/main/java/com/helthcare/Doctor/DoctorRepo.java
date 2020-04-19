package com.helthcare.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepo {
	Connection con = null;

	public DoctorRepo() {
		String url = "jdbc:mysql://localhost:3306/helthcare";// dbname:helthcare
		String username = "root";
		String password = "root";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {

			System.out.println(e);

		}
	}
//*********************************************************************************doctortable*******************************************************************

	// retriwe docs

	public List<Doctor> getdoctors() {
		List<Doctor> doctors = new ArrayList<Doctor>();
		String sql = "select * from doctortable"; // tablename: doctortable

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Doctor doctor = new Doctor();

				doctor.setNIC(rs.getString(1));
				doctor.setMedicalId(rs.getString(2));
				doctor.setFirstName(rs.getString(3));
				doctor.setLastName(rs.getString(4));
				doctor.setGender(rs.getString(5));
				doctor.setAddress(rs.getString(6));
				doctor.setContact(rs.getString(7));
				doctor.setEmail(rs.getString(8));
				doctor.setSpecialization(rs.getString(9));
				doctor.setHospital(rs.getString(10));
				doctor.setStartingTime(rs.getString(11));
				doctor.setEndTime(rs.getString(12));
				doctor.setAppointmentAmount(rs.getInt(13));
				doctor.setUsername(rs.getString(14));
				doctor.setPassword(rs.getString(15));

				doctors.add(doctor);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return doctors;
	}

	// retrivw spesic doc using nic
	public Doctor getdDoctor(String NIC) {
		String sql = "select * from doctortable where nic=" + NIC;
		Doctor doctor = new Doctor();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {

				doctor.setNIC(rs.getString(1));
				doctor.setMedicalId(rs.getString(2));
				doctor.setFirstName(rs.getString(3));
				doctor.setLastName(rs.getString(4));
				doctor.setGender(rs.getString(5));
				doctor.setAddress(rs.getString(6));
				doctor.setContact(rs.getString(7));
				doctor.setEmail(rs.getString(8));
				doctor.setSpecialization(rs.getString(9));
				doctor.setHospital(rs.getString(10));
				doctor.setStartingTime(rs.getString(11));
				doctor.setEndTime(rs.getString(12));
				doctor.setAppointmentAmount(rs.getInt(13));
				doctor.setUsername(rs.getString(14));
				doctor.setPassword(rs.getString(15));

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return doctor;
	}

	// insert a doctor
	public void create(Doctor D) {

		String sql = "insert into doctortable values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, D.getNIC());
			st.setString(2, D.getMedicalId());
			st.setString(3, D.getFirstName());
			st.setString(4, D.getLastName());
			st.setString(5, D.getGender());
			st.setString(6, D.getAddress());
			st.setString(7, D.getContact());
			st.setString(8, D.getEmail());
			st.setString(9, D.getSpecialization());
			st.setString(10, D.getHospital());
			st.setString(11, D.getStartingTime());
			st.setString(12, D.getEndTime());
			st.setInt(13, D.getAppointmentAmount());
			st.setString(14, D.getUsername());
			st.setString(15, D.getPassword());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// update a doctor details
	public void update(Doctor D) {

		String sql = "update doctortable set address = ?, contact = ?,email = ?,stimechecking = ?,etimechecking = ?,noofdailyappointment = ?, username = ?,Docpassword = ? where nic = ?;";
		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, D.getAddress());
			st.setString(2, D.getContact());
			st.setString(3, D.getEmail());
			st.setString(4, D.getStartingTime());
			st.setString(5, D.getEndTime());
			st.setInt(6, D.getAppointmentAmount());
			st.setString(7, D.getUsername());
			st.setString(8, D.getPassword());

			st.setString(9, D.getNIC());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
//	// update a doctor uname and psw
		public void updateuname(Doctor D) {

			String sql = "update doctortable set  username = ?,Docpassword = ? where nic = ?;";
			try {
				PreparedStatement st = con.prepareStatement(sql);

			
				st.setString(1, D.getUsername());
				st.setString(2, D.getPassword());

				st.setString(3, D.getNIC());

				st.executeUpdate();

			} catch (Exception e) {
				System.out.println(e);
			}

		}


	// delete doctor
	public void delete(String NIC) {
		String sql = "delete from doctortable where nic=?;";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, NIC);

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

//*********************************************************************************doctor_days*******************************************************************
//retriwe docs days

	public List<Days> getdoctorsDays() {
		List<Days> Days = new ArrayList<Days>();
		String sql = "select * from doctor_days"; // tablename: doctor_days

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Days dyas = new Days();
				dyas.setNIC(rs.getString(1));
				dyas.setDaysOfvisiting(rs.getString(1));
				
				Days.add(dyas);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return Days;
	}

//retrivw spesic doc visting days nic
	public Days getdDoctordays(String NIC) {
		String sql = "select * from doctor_days where nic=" + NIC;
		Days day = new Days();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {

				day.setNIC(rs.getString(1));
				day.setDaysOfvisiting(rs.getString(2));

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return day;
	}

// insert a doctor days
	public void createDocdays(Days doctorday) {

		String sql = "insert into doctor_days values(?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, doctorday.getNIC());
			st.setString(2, doctorday.getDaysOfvisiting());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

//update a doctor days
	public void updateDocdays(Days D) {

		String sql = "update doctor_days set dayofviste = ? where nic = ?;";
		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, D.getDaysOfvisiting());

			st.setString(2, D.getNIC());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

//delete doctor days
	public void deletedays(String NIC) {
		String sql = "delete from doctor_days where nic=?;";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, NIC);

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
//*********************************************************************************doctor_fee*******************************************************************
	//retriwe docs fees

		public List<Fee> getdoctorsfee() {
			List<Fee> Fee = new ArrayList<Fee>();
			String sql = "select * from doctor_fee"; // tablename: doctor_fee

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);

				while (rs.next()) {
					Fee fee = new Fee();
					fee.setFeeid(rs.getString(1));
					fee.setNIC(rs.getString(2));
					fee.setFeeamount(rs.getString(3));
					
					Fee.add(fee);
				}

			} catch (Exception e) {
				System.out.println(e);
			}

			return Fee;
		}

	//retrivw spesic doc  fee nic
		public Fee getdDoctorfee(String NIC) {
			String sql = "select * from doctor_fee where nic=" + NIC;
			Fee fee = new Fee();

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);

				if (rs.next()) {

					
					fee.setFeeid(rs.getString(1));
					fee.setNIC(rs.getString(2));
					fee.setFeeamount(rs.getString(3));

				}

			} catch (Exception e) {
				System.out.println(e);
			}

			return fee;
		}

	// insert a doctor fee
		public void createDocfee(Fee docfee) {

			String sql = "insert into doctor_fee values(?,?,?)";
			try {
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, docfee.getFeeid());
				st.setString(2, docfee.getNIC());
				st.setString(3, docfee.getFeeamount());

				st.executeUpdate();

			} catch (Exception e) {
				System.out.println(e);
			}

		}

	//update a doctor fee
		public void updateDocfee(Fee f) {

			String sql = "update doctor_fee set fee = ? where nic = ?;";
			try {
				PreparedStatement st = con.prepareStatement(sql);

				st.setString(1, f.getFeeamount());

				st.setString(2, f.getNIC());

				st.executeUpdate();

			} catch (Exception e) {
				System.out.println(e);
			}

		}

	//delete doctor fee
		public void deletefee(String NIC) {
			String sql = "delete from doctor_fee where nic=?;";

			try {
				PreparedStatement st = con.prepareStatement(sql);

				st.setString(1, NIC);

				st.executeUpdate();

			} catch (Exception e) {
				System.out.println(e);
			}

		}
}