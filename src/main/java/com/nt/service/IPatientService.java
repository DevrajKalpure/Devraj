package com.nt.service;

import java.util.List;


import com.nt.model.Patient;

public interface IPatientService {
    public List<Patient> fetchpatientByloca(String loca1,String loca2,String Loca3)throws Exception ;

}
