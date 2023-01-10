package kr.co.ch07.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.ch07.vo.User4VO;

@Mapper
@Repository
public interface User4DAO {
	public void insertUser4(User4VO vo);
	public User4VO selectUser4(String uid);
	public List<User4VO> selectUser4s();
	public void updateUser4(User4VO vo);
	public void deleteUser4(String uid);
}
