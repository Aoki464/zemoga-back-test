package com.zemogaback.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import com.zemogaback.dto.UserBackDto;


@SqlResultSetMappings({
	@SqlResultSetMapping(name="UserDtoResultPortfolio",
	classes = @ConstructorResult(
            targetClass = UserBackDto.class,
            columns = {
                @ColumnResult(name = "id", type = Long.class),
                @ColumnResult(name = "experience", type = String.class),  
                @ColumnResult(name = "description", type = String.class), 
                @ColumnResult(name = "name", type = String.class),
                @ColumnResult(name = "email", type = String.class),
                @ColumnResult(name = "address", type = String.class),
                @ColumnResult(name = "phone", type = String.class),
                @ColumnResult(name = "zipCode", type = String.class),
                @ColumnResult(name = "twitterUser", type = String.class),
                @ColumnResult(name = "imagePath", type = String.class)
                }
            )
		)
	})
/*@NamedQueries({
	@NamedQuery(name  =  "user.getUserByTwitterUser",
	query =  Constants.FIND_BY_TWITTER_NAME),
})*/

@Entity
@Table(schema = "PortfolioDB",name="portfolio")
public class UserBack implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idportfolio")
	private Long id;
	
	@Column(name="experience")
	private String experience;
	
	@Column(name="description")
	private String description;
	
	/*@Column(name="imagePath")
	private String image;*/
	
	@Column(name="name")
	private String name;
	
	/*@Column(name="twitterUser")
	private String userName;*/
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone")
	private String phone;
	
	/*@Column(name="zipCode")
	private String zipCode;*/
	
	@Column(name="image_path")
	private String imagePath;
	
	@Column(name="twitter_user_name")
	private String twitterUser;
	
	@Column(name="zip_Code")
	private String zipCode;
	
	public UserBack() {
		super();
	}
	
	public UserBack(UserBackDto userDto) {
		this.id = userDto.getId();
		this.experience = userDto.getExperience();
		this.name = userDto.getName();
		this.email = userDto.getEmail();
		this.address = userDto.getAddress();
		this.phone = userDto.getPhone();
		this.imagePath = userDto.getImagePath();
		this.twitterUser = userDto.getTwitterUser();
		this.zipCode = userDto.getZipCode();	
		this.description = userDto.getDescription();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	/*public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}*/

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

	/*public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}*/

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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
