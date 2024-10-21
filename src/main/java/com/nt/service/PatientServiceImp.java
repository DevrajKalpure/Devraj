package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IPatientDAO;

import com.nt.model.Patient;
@Service
public class PatientServiceImp implements IPatientService {


	@Autowired
	private IPatientDAO dao;
	
	@Override
	public List<Patient> fetchpatientByloca(String loca1, String loca2, String Loca3) throws Exception {
		
		/*
		 * loca1=1.toUpperCase(); desg2=desg2.toUpperCase(); desg3=desg3.toUpperCase();
		 */
			List<Patient> list=dao.getpatientbyloca(loca1, loca2, Loca3);
			
			return list;
		
	}



}
