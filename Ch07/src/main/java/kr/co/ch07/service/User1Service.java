package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.dao.User1DAO;
import kr.co.ch07.vo.User1VO;

@Service
public class User1Service {

	@Autowired
	private User1DAO dao;
	
	public void insertUser(User1VO vo) {
		dao.insertUser1(vo);
	}
	
	public User1VO selectUser(String uid) {
		return dao.selectUser1(uid);
	}
	
	public List<User1VO> selectUsers() {
		return dao.selectUser1s();
	}
	
	public void updateUser(User1VO vo) {
		dao.updateUser1(vo);
	}
	
	public void deleteUser(String uid) {
		dao.deleteUser1(uid);
	}
}
