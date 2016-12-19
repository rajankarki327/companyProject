package com.service.spring;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.spring.UserSubscriberDao;
import com.model.spring.UserSubscriberModel;

@Service
public class UserSubscriberService {
	private UserSubscriberDao userSubscriberDao;

	public void setUserSubscriberDao(UserSubscriberDao userSubscriberDao) {
		this.userSubscriberDao = userSubscriberDao;
	}

	@Transactional
	public void subscribe(UserSubscriberModel userSubscriberModel)
	{
		 userSubscriberDao.subscribe(userSubscriberModel);
	}
	
}
