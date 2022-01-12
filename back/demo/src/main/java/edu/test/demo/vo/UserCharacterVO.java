package edu.test.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCharacterVO {
 private int user_id;
 private int cleanliness;
 private int wakeup_time;
 private int sleep_time;
 private int cooking_frequency;
 private int chatter;
 private int snoring;
 private String mbti;
}
