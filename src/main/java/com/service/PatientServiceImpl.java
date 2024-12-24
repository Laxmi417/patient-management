package com.service;

import java.util.ArrayList;

import com.daolayer.DAO;
import com.pojo.Patient;

public class PatientServiceImpl implements PatientI {

	@Override
	public void regiter(Patient p) {
		Patient p1= new Patient(p.getPid(), p.getName(), p.getAge(), p.getGender());
		DAO.insertPatientD(p1);
	}

	@Override
	public boolean IsRegisted(Patient p) {
		boolean b= DAO.checkId(p.getPid());
		return b;
	}

	@Override
	public void updateDetails(Patient p) {
		DAO.update(p);
		
		
	}

	@Override
	public void deleteEntry(Patient p) {
		DAO.delete(p.getPid());
		
	}

	@Override
	public void viewData() {
		DAO.viewdata();
		
	}

	@Override
	public ArrayList<Patient> fetchpatientData() throws Exception {
		// TODO Auto-generated method stub
		return DAO.fetchpatient();
	}
	

}