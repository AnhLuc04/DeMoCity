package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Size(min = 2, max = 50, message = "Xin Mời Nhập Lại")
    @NotEmpty
    private String nameNation;

    public Nation() {

    }

    public Nation(Long ID, @NotEmpty String nameNation) {
        this.ID = ID;
        this.nameNation = nameNation;
    }

    public Nation(@NotEmpty String nameNation) {
        this.nameNation = nameNation;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNameNation() {
        return nameNation;
    }

    public void setNameNation(String nameNation) {
        this.nameNation = nameNation;
    }
}
