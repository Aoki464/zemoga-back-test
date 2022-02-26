package com.zemogaback.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.zemogaback.entities.UserBack;

@JsonInclude(Include.NON_NULL)
public class UserBackDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String description;
	private String experience;
	//private String image;
	private String name;
	//private String userName;
	private String email;
	private String address;	
	private String phone;
	private String imagePath;
	private String twitterUser;
	private String zipCode;
	//private String zipCodeAux;
		
	public UserBackDto() {super();}
	
	public UserBackDto(UserBack user) {
		this.id = user.getId();		
		this.experience = user.getExperience();
		this.description = user.getDescription();
		this.name = user.getName();
		this.email = user.getEmail();
		this.address = user.getAddress();
		this.phone = user.getPhone();
		this.imagePath = user.getImagePath();
		this.twitterUser = user.getTwitterUser();
		this.zipCode = user.getZipCode();				
	}
	
	public UserBackDto(Long id, String experience, String description, String name, 
			String email, String address, 
			String phone, String zipCode, 
			String twitterUser,String imagePath) {
		
		this.id = id;
		this.experience = experience;
		this.description = description;
		this.name = name;			
		this.email = email;
		this.address = address;
		this.phone = phone;		
		this.zipCode = zipCode;		
		this.twitterUser = twitterUser;
		this.imagePath = imagePath;
		
	
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}*/


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}

	/*public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getTwitterUser() {
		return twitterUser;
	}

	public void setTwitterUser(String twitterUser) {
		this.twitterUser = twitterUser;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*public String getZipCodeAux() {
		return zipCodeAux;
	}

	public void setZipCodeAux(String zipCodeAux) {
		this.zipCodeAux = zipCodeAux;
	}*/
	
	

}
