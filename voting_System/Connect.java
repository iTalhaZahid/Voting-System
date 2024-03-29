package voting_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	String username;
	String Password;
	Connection con;
	Statement st;
	ResultSet rs;

	Connect() {
		String path = "jdbc:mysql://localhost:3306/votingsystem";
		String username = "root";
		String password = "";

		try {
			con = DriverManager.getConnection(path, username, password);
			st = con.createStatement();
//			System.out.println("Connection Created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insert(String name, String fathername, String cnic, String gender, String birthyear, String phoneno,
			String adress, String city, String Vote) {
		String query = "INSERT INTO voter(Name,FatherName,CNIC,Gender,BirthYear,PhoneNo,Adress,City,Vote)VALUES('"
				+ name + "','" + fathername + "','" + cnic + "','" + gender + "','" + birthyear + "','" + phoneno
				+ "','" + adress + "','" + city + "','" + Vote + "')";
		try {
			Statement s;
			s = con.createStatement();
			s.executeUpdate(query);
//			System.out.println("Data sent");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(String id, String name, String fathername, String cnic, String gender, String birthyear,
			String phoneno, String adress, String city, String Vote) {
		String query = "UPDATE voter SET Name='" + name + "',FatherName='" + fathername + "',CNIC='" + cnic
				+ "',Gender='" + gender + "',BirthYear='" + birthyear + "',PhoneNo='" + phoneno + "',Adress='" + adress
				+ "',City='" + city + "',Vote='" + Vote + "' WHERE ID='" + id + "'";
		try {
			Statement s;
			s = con.createStatement();
			s.executeUpdate(query);
//			System.out.println("Data Updated");
//			System.out.println("Confirmation code" + " " + i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void select() {
		String query = "SELECT * FROM voter "; // * stands for all
		try {
			Statement s;
			s = con.createStatement();
			ResultSet rs = s.executeQuery(query);

			while (rs.next()) {
//				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
//						+ rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) + " "
//						+ rs.getString(8) + " " + rs.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int selectvoter(String cnic) {
		String query = "SELECT * FROM voter WHERE CNIC='" + cnic + "'"; // * stands for all

		try {
			Statement s;
			s = con.createStatement();
			ResultSet rs = s.executeQuery(query);

			if (rs.next() == false) {
				return -1;
			} else {
//				System.out.println(rs.getString("Name") + " " + rs.getString("FatherName") + " "
//						+ rs.getString("BirthYear") + " " + rs.getString("Vote") + " " + rs.getString("City"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int selectvoter(String cnic, String BirthYear) {
		String query = "SELECT * FROM voter WHERE CNIC='" + cnic + "' AND BirthYear='" + BirthYear + "'"; // * stands
																											// for all

		try {
			Statement s;
			s = con.createStatement();
			ResultSet rs = s.executeQuery(query);

			if (rs.next() == false) {
				return -1;
			} else {
//				String voted = rs.getString("Voted");

				if ("Yes".equals(rs.getString("Voted"))) {
					return 1;
				}
				else if (rs.getString("Vote").equals("Yes")) {
					return 0;}
//						System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
//								+ rs.getString(4));
					else if(rs.getString("Vote").equals("No")){
						return 2;}
				
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public ResultSet eligibility(String cnic) {
		String query = "SELECT * FROM voter WHERE CNIC='" + cnic + "'"; // * stands for all

		try {
			Statement s;
			s = con.createStatement();
			rs = s.executeQuery(query);

//							while(rs.next()) {

//								System.out.println(rs.getString(1)+" "+rs.getString(2)+" " +rs.getString(5)+" "+rs.getString(8)+" "+rs.getString(9));
//							}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public int selectadmin(String Username, String Password) {
		String query = "SELECT * FROM admin WHERE Username='" + Username + "' AND Password='" + Password + "'"; // *
																												// stands
																												// for
																												// all

		try {
			Statement s;
			s = con.createStatement();
			ResultSet rs = s.executeQuery(query);

			if (rs.next() == false) {
				return -1;
			} else {
//				System.out.println(rs.getString("Name") + " " + rs.getString("FatherName") + " "
//						+ rs.getString("Username") + " " + rs.getString("Password"));
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public void delete(String cnic) {
		String query = "DELETE FROM voter WHERE CNIC='" + cnic + "'";
		try {
			Statement s;
			s = con.createStatement();
			s.executeUpdate(query);
//			System.out.println("Data Deleted");
//			System.out.println("Confirmation code" + " " + i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet party() {
		String query = "SELECT * FROM stats";
		try {
			Statement s;
			s = con.createStatement();
			rs = s.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public void vote(String CNIC, String selection, int votes) {
		String query = "UPDATE voter SET Voted='Yes' WHERE CNIC='" + CNIC + "'";
		String query1 = "UPDATE stats SET " + selection + "=" + votes + "";
		try {
			Statement s;
			s = con.createStatement();
			s.executeUpdate(query);
			s.executeUpdate(query1);
		} catch (SQLException se) {

		}
	}
}