package com.example.service;

import com.example.domain.Stuff;
import com.example.repository.StuffRepository;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;

public class StuffServiceImplTest {

    private StuffServiceImpl stuffService;

    @Mock
    private StuffRepository stuffRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        stuffService = new StuffServiceImpl(stuffRepository);
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
        when(stuffRepository.findOne(anyInt())).thenReturn(new Stuff());

        Stuff result = stuffService.findOne(42);

        Assert.assertNotNull(result);
    }

    @Test
    public void create() throws Exception {
        when(stuffRepository.save(isA(Stuff.class))).thenReturn(new Stuff());

        Stuff result = stuffService.create(new Stuff());

        Assert.assertNotNull(result);
    }

    @Test
    public void update() throws Exception {
        when(stuffRepository.save(isA(Stuff.class))).thenReturn(new Stuff());

        Stuff result = stuffService.update(new Stuff());

        Assert.assertNotNull(result);
    }

    @Ignore
    @Test
    public void delete() throws Exception {
    }

}