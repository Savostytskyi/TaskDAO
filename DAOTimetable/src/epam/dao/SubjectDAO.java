package epam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectDAO extends AbstractDAO<Integer, Subject> {
	public static final String SQL_SELECT_ALL_ABONENTS = "SELECT * FROM subject";
	public static final String SQL_SELECT_LECTURER_BY_DATE_ROOM = "SELECT `fullname`, `lectures_num` FROM `subject` as s JOIN `lecturer` as l  ON l.subj_id=s.subj_id WHERE s.date=? AND l.`lectures_num`=?";
	public static final String SQL_SELECT_LECTURER_WEEKENDS = "SELECT `fullname`, `lectures_num` FROM `subject` as s JOIN `lecturer` as l  ON l.subj_id=s.subj_id WHERE s.date!=?";
	public static final String SQL_SELECT_DAY_BY_COUNT = "SELECT `date` AS 'Date', Count(*) AS 'Count' FROM subject GROUP BY `date` HAVING Count=?";
	public static final String SQL_SELECT_DAY_BY_ROOMS = "SELECT `date` AS 'Date', Count(*) AS 'Count' FROM subject GROUP BY `class` HAVING Count=?";
	public static final String SQL_SELECT_BY_DAY = "SELECT `date`,`title` FROM `subject` WHERE `date`=?";
	
	@Override
	public List<Subject> findAll() {
		List<Subject> subj = new ArrayList<>();
		Connection cn = null;
		Statement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = cn.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_ALL_ABONENTS);
			while (rs.next()) {
		
				int id = rs.getInt(1);
				Date date = rs.getDate(3);
				String title = rs.getString(2);
				String classes = rs.getString(4);
				subj.add(new Subject(id, title, date, classes));
			}

		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}


	     
		return subj;
	}

	@Override
	public Subject findEntityById(Integer Id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean delete(Integer Id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean delete(Subject entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean create(Subject entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Subject update(Subject entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> findDateLecturer(Date date, int room) {
		List<String> lect = new ArrayList<>();
		Connection cn = null;
		PreparedStatement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = cn.prepareStatement(SQL_SELECT_LECTURER_BY_DATE_ROOM);	
			st.setDate(1, (java.sql.Date) date);
			st.setInt(2, room);
			ResultSet resultSet = st.executeQuery();
			
			while (resultSet.next()) {
			String fullname = resultSet.getString(1);
				int num = resultSet.getInt(2);
		
				lect.add("Full name = "+fullname+ " Room number = "+Integer.toString(num));
			}

		

		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}

		return lect;
	}
	
	public List<String> findDateByCount(int count) {
		List<String> lect = new ArrayList<>();
		Connection cn = null;
		PreparedStatement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = cn.prepareStatement(SQL_SELECT_DAY_BY_COUNT);	
			st.setInt(1, count);

			ResultSet resultSet = st.executeQuery();
			
			while (resultSet.next()) {
			Date date = resultSet.getDate(1);
				int num = resultSet.getInt(2);
		
			lect.add("Day = "+date+ ", How much lectures = "+Integer.toString(num));

			}

		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}

		return lect;
	}
	
	public List<String> findDateByRoom(int count) {
		List<String> lect = new ArrayList<>();
		Connection cn = null;
		PreparedStatement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = cn.prepareStatement(SQL_SELECT_DAY_BY_ROOMS);	
			st.setInt(1, count);

			ResultSet resultSet = st.executeQuery();
			
			while (resultSet.next()) {
			Date date = resultSet.getDate(1);
				int num = resultSet.getInt(2);
		
			lect.add("Day = "+date+ ", How much classes = "+Integer.toString(num));

			}

		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}

		return lect;
	}
	
	public List<String> findDateRestLect(Date date) {
		List<String> lect = new ArrayList<>();
		Connection cn = null;
		PreparedStatement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = cn.prepareStatement(SQL_SELECT_LECTURER_WEEKENDS);	
			st.setDate(1, (java.sql.Date) date);

			ResultSet resultSet = st.executeQuery();
			
			while (resultSet.next()) {
			String fullname = resultSet.getString(1);
				int num = resultSet.getInt(2);
		
			lect.add("Full name = "+fullname+ ", Room number = "+Integer.toString(num));

			}
		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}
		return lect;
	}
	
	
	public List<String> findByday(Date date) {
		List<String> lect = new ArrayList<>();
		Connection cn = null;
		PreparedStatement st = null;
		try {
			cn = ConnectorDB.getConnection();
			st = cn.prepareStatement(SQL_SELECT_BY_DAY);	
			st.setDate(1, (java.sql.Date) date);

			ResultSet resultSet = st.executeQuery();
			
			while (resultSet.next()) {
				Date date1 = resultSet.getDate(1);
			String title = resultSet.getString(2);
	
		
			lect.add("DAY = "+date1+ ", Title = "+title);

			}
		} catch (SQLException e) {
			System.err.println("SQL Exeption (request or table failed):" + e);
		}
		lect.add(lect.get(0));
		lect.remove(0);
		return lect;
	}


}
