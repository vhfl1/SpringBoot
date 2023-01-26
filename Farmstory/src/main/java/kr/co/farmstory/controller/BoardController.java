package kr.co.farmstory.controller;

import kr.co.farmstory.service.ArticleService;
import kr.co.farmstory.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private ArticleService service;

    @GetMapping("board/list")
    public String list(String group, String cate, Model model){
        List<ArticleVO> articles = service.selectArticles();
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        model.addAttribute("articles", articles);

        return "board/list";
    }

    @GetMapping("board/modify")
    public String modify(String group, String cate, Model model, int no){
        ArticleVO article = service.selectArticle(no);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        model.addAttribute("article", article);

        return "board/modify";
    }

    @PostMapping("board/modify")
    public String modify(ArticleVO vo, String group, String cate, Model model){
        service.updateArticle(vo);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);

        return "redirect:board/list";
    }

    @GetMapping("board/view")
    public String view(int no, String group, String cate, Model model){
        ArticleVO article = service.selectArticle(no);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        model.addAttribute("article", article);

        return "board/view";
    }

    @GetMapping("board/write")
    public String write(String group, String cate, Model model){
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);

        return "board/write";
    }

    @PostMapping("board/write")
    public String write(ArticleVO vo, String group, String cate, Model model){
        service.insertArticle(vo);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);

        return "redirect:board/list";
    }
}
