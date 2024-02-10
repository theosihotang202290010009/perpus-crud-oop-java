package com.enigma.belajar_crud.entity;

public class Magazine extends Book{
    private String  codeMagazine;
    private String titleMagazine;
    private String publicPeriod;
    private Integer year;

    public Magazine(String codeMagazine, String titleMagazine, String publicPeriod, Integer year) {
        this.codeMagazine = codeMagazine;
        this.titleMagazine = titleMagazine;
        this.publicPeriod = publicPeriod;
        this.year = year;
    }

    public void setCodeMagazine(String codeMagazine) {
        this.codeMagazine = codeMagazine;
    }

    public void setTitleMagazine(String titleMagazine) {
        this.titleMagazine = titleMagazine;
    }

    public String getPublicPeriod() {
        return publicPeriod;
    }

    public void setPublicPeriod(String publicPeriod) {
        this.publicPeriod = publicPeriod;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String getCode() {
        return this.codeMagazine;
    }

    @Override
    public String getTitle() {
        return this.titleMagazine;
    }
}
