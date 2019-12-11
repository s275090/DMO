package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Model {
	
	private int numTimeSlots;
	private int[][] population;
	private Integer[][] nEe;
	private ArrayList<Exam> Exams;
	private HashSet<String> Students;
	
	
	public Model() {
		super();
		this.numTimeSlots = 0;
		Exams = new ArrayList<Exam>();
		Students = new HashSet<String>();
	}	
	
	public boolean loadSlo(String file) {
		
		try {

			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String st;

			while ((st = br.readLine()) != null) {
				this.numTimeSlots = Integer.parseInt(st);
			}

			br.close();
			System.out.println("Numero time slots " + numTimeSlots);
			
			return true;

		} catch (IOException e) {
			System.err.println("Errore nella lettura del file");
			return false;
		}
	}
	
	public boolean loadStu(String file) {
		
		try {

			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String st;

			while ((st = br.readLine()) != null) {
				String[] parts = st.split(" ");
				String idExam = parts[0];
	            String idStudent = parts[1];
	            
	            Exam e = new Exam(idExam);
	            Students.add(idStudent);
	            
	            if(!this.Exams.contains(e)) {
	            	e.addStudent(idStudent);
	            	this.Exams.add(e);
	            } else {
	            	this.Exams.get(this.Exams.indexOf(e)).addStudent(idStudent);
	            } 	
	            
			}
			

			br.close();
			System.out.println("Numero esami " + Exams.size() + "\nNumero Studenti " + Students.size());
			
			return true;

		} catch (IOException e) {
			System.err.println("Errore nella lettura del file");
			return false;
		}
	}
	
	public void buildNeEMatrix() {
		
		this.nEe = new Integer[Exams.size()][Exams.size()];
		ArrayList<String> eList, EList;
		
		for(Exam e : Exams){
			for(Exam E : Exams) {
				if(!e.equals(E)) {
					eList = new ArrayList<>(e.getStudents());
					EList = new ArrayList<>(E.getStudents());
					eList.retainAll(EList);
					
					nEe[Exams.indexOf(e)][Exams.indexOf(E)] = eList.size();
				}
			}
		}
		
		for (Integer[] row : nEe)  
            // converting each row as string 
            // and then printing in a separate line 
            System.out.println(Arrays.toString(row));
		
	}

}
