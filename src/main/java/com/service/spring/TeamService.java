package com.service.spring;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.spring.TeamDao;
import com.model.spring.TeamModel;

@Service
public class TeamService {

	private TeamDao teamDao;


	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}


	@Transactional
	public void uploadImage(TeamModel s) {
		this.teamDao.uploadImage(s);
	}
	
	@Transactional
	public ArrayList<TeamModel> getAllTeam() {
		return (ArrayList<TeamModel>) this.teamDao.getAllTeam();
	}
	
	@Transactional
	public void deleteTeam(int i)
	{
		this.teamDao.deleteTeam(i);
	}
	@Transactional
	public TeamModel getTeamById(int id) {
		return this.teamDao.getTeamById(id);
	}
	
	@Transactional
	public void editTeam(TeamModel i)
	{
		this.teamDao.editTeam(i);
	}


}
