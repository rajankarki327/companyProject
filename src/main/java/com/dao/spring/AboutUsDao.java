package com.dao.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.spring.AboutUsModel;

public class AboutUsDao {

	private DataSource dataSource; // used when u use custom query using jdbc

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addAboutUsField(AboutUsModel aboutUsModel) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(aboutUsModel);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<AboutUsModel> getAllAboutUsField() {
		Session session = this.sessionFactory.getCurrentSession();
		ArrayList<AboutUsModel> listAboutUs = (ArrayList<AboutUsModel>) session.createQuery("from AboutUsModel").list();
		// for(AboutUsModel u : personsList){
		// logger.info("Person List::"+u);
		// }
		return listAboutUs;
	}

	public void deleteAboutUsField(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		AboutUsModel p = (AboutUsModel) session.load(AboutUsModel.class, new Integer(id));
		session.delete(p);
	}

	public AboutUsModel getAboutUsById(int id) {

//		Session session = this.sessionFactory.getCurrentSession();
//		AboutUsModel s = (AboutUsModel) session.createQuery("from AboutUsModel where id="+id);
//		return s;

		 String sql = "SELECT * FROM aboutUs WHERE id = ?";
		
		 Connection conn = null;
		
		 try {
		 conn =dataSource.getConnection();
		 PreparedStatement ps = conn.prepareStatement(sql);
		 ps.setInt(1, id);
		 AboutUsModel aboutUsModel = null;
		 ResultSet rs = ps.executeQuery();
		 if (rs.next()) {
		 aboutUsModel = new AboutUsModel(
		 rs.getString("title"),
		 rs.getString("details")
		 
		 );
		 }
		 rs.close();
		 ps.close();
		 return aboutUsModel;
		 } catch (SQLException e) {
		 throw new RuntimeException(e);
		 } finally {
		 if (conn != null) {
		 try {
		 conn.close();
		 } catch (SQLException e) {}
		 }
		 }
	}

	public void editAboutUsField(AboutUsModel s) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(s);
	}

	
}
