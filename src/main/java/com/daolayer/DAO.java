package com.daolayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pojo.Patient;

public class DAO {
private static final String url="jdbc:mysql://localhost:3306/hospitalmanagement";
private static final String username="root";
private static final String password="admin";
public static Connection con=null;
public static PreparedStatement pstmt=null;
public static Connection getDbConnection()
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con=DriverManager.getConnection(url,username,password);
	} catch (Exception e) {
		e.printStackTrace();
	} 
	return con;
}
public static void insertPatientD(Patient p)
{
	String SQL="Insert into patient values(?,?,?,?)";
	try {
		
		pstmt=getDbConnection().prepareStatement(SQL);
		pstmt.setInt(1,p.getPid());
		pstmt.setString(2,p.getName());
		pstmt.setInt(3,p.getAge());
		pstmt.setString(4,p.getGender());
		pstmt.executeUpdate();
		System.out.println("Data inserted Successfully");
	} catch (SQLException e) {
		
		e.printStackTrace();
	}	
}
public static boolean checkId(int pid)
{
	String SQL="select *from patient where pid=?";
	boolean status=false;
	try {
		pstmt=getDbConnection().prepareStatement(SQL);
		pstmt.setInt(1, pid);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			status= true;
		}
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	return status;
}

public static void update(Patient p) {
	String SQL = "UPDATE patient SET name = ?, age = ?, gender = ? WHERE pid = ?";
    try {
        pstmt = getDbConnection().prepareStatement(SQL);
        pstmt.setString(1, p.getName());
        pstmt.setInt(2, p.getAge());
        pstmt.setString(3, p.getGender());
        pstmt.setInt(4, p.getPid());
        pstmt.executeUpdate();
        System.out.println("data updated ");
    } 
    catch (SQLException e) {
	
		e.printStackTrace();
	}
}
public static void delete(int id) {
	String SQL = "DELETE FROM patient WHERE pid=?";
	
	 try {
	        pstmt = getDbConnection().prepareStatement(SQL);
	        pstmt.setInt(1, id);
	        pstmt.executeUpdate();
	        System.out.println("data deleted");
	 } catch (SQLException e) {
			
			e.printStackTrace();
		}
}
public  static void viewdata() {
	String SQL="select * from patient;"  ;
	 try {
	        pstmt = getDbConnection().prepareStatement(SQL);
	        ResultSet rs=pstmt.executeQuery();
	        while(rs.next()) {
	        	int pid=rs.getInt(1);
	        	String name=rs.getString(2);
	        	int age=rs.getInt(3);
	        	String gender =rs.getString(4);
	        	System.out.println("id"+pid+" name  "+name+ " age  "+age+ " gender  "+gender);
	        }
	        
	 }
	        catch (SQLException e) {
				
				e.printStackTrace();
			}
	 
	
}

public static ArrayList<Patient> fetchpatient(){
	String SQL ="select * FROM patient";
	ArrayList<Patient> arrpatient= new ArrayList();
	try {
		pstmt=getDbConnection().prepareStatement(SQL);
		
		ResultSet rs=pstmt.executeQuery();
		while (rs.next()){
			int id=rs.getInt(1);
			String name= rs.getString(2);
			int age=rs.getInt(3);
			String gender=rs.getString(4);
			arrpatient.add(new Patient(id,name,age,gender));
		}
	}
	catch (SQLException e) {
			e.printStackTrace();
		}
		return arrpatient;
	}
}





