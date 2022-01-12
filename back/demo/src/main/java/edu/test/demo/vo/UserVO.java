package edu.test.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	private int user_id;
	private String user_email;
	private String user_pw;
	private String user_nickname;
	private int user_gender;
	private String user_nationality;
	private int user_age;
	private int user_smoking;
	private int user_vaccine;
	private int user_room;
	private int user_matching;
	private int user_pet;
	private String user_intro;
	private String user_ideal;
	private String user_location;
	private String user_profile;
	private String user_sns;
	
	
}
