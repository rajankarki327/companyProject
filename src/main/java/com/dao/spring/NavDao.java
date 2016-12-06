package com.dao.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.model.spring.NavModel;

@Repository
public class NavDao {
		private DataSource dataSource; // used when u use custom query using jdbc

		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
		}

		private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sf) {
			this.sessionFactory = sf;
		}

		public void addNavField(NavModel navModel) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(navModel);
		}

		@SuppressWarnings("unchecked")
		public ArrayList<NavModel> getAllNavField() {
			Session session = this.sessionFactory.getCurrentSession();
			ArrayList<NavModel> listNav = (ArrayList<NavModel>) session.createQuery("from NavModel").list();
			// for(NavModel u : personsList){
			// logger.info("Person List::"+u);
			// }
			return listNav;
		}

		public void deleteNavField(int id) {
			Session session = this.sessionFactory.getCurrentSession();
			NavModel p = (NavModel) session.load(NavModel.class, new Integer(id));
			session.delete(p);
		}

		public NavModel getNavById(int id) {

//			Session session = this.sessionFactory.getCurrentSession();
//			NavModel s = (NavModel) session.createQuery("from NavModel where id="+id);
//			return s;

			 String sql = "SELECT * FROM nav WHERE id = ?";
			
			 Connection conn = null;
			
			 try {
			 conn =dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setInt(1, id);
			 NavModel navModel = null;
			 ResultSet rs = ps.executeQuery();
			 if (rs.next()) {
			 navModel = new NavModel(
			 rs.getString("navField")
			 
			 );
			 }
			 rs.close();
			 ps.close();
			 return navModel;
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

		public void editNavField(NavModel s) {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(s);
		}

	
	}
