package com.example.demo.repository;


import com.example.demo.Model.Nation;
import org.springframework.data.repository.CrudRepository;

public interface NationRepository extends CrudRepository<Nation, Long> {
}
