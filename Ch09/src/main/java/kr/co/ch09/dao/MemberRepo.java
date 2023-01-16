package kr.co.ch09.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.ch09.vo.MemberVO;

@Repository
public interface MemberRepo extends JpaRepository<MemberVO, String>{

	public void insertMember();	
	public void selectMember();	
	public void selectMembers();	
	public void updateMember();	
	public void deleteMember();	
}
