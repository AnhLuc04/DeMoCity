package com.example.demo.Model;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class City implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @NotBlank
    @Size(min = 2, max = 50, message = "Xin Mời Nhập Lại")
    private String nameCity;
    @Min(value = 0, message = "Xin Mời Nhập Lại")
    private int acreage;
    @Min(value = 0, message = "Xin Mời Nhập Lại")
    private int population;
    @Min(value = 1, message = "Xin Mời Nhập Lại")
    private int GDP;
    @NotEmpty(message = "Xin Mời Nhập Lai")
    private String description;
    @ManyToOne
    @JoinColumn(name = "nation_Id")
    private Nation nation;


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public int getAcreage() {
        return acreage;
    }

    public void setAcreage(int acreage) {
        this.acreage = acreage;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getGDP() {
        return GDP;
    }

    public void setGDP(int GDP) {
        this.GDP = GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public City() {
    }

    public City(Long ID, @NotNull String nameCity, @NotNull int acreage, @NotNull int population, @NotNull int GDP, @NotNull String description, Nation nation) {
        this.ID = ID;
        this.nameCity = nameCity;
        acreage = acreage;
        population = population;
        this.GDP = GDP;
        this.description = description;
        this.nation = nation;
    }

    public City(Long ID, @NotNull String nameCity) {
        this.ID = ID;
        this.nameCity = nameCity;
    }

    public City(Long ID, @NotNull String nameCity, @NotNull int acreage, @NotNull int population, @NotNull int GDP, @NotNull String description) {
        this.ID = ID;
        this.nameCity = nameCity;
        this.acreage = acreage;
        this.population = population;
        this.GDP = GDP;
        this.description = description;
    }

}
