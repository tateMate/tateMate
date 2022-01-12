package edu.test.demo.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NicknamedCocommentVO {
	private int cocomment_id;
	private int comment_id;
	private int cocomment_id_from;
	private String cocomment_nickname_from;
	private String cocomment_contents;
	private Timestamp cocomment_time;
	private int cocomment_status;
	private int cocomment_access;
}
