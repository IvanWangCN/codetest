package com.ivan.learning.codetest.dto;

import org.springframework.stereotype.Component;

@Component
public class WindDTO {
    private double speed;

    private int deg;

    public void setSpeed(double speed){
        this.speed = speed;
    }
    public double getSpeed(){
        return this.speed;
    }
    public void setDeg(int deg){
        this.deg = deg;
    }
    public int getDeg(){
        return this.deg;
    }
}
