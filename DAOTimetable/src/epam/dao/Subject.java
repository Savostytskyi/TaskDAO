package epam.dao;

import java.util.Date;

public class Subject extends Entity {

	private String title;
	private Date date;
	private String classes;
	
	
	public Subject(int id, String title, Date date, String classes) {
		super(id);
		this.title = title;
		this.date = date;
		this.classes = classes;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getClasses() {
		return classes;
	}


	public void setClasses(String classes) {
		this.classes = classes;
	}


	@Override
	public String toString() {
		return "Subject [title=" + title + ", date=" + date + ", classes="
				+ classes + "]";
	}

	

}
