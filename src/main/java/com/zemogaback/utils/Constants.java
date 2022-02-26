package com.zemogaback.utils;

/**
 * Clase usada para almacenar constantes de la aplicación.
 * 
 * @author Nicolas Montoya - desarrolloingenieria14@udea.edu.co 
 * @version 1.0
 * @since JDK 1.8
 * 
 *
 */
public final class Constants {
	public static final String SUCCESS_MESSAGE = "Correcto";
	/*public static final String FIND_BY_TWITTER_NAME = "Select u from User u " + 
			 " where u.twitterUser = :twitterUser ";*/
	/*public static final String FIND_BY_TWITTER_NAME = "Select new com.zemogaback.dto.UserDto(u) from User u " + 
			 " where u.twitterUser = :twitterUser "*/;
			 public static final String FIND_BY_TWITTER_NAME = "SELECT \r\n" + 
			 		"p.idportfolio id,\r\n" + 
			 		"p.experience experience,\r\n" + 
			 		"p.description description,\r\n" + 
			 		"p.name name,\r\n" + 
			 		"p.email email,\r\n" + 
			 		"p.address address,\r\n" + 
			 		"p.phone phone, \r\n" + 
			 		"p.zip_code zipCode,\r\n" + 
			 		"p.twitter_user_name twitterUser,\r\n" + 
			 		"p.image_path imagePath\r\n" + 
			 		"FROM zemoga_test_db.portfolio p where p.twitter_user_name = :twitterUser";
}
