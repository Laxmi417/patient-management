package com.service;

import java.util.ArrayList;

import com.pojo.Patient;

public interface PatientI {
public void regiter(Patient p);
public boolean IsRegisted(Patient p);
public void updateDetails(Patient p);
public void deleteEntry(Patient p);
public void viewData(); 
public ArrayList<Patient> fetchpatientData () throws Exception;
}
