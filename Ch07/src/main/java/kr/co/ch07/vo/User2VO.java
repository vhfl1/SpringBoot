package kr.co.ch07.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.mybatis.spring.annotation.MapperScan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="user2")
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User2VO {
	
	@Id
	private String uid;
	private String name;
	private String hp;
	private String age;
}
