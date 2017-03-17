package com.example.repository;

import com.example.domain.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuffRepository extends JpaRepository<Stuff, Integer> {

}
