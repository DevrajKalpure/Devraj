package com.nt.dao;

import java.util.List;

import com.nt.model.Patient;

public interface IPatientDAO {
    public List<Patient> getpatientbyloca (String loca1,String loca2,String Loca3)throws Exception ;
		
}