package com.zemogaback.interfaces;

import com.zemogaback.dto.UserBackDto;

public interface TwiterUserDataService {

	
	UserBackDto getUserByTwitterUser(String twitterUser) throws Exception;
	
	UserBackDto saveUserByTwitterUser(UserBackDto userDto) throws Exception;
}
