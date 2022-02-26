package com.zemogaback.controllers;

import java.util.Objects;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zemogaback.dto.UserBackDto;
import com.zemogaback.interfaces.TwiterUserDataService;

@RestController
@RequestMapping("user")
public class TwitterUserDataController {
	
	@Autowired
	public TwiterUserDataService twitterUserDataService;
	
	TwitterUserDataController(TwiterUserDataService twitterUserDataService) {
	        this.twitterUserDataService = twitterUserDataService;
	    }
	
	@GetMapping
	@Transactional
	public ResponseEntity<UserBackDto> get(@RequestParam(required=false, value= "twitterUser") String twitterUser){
		System.out.println(twitterUser);
		try {
			UserBackDto result = null;
			ResponseEntity<UserBackDto> res;
			if(Objects.nonNull(twitterUser) && !twitterUser.equals("")) {
				result = twitterUserDataService.getUserByTwitterUser(twitterUser);
			} else {
				res = new ResponseEntity<UserBackDto>(HttpStatus.BAD_REQUEST);
				return res;
			}			
			
			 if(Objects.isNull(result)) {
				 res = new ResponseEntity<UserBackDto>(result ,HttpStatus.NO_CONTENT);
				 return res;
			 } else {
				res = new ResponseEntity<UserBackDto>(result ,HttpStatus.OK);
				return res;
			 }			
			
		}catch(Exception ex) {
			ResponseEntity<UserBackDto> res = new ResponseEntity<UserBackDto>(HttpStatus.BAD_REQUEST);
			ex.printStackTrace();
			return res;
		}		
	}	
	
	@PostMapping
	@ResponseBody
	@Transactional
	public ResponseEntity<UserBackDto> post(@RequestBody UserBackDto userDto){
		
		try {			
			ResponseEntity<UserBackDto> res;
			UserBackDto result = twitterUserDataService.saveUserByTwitterUser(userDto);			
			res = new ResponseEntity<UserBackDto>(result, HttpStatus.OK);		
			return res;
		}catch(Exception ex) {
			ResponseEntity<UserBackDto> res = new ResponseEntity<UserBackDto>(HttpStatus.BAD_REQUEST);
			return res;
		}
	}
}
