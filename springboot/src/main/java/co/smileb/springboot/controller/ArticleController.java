package co.smileb.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

import co.smileb.springboot.dto.ArticleForm;
import co.smileb.springboot.entity.Article;
import co.smileb.springboot.repository.ArticleRepository;


@Controller
@Slf4j // 로깅을 위한 골뱅이(어노테이션)
public class ArticleController {
    
    @Autowired // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결!
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {

        // System.out.println(form.toString()); → 로깅기능으로 대체!
        log.info(form.toString());

        // 1. DTO를 변환! Entity!
        Article article = form.toEntity();
        // System.out.println(article.toString());
        log.info(article.toString());

        // // 2. Repository에게 Entity를 DB 안에 저장하게 함!
        Article saved = articleRepository.save(article); 
        // System.out.println(saved.toString());
        log.info(saved.toString());

        return "";
    }
    
}
