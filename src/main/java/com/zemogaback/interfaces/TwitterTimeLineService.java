package com.zemogaback.interfaces;

import java.util.List;

import twitter4j.TwitterException;

public interface TwitterTimeLineService {
	
	List<String> getTweetTimeLine(String screenName, int countTweets) throws TwitterException;

}
