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

import com.model.spring.TeamModel;


@Repository
public class TeamDao {
	private DataSource dataSource; // used when u use custom query using jdbc

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void uploadImage(TeamModel m) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(m);
	}
	@SuppressWarnings("unchecked")
	public ArrayList<TeamModel> getAllTeam() {
		Session session = this.sessionFactory.getCurrentSession();
		ArrayList<TeamModel> listTeam = (ArrayList<TeamModel>) session.createQuery("from TeamModel").list();
		// for(TeamModel u : personsList){
		// logger.info("Person List::"+u);
		// }
		return listTeam;
	}
	public void deleteTeam(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		TeamModel p = (TeamModel) session.load(TeamModel.class, new Integer(id));
		session.delete(p);
	}
	
	public TeamModel getTeamById(int id) {

		 String sql = "SELECT * FROM team WHERE id = ?";
			
		 Connection conn = null;
		
		 try {
		 conn =dataSource.getConnection();
		 PreparedStatement ps = conn.prepareStatement(sql);
		 ps.setInt(1, id);
		 TeamModel teamModel = null;
		 ResultSet rs = ps.executeQuery();
		 if (rs.next()) {
		 teamModel = new TeamModel(
		 rs.getString("name"),
		 rs.getString("post"),
		 rs.getString("image"),
		 rs.getString("details"),
		 rs.getString("fb_id"),
		 rs.getString("twiter_id")
		 );
		 }
		 rs.close();
		 ps.close();
		 return teamModel;
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

	public void editTeam(TeamModel s) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(s);
	}



}
