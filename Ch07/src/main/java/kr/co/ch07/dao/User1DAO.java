package kr.co.ch07.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ch07.vo.User1VO;

@Mapper
@Repository
public interface User1DAO {

	public void insertUser1(User1VO vo);
	public User1VO selectUser1(String uid);
	public List<User1VO> selectUser1s();
	public void updateUser1(User1VO vo);
	public void deleteUser1(String uid);
	
}
