package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.dao.User6DAO;
import kr.co.ch07.repository.User6Repo;
import kr.co.ch07.vo.User6VO;

@Service
public class User6Service {

	@Autowired
	private User6DAO dao;
	
	@Autowired
	private User6Repo repo;
	
	public void insertUser6(User6VO vo){
		//Mybatis
		//dao.insertUser6(vo);
	
		//JPA
		repo.save(vo);
	}
	public User6VO selectUser6(String uid){
		//Mybatis
		//User6VO user = dao.selectUser6(uid);
		
		//JPA
		User6VO user = repo.findById(uid).get();
		
		return user;
	}
	public List<User6VO> selectUser6s(){
		//Mybatis
		//List<User6VO> users = dao.selectUser6s();
		
		//JPA
		List<User6VO> users = repo.findAll();
		
		return users;
	}
	public void updateUser6(User6VO vo){
		//Mybatis
		//dao.updateUser6(vo);
	
		//JPA
		repo.save(vo);
	}
	public void deleteUser6(String uid){
		//Mybatis
		//dao.deleteUser6(uid);
	
		//JPA
		repo.deleteById(uid);
	}
}
