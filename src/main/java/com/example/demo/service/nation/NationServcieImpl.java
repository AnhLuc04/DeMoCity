package com.example.demo.service.nation;


import com.example.demo.Model.Nation;
import com.example.demo.repository.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NationServcieImpl implements NationService {
    @Autowired
    NationRepository nationRepository;

    @Override
    public Iterable<Nation> findAll() {
        return nationRepository.findAll();
    }

    @Override
    public Optional<Nation> findById(Long id){
        return nationRepository.findById(id);
    }

    @Override
    public void save(Nation model) {
        nationRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        nationRepository.deleteById(id);
    }
}
