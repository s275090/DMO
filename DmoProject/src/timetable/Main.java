package timetable;

import model.Model;

public class Main {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		model.loadSlo("test.slo");
		model.loadStu("test.stu");
		model.buildNeEMatrix();
	}

}
