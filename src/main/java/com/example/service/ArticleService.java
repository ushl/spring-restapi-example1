package com.example.service;

import com.example.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService {

    Page<Article> findAll(Pageable pageable);

    Article findOne(Integer id);

    Article create(Article article);

    Article update(Article article);

    void delete(Integer id);

}
