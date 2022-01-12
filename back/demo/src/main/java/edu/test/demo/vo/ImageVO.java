package edu.test.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageVO {
	private int image_id;
	private int user_id;
	private String image_address;
}
