package com.zemogaback.controllers;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zemogaback.interfaces.TwitterTimeLineService;

@RestController
@RequestMapping("timeLine")
@CrossOrigin(origins = "http://localhost:4200")
public class TwitterTimeLineController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public TwitterTimeLineService twitterTimeLineService;
	
	TwitterTimeLineController(TwitterTimeLineService twitterTimeLineService) {
        this.twitterTimeLineService = twitterTimeLineService;
    }
	
	@GetMapping
	@Transactional
	public ResponseEntity<List<String>> get(@RequestParam(required=true, value= "twitterUser") String twitterUser,
										@RequestParam(required=true, value= "countTweets") int countTweets){
		System.out.println(twitterUser);
		try {
			List<String> result = null;
			ResponseEntity<List<String>> res;
			if(Objects.nonNull(twitterUser)) {				
				 result = twitterTimeLineService.getTweetTimeLine(twitterUser, countTweets);
			} else {
				res = new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
				return res;
			}			
			
			 if(Objects.isNull(result)) {
				 res = new ResponseEntity<List<String>>(result ,HttpStatus.NO_CONTENT);
				 return res;
			 } else {
				res = new ResponseEntity<List<String>>(result ,HttpStatus.OK);
				return res;
			 }			
			
		}catch(Exception ex) {
			ResponseEntity<List<String>> res = new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
			ex.printStackTrace();
			return res;
		}		
	}

}
