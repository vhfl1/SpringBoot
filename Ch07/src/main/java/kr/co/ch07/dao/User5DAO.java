package kr.co.ch07.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ch07.vo.User5VO;

@Mapper
@Repository
public interface User5DAO {
	
	public void insertUser5(User5VO vo);
	public User5VO selectUser5(String uid);
	public List<User5VO> selectUser5s();
	public void updateUser5(User5VO vo);
	public void deleteUser5(String uid);
}
