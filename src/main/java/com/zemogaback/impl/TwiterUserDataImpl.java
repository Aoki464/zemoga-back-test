package com.zemogaback.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemogaback.dao.IGenericDao;
import com.zemogaback.dto.UserBackDto;
import com.zemogaback.entities.UserBack;
import com.zemogaback.interfaces.TwiterUserDataService;
import com.zemogaback.utils.Constants;

//import twitter4j.*;
@Service
public class TwiterUserDataImpl implements TwiterUserDataService{

	//Twitter twitter = new TwitterFactory().getInstance();
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	IGenericDao<UserBack> userRepository;
	
	@Autowired
	public void setDaoUser( IGenericDao< UserBack > daoToSet ){
		userRepository = daoToSet;
		userRepository.setClazz(UserBack.class);
	}
	
	@Override
	public UserBackDto getUserByTwitterUser(String twitterUser) throws Exception {
	
		List<UserBackDto> findByNamedQuery = userRepository.<UserBackDto>findByNativeQuery(Constants.FIND_BY_TWITTER_NAME, 
				"UserDtoResultPortfolio",
				new ArrayList<String>(Arrays.asList("twitterUser")), null, twitterUser);
		
		if(findByNamedQuery.size() > 0 ) {
			UserBackDto user = findByNamedQuery.get(0);	
			return user;
		} else {
			return null;
		}		
	}

	@Override
	public UserBackDto saveUserByTwitterUser(UserBackDto userDto) throws Exception {
		// TODO Auto-generated method stub
		try {
			UserBack userToSave = new UserBack(userDto);			
			userRepository.save(userToSave);
			userRepository.flush();			
			return new UserBackDto(userToSave);
		} catch (Exception e) {
			logger.error(e.getCause().getMessage());
			e.printStackTrace();
			throw new Exception();
		}		
	}

}
