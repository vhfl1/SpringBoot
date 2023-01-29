package kr.co.farmstory.controller;

import kr.co.farmstory.service.ArticleService;
import kr.co.farmstory.vo.ArticleVO;
import kr.co.farmstory.vo.FileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private ArticleService service;

    @GetMapping("board/list")
    public String list(String group, String cate, Model model, String pg){
        int currentPage = service.getCurrentPage(pg);
        int start = service.getLimitStart(currentPage);

        int total = service.selectCountTotal();
        int lastPageNum = service.getLastPageNum(total);
        int pageStartNum = service.getPageStartNum(total, start);
        int groups[] = service.getPageGroup(currentPage, lastPageNum);

        List<ArticleVO> articles = service.selectArticles(start);

        model.addAttribute("group", group);
        model.addAttribute("groups", groups);
        model.addAttribute("cate", cate);
        model.addAttribute("articles", articles);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("pageStartNum", pageStartNum);

        return "board/list";
    }

    @GetMapping("board/modify")
    public String modify(String group, String cate, Model model, int no){
        ArticleVO article = service.selectArticle(no);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        model.addAttribute("no", no);
        model.addAttribute("article", article);

        return "board/modify";
    }

    @PostMapping("board/modify")
    public String modify(ArticleVO vo, String group, String cate, Model model){
        service.updateArticle(vo);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);

        return "redirect:list?group="+group+"&cate="+cate;
    }

    @GetMapping("board/view")
    public String view(int no, String group, String cate, Model model){
        ArticleVO article = service.selectArticle(no);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        model.addAttribute("article", article);

        service.updateArticleHit(no);

        return "board/view";
    }

    public ResponseEntity<Resource> download(int fno) throws IOException {
        //파일 조회
        FileVO vo = service.selectFile(fno);

        //파일 다운로드 카운트 증가
        service.updateFileDownload(fno);

        //파일 다운로드
        ResponseEntity<Resource> respEntity = service.fileDownload(vo);

        return respEntity;
    }

    @GetMapping("board/write")
    public String write(String group, String cate, Model model){
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);

        return "board/write";
    }

    @PostMapping("board/write")
    public String write(ArticleVO vo, String group, String cate, Model model, HttpServletRequest req){
        String regip = req.getRemoteAddr();
        vo.setRegip(regip);

        service.insertArticle(vo);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);

        return "redirect:list?group="+group+"&cate="+cate;
    }

}
