package com.example.service;

import com.example.domain.Stuff;
import com.example.repository.StuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("stuffService")
public class StuffServiceImpl implements StuffService {

    private StuffRepository stuffRepository;

    @Autowired
    public StuffServiceImpl(StuffRepository stuffRepository) {
        this.stuffRepository = stuffRepository;
    }

    @Override
    public Page<Stuff> findAll(Pageable pageable) {
        return stuffRepository.findAll(pageable);
    }

    @Override
    public Stuff findOne(Integer id) {
        return stuffRepository.findOne(id);
    }

    @Override
    public Stuff create(Stuff stuff) {
        return stuffRepository.save(stuff);
    }

    @Override
    public Stuff update(Stuff stuff) {
        return stuffRepository.save(stuff);
    }

    @Override
    public void delete(Integer id) {
        stuffRepository.delete(id);
    }
}
