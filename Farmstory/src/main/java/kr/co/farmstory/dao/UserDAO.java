package kr.co.farmstory.dao;

import kr.co.farmstory.vo.TermsVO;
import kr.co.farmstory.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDAO {
    public int insertUser(UserVO vo);
    public void selectUser();
    public void selectUsers();
    public void updateUser();
    public void deleteUser();
    public TermsVO selectTerms();
}
