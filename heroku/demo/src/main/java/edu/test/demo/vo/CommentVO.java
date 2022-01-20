package edu.test.demo.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {
	private int comment_id;
	private int comment_id_to;
	private int comment_id_from;
	private String comment_contents;
	private Timestamp comment_time;
	private int comment_access;
	private int comment_status;
}
