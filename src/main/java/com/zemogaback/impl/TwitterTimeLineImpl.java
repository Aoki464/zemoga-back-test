package com.zemogaback.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zemogaback.interfaces.TwitterTimeLineService;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

@Service
public class TwitterTimeLineImpl implements TwitterTimeLineService{

	Twitter twitter = new TwitterFactory().getInstance();
	
	@Override
	public List<String> getTweetTimeLine(String screenName, int countTweets) throws TwitterException {
		 
		//User userTwitter = twitter.verifyCredentials();
		ArrayList<String> tweets = new ArrayList<String>();
		
		try {  			
           // String user = userTwitter.getScreenName();
            Paging page = new Paging(1,countTweets);
            List<Status> statuses = twitter.getUserTimeline(screenName, page);           
            for (Status status : statuses) {
                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
                tweets.add("@" + status.getUser().getScreenName() + " - " + status.getText());
            }
        } catch (TwitterException te) {
        	System.out.println("Failed to get timeline: " + te.getMessage());
        	te.printStackTrace();
        }
    		
		return tweets;
	}

}
