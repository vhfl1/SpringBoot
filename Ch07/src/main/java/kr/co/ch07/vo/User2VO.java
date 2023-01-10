package kr.co.ch07.vo;

import org.mybatis.spring.annotation.MapperScan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MapperScan
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User2VO {
	private String uid;
	private String name;
	private String hp;
	private String age;
}
