package com.ivan.learning.codetest.dto;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class OwnerDTO {
    private String name;
    private String gender;
    private String age;
    private PetDTO[] pets;

    public PetDTO[] getPets() {
        return pets;
    }

    public void setPets(PetDTO[] pets) {
        this.pets = pets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}