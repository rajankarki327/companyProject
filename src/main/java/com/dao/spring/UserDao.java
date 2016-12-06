package com.dao.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
//
//import javax.sql.DataSource;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.model.spring.UserModel;

@Repository
public class UserDao {
	private DataSource dataSource; // used when u use custom query using jdbc

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addUser(UserModel userModel) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(userModel);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<UserModel> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		ArrayList<UserModel> listUsers = (ArrayList<UserModel>) session.createQuery("from UserModel").list();
		// for(UserModel u : personsList){
		// logger.info("Person List::"+u);
		// }
		return listUsers;
	}

	public void deleteUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		UserModel p = (UserModel) session.load(UserModel.class, new Integer(id));
		session.delete(p);
	}

	public UserModel getUserById(int id) {

//		Session session = this.sessionFactory.getCurrentSession();
//		UserModel s = (UserModel) session.createQuery("from UserModel where id="+id);
//		return s;

		 String sql = "SELECT * FROM user WHERE id = ?";
		
		 Connection conn = null;
		
		 try {
		 conn =dataSource.getConnection();
		 PreparedStatement ps = conn.prepareStatement(sql);
		 ps.setInt(1, id);
		 UserModel userModel = null;
		 ResultSet rs = ps.executeQuery();
		 if (rs.next()) {
		 userModel = new UserModel(
		 rs.getString("name"),
		 rs.getString("username"),
		 rs.getString("email"),
		 rs.getString("address"),
		 rs.getString("password")
		 );
		 }
		 rs.close();
		 ps.close();
		 return userModel;
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

	public void editUser(UserModel s) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(s);
	}

	public UserModel checkLogin(UserModel s) {
		String sql = "SELECT * FROM user WHERE email = ? AND password=?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getEmail());
			ps.setString(2, s.getPassword());
			UserModel userModel = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next() == true) {
				return s;
			}
			rs.close();
			ps.close();
			return userModel;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}
