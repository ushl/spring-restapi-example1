package com.example.controller;

import com.example.domain.Article;
import com.example.service.ArticleService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;

public class ArticleControllerTest {

    private ArticleController articleController;

    @Mock
    private ArticleService articleService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        articleController = new ArticleController(articleService);
    }

    @After
    public void tearDown() throws Exception {
        Mockito.validateMockitoUsage();
    }

    @Test
    public void findAll() throws Exception {

    }

    @Test
    public void findOne() throws Exception {
        Article article = new Article();
        article.setId(42);

        when(articleService.findOne(anyInt())).thenReturn(article);

        ResponseEntity<Article> responseEntity = articleController.findOne(42);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertEquals(42, responseEntity.getBody().getId().intValue());
    }

    @Test
    public void delete() throws Exception {
        ResponseEntity responseEntity = articleController.delete(42);

        Assert.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

    @Test
    public void create() throws Exception {
        Article article = new Article();
        article.setId(42);
        article.setTitle("Test the stuff!");
        article.setContent("Testing stuff is good.");

        when(articleService.create(isA(Article.class))).thenReturn(article);

        ResponseEntity<Article> responseEntity = articleController.create(article);
        Article articleResult = responseEntity.getBody();

        Assert.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        Assert.assertEquals(article, articleResult);
    }

    @Test
    public void update() throws Exception {
        Article article = new Article();
        article.setId(42);
        article.setTitle("Test the stuff!");
        article.setContent("Testing stuff is good.");

        when(articleService.update(isA(Article.class))).thenReturn(article);

        ResponseEntity<Article> responseEntity = articleController.update(article, 42);
        Article articleResult = responseEntity.getBody();

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertEquals(article, articleResult);
    }

}