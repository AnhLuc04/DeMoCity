package com.example.demo.service;


import com.example.demo.Model.Nation;
import javassist.NotFoundException;

import java.util.Optional;


public interface Service<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id) throws NotFoundException;

    void save(T model);

    void remove(Long id);
}
