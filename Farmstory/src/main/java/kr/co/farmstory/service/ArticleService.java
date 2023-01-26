package kr.co.farmstory.service;

import kr.co.farmstory.dao.ArticleDAO;
import kr.co.farmstory.vo.ArticleVO;
import kr.co.farmstory.vo.FileVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class ArticleService {
    @Autowired
    private ArticleDAO dao;

    public int insertArticle(ArticleVO vo) {
        //글 등록
        int result = dao.insertArticle(vo);
        //파일 업로드
        FileVO fvo = fileUpload(vo);
        //파일 등록
        if (fvo != null) {
            dao.insertFile(fvo);
        }

        return result;
    }

    public ArticleVO selectArticle(int no) {
        return dao.selectArticle(no);
    }

    public List<ArticleVO> selectArticles() {
        return dao.selectArticles();
    }

    public void updateArticle(ArticleVO vo) {
        dao.updateArticle(vo);
    }

    public void deleteArticle(String no) {
        dao.deleteArticle(no);
    }


    //파일 업로드
    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    public ResponseEntity<Resource> fileDownload(FileVO vo) throws IOException {
        Path path = Paths.get(uploadPath + "/" + vo.getNewName());
        log.info("path :" + path);

        String contentType = Files.probeContentType(path);
        log.info("contentType :" + contentType);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition
                .builder("attachment")
                .filename(vo.getOriName(), StandardCharsets.UTF_8)
                .build());

        headers.add(HttpHeaders.CONTENT_TYPE, contentType);

        Resource resource = new InputStreamResource(Files.newInputStream(path));

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    public FileVO fileUpload(ArticleVO vo) {
        //첨부파일
        MultipartFile file = vo.getFname();
        FileVO fvo = null;

        if (!file.isEmpty()) {
            //시스템 경로
            String path = new File(uploadPath).getAbsolutePath();

            //새 파일명 생성
            String oName = file.getOriginalFilename();
            String ext = oName.substring(oName.lastIndexOf("."));
            String nName = UUID.randomUUID().toString() + ext;

            //파일저장
            try {
                file.transferTo(new File(path, nName));
            } catch (IllegalStateException e) {
                log.error(e.getMessage());
            } catch (IOException e) {
                log.error(e.getMessage());
            }

            fvo = FileVO.builder()
                    .parent(vo.getNo())
                    .oriName(oName)
                    .newName(nName)
                    .build();

        }
        return fvo;
    }






}





































