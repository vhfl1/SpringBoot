package kr.co.ch07.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User4VO {
	private String seq;
	private String name;
	private String gender;
	private String age;
	private String addr;
	
}
