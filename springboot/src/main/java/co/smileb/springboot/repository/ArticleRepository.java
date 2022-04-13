package co.smileb.springboot.repository;

import co.smileb.springboot.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    

}