package epam.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainDao {
	public static void main(String[] args) {
		     SubjectDAO subj= new SubjectDAO();
		     subj.findAll();
		     
		     SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		        Date parsed;
				try {
					parsed = format.parse("20150406");
					   java.sql.Date sql = new java.sql.Date(parsed.getTime());
					    
					  System.out.println("Quary 1: "+subj.findDateLecturer(sql, 205));
					  System.out.println("Quary 2: "+subj.findDateRestLect(sql));
					  System.out.println("Quary 5: "+subj.findByday(sql));
					  
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				 System.out.println("Quary 3: "+subj.findDateByCount(2));
				 System.out.println("Quary 4: "+subj.findDateByRoom(1));
		     System.out.println(subj.findAll());

		}


}
