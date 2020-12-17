package com.example.demo.repository;


import com.example.demo.Model.City;
import org.springframework.data.repository.CrudRepository;


public interface CityRepository extends CrudRepository<City, Long> {
}
