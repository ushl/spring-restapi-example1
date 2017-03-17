package com.example.service;

import com.example.domain.Stuff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StuffService {

    Page<Stuff> findAll(Pageable pageable);

    Stuff findOne(Integer id);

    Stuff create(Stuff stuff);

    Stuff update(Stuff stuff);

    void delete(Integer id);

}
