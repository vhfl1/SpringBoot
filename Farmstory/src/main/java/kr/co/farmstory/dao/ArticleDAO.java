package kr.co.farmstory.dao;

import kr.co.farmstory.vo.ArticleVO;
import kr.co.farmstory.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleDAO {
    public int insertArticle(ArticleVO vo);
    public int insertFile(FileVO vo);
    public ArticleVO selectArticle(int no);
    public List<ArticleVO> selectArticles();
    public FileVO selectFile(int fno);
    public int updateFileDownload(int fno);
    public void updateArticle(ArticleVO vo);
    public void deleteArticle(String no);
}
