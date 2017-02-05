package com.example.linghou_sizebook;

import java.util.Calendar;

/**
 * Created by linghou on 2017-02-03.
 */

public class Person {
    private String name;

    //Based on from http://stackoverflow.com/questions/9243578/java-util-date-and-getyear/12273692#12273692
    //Since Date class has no getYear anymore.
    private Calendar date;
    private Float neck;
    private Float bust;
    private Float chest;
    private Float waist;
    private Float hip;
    private Float inseam;
    private String comment;

    public Person(String name, Calendar date, Float neck, Float bust, Float chest, Float waist, Float hip, Float inseam, String comment
    ){
        this.name=name;
        this.date=date;
        this.neck=neck;
        this.bust=bust;
        this.chest=chest;
        this.waist=waist;
        this.hip=hip;
        this.inseam=inseam;
        this.comment=comment;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Float getNeck() {
        return neck;
    }

    public void setNeck(Float neck) {
        this.neck = neck;
    }

    public Float getBust() {
        return bust;
    }

    public void setBust(Float bust) {
        this.bust = bust;
    }

    public Float getChest() {
        return chest;
    }

    public void setChest(Float chest) {
        this.chest = chest;
    }

    public Float getWaist() {
        return waist;
    }

    public void setWaist(Float waist) {
        this.waist = waist;
    }

    public Float getHip() {
        return hip;
    }

    public void setHip(Float hip) {
        this.hip = hip;
    }

    public Float getInseam() {
        return inseam;
    }

    public void setInseam(Float inseam) {
        this.inseam = inseam;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

