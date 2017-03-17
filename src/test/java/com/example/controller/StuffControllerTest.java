package com.example.controller;

import com.example.domain.Stuff;
import com.example.service.StuffService;
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

public class StuffControllerTest {

    private StuffController stuffController;

    @Mock
    private StuffService stuffService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        stuffController = new StuffController(stuffService);
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
        Stuff stuff = new Stuff();
        stuff.setId(42);

        when(stuffService.findOne(anyInt())).thenReturn(stuff);

        ResponseEntity<Stuff> responseEntity = stuffController.findOne(42);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertEquals(42, responseEntity.getBody().getId().intValue());
    }

    @Test
    public void delete() throws Exception {
        ResponseEntity responseEntity = stuffController.delete(42);

        Assert.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

    @Test
    public void create() throws Exception {
        Stuff stuff = new Stuff();
        stuff.setId(42);
        stuff.setTitle("Test the stuff!");
        stuff.setContent("Testing stuff is good.");

        when(stuffService.create(isA(Stuff.class))).thenReturn(stuff);

        ResponseEntity<Stuff> responseEntity = stuffController.create(stuff);
        Stuff stuffResult = responseEntity.getBody();

        Assert.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        Assert.assertEquals(stuff, stuffResult);
    }

    @Test
    public void update() throws Exception {
        Stuff stuff = new Stuff();
        stuff.setId(42);
        stuff.setTitle("Test the stuff!");
        stuff.setContent("Testing stuff is good.");

        when(stuffService.update(isA(Stuff.class))).thenReturn(stuff);

        ResponseEntity<Stuff> responseEntity = stuffController.update(stuff, 42);
        Stuff stuffResult = responseEntity.getBody();

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertEquals(stuff, stuffResult);
    }

}