package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Patient;
import com.nt.service.IPatientService;
@Controller("patientController")
public class PatientController {
	
	@Autowired
	private IPatientService patservice;
	
	public List<Patient> processPatienyByLoca(String loca1,String loca2,String Loca3)throws Exception {
		
		List<Patient> list=patservice.fetchpatientByloca(loca1, loca2, Loca3);

		return list;
	}

}
