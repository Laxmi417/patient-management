package com.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.pojo.Patient;
import com.service.PatientServiceImpl;

public class PatientController {
	public static void main(String[] args) {
		PatientServiceImpl pp = new PatientServiceImpl();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 for registration \n Enter 2 to check Entry \n Enter 3 to fecth Entry \n enter 4 to update details \n Enter 5 to delete paitent \n Enter 6 to view data");
		int n=sc.nextInt();
		do
		{
			switch (n) {
			case 1:
				
				System.out.println("Enter Patients id,name,age,gender");
				Patient p = new Patient(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
				pp.regiter(p);
				break;
			case 2:
				System.out.println("Enter Patients id");
				Patient p1 = new Patient(sc.nextInt());
				if(pp.IsRegisted(p1)) {
					System.out.println("patient already exist");
				}
				else
				{
					System.out.println("please enter details");
					System.out.println("Enter patient id,name,age,gender");
					Patient newPatient= new Patient(sc.nextInt(),sc.next(),sc.nextInt(),sc.next());
					pp.regiter(newPatient);
				}
				
				break;
				
			case 3:
				try {
					ArrayList<Patient> a1= pp.fetchpatientData();
					for (Patient patient : a1) {
						System.out.println(patient);
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
			case 4:
				System.out.println("enter patient id   to update");
				Patient update = new Patient(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
				pp.updateDetails(update);
			
			
			case 5:
				System.out.println("enter patient id to delete ");
				Patient delete = new Patient(sc.nextInt());
				pp.deleteEntry(delete);
					
			case 6:
				System.out.println("data ");
				pp.viewData();
			}	
		}while(n!=6);

	}
}
