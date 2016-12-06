package com.dao.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.model.spring.SliderModel;
import com.model.spring.SliderModel;
import com.model.spring.SliderModel;

@Repository
public class SliderDao {
	private DataSource dataSource; // used when u use custom query using jdbc

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void uploadImage(SliderModel m) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(m);
	}
	@SuppressWarnings("unchecked")
	public ArrayList<SliderModel> getAllSlider() {
		Session session = this.sessionFactory.getCurrentSession();
		ArrayList<SliderModel> listSlider = (ArrayList<SliderModel>) session.createQuery("from SliderModel").list();
		// for(SliderModel u : personsList){
		// logger.info("Person List::"+u);
		// }
		return listSlider;
	}
	public void deleteSlider(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SliderModel p = (SliderModel) session.load(SliderModel.class, new Integer(id));
		session.delete(p);
	}
	
	public SliderModel getSliderById(int id) {

		 String sql = "SELECT * FROM slider WHERE id = ?";
			
		 Connection conn = null;
		
		 try {
		 conn =dataSource.getConnection();
		 PreparedStatement ps = conn.prepareStatement(sql);
		 ps.setInt(1, id);
		 SliderModel sliderModel = null;
		 ResultSet rs = ps.executeQuery();
		 if (rs.next()) {
		 sliderModel = new SliderModel(
		 rs.getString("sliderName")
		 );
		 }
		 rs.close();
		 ps.close();
		 return sliderModel;
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

	public void editSlider(SliderModel s) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(s);
	}



}
