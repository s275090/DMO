package model;

import java.util.ArrayList;

public class Exam {
	
	private String id;
    private ArrayList<String> students;

    public Exam(String id) {
        this.id=id;
        this.students = new ArrayList<String>();
    }

	public String getId() {
		return id;
	}

	public ArrayList<String> getStudents() {
		return students;
	}

	public int getNumStudents() {
		return students.size();
	}
    
	public void addStudent(String s) {
		if(!students.contains(s))
			this.students.add(s);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exam other = (Exam) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
    
}
