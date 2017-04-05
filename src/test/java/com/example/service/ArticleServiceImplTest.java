package com.example.service;

import com.example.domain.Article;
import com.example.repository.ArticleRepository;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;

public class ArticleServiceImplTest {

    private ArticleServiceImpl articleService;

    @Mock
    private ArticleRepository articleRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        articleService = new ArticleServiceImpl(articleRepository);
    }

    @After
    public void tearDown() throws Exception {
        Mockito.validateMockitoUsage();
    }

    @Ignore
    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void findOne() throws Exception {
        when(articleRepository.findOne(anyInt())).thenReturn(new Article());

        Article result = articleService.findOne(42);

        Assert.assertNotNull(result);
    }

    @Test
    public void create() throws Exception {
        when(articleRepository.save(isA(Article.class))).thenReturn(new Article());

        Article result = articleService.create(new Article());

        Assert.assertNotNull(result);
    }

    @Test
    public void update() throws Exception {
        when(articleRepository.save(isA(Article.class))).thenReturn(new Article());

        Article result = articleService.update(new Article());

        Assert.assertNotNull(result);
    }

    @Ignore
    @Test
    public void delete() throws Exception {
    }

}