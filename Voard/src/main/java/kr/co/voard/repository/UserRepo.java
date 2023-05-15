package kr.co.voard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.voard.repository.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, String>{
	
	public int countByUid(String uid);

}
