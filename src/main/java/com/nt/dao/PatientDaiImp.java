package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.model.Patient;
@Repository
@Profile({"Dev"})
public class PatientDaiImp implements IPatientDAO {

	private static final String GET_PATIENT_BY_LOCA="SELECT PNO,NAME,AGE,GENDER,LOCATION,DEPARTMENT FROM HOSPITAL WHERE LOCATION IN(?,?,?)";

	
	  @Autowired private DataSource ds;
	 
	
	@Override
	public List<Patient> getpatientbyloca(String loca1, String loca2, String Loca3) throws Exception {
				
		

		ArrayList<Patient> list = null;
		try(
			Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(GET_PATIENT_BY_LOCA);	
			){
			ps.setString(1, loca1);
			ps.setString(2, loca2);
			ps.setString(3, Loca3);
		
		try(
			ResultSet rs=ps.executeQuery();){
			
			list =new ArrayList<Patient>();
			while(rs.next()) {
				Patient p1=new Patient();
			    p1.setPNO(rs.getInt(1));
				p1.setName(rs.getString(2));
				p1.setAge(rs.getInt(3));
				p1.setGender(rs.getString(4));
				p1.setLocation(rs.getString(5));
				p1.setDepartment(rs.getString(6));
				

				list.add(p1);
			}
		}
	}
		catch (SQLException se) {
			System.out.println("Wait for some problem");
			throw se;
		}
		catch (Exception e) {
			System.out.println("Wait for some problem");
			throw e;
		}
			
		return list;
	}

}
