package com.ivan.learning.codetest.dto;

import org.springframework.stereotype.Component;

@Component
public class CloudsDTO {
    private int all;

    public void setAll(int all){
        this.all = all;
    }
    public int getAll(){
        return this.all;
    }
}
