package epam.dao;

public class Lecturer extends Entity {

	private String fullname;
	private int lecturesnum;
	private int studentsnum;
	
	public Lecturer(int id, String fullname, int lecturesnum, int studentsnum) {
		super(id);
		this.fullname = fullname;
		this.lecturesnum = lecturesnum;
		this.studentsnum = studentsnum;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getLecturesnum() {
		return lecturesnum;
	}

	public void setLecturesnum(int lecturesnum) {
		this.lecturesnum = lecturesnum;
	}

	public int getStudentsnum() {
		return studentsnum;
	}

	public void setStudentsnum(int studentsnum) {
		this.studentsnum = studentsnum;
	}

	@Override
	public String toString() {
		return "Lecturer [fullname=" + fullname + ", lecturesnum="
				+ lecturesnum + ", studentsnum=" + studentsnum + "]";
	}
	
	
	
}
