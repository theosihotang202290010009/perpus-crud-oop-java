package com.enigma.belajar_crud.entity;

import java.io.Serializable;

public class Novel extends Book {
    private String codeNovel;

    private String novelTitle;
    private String publisher;
    private Integer year;
    private String author;

    public Novel(String codeNovel, String novelTitle, String publisher, Integer year, String author) {
        this.codeNovel = codeNovel;
        this.novelTitle = novelTitle;
        this.publisher = publisher;
        this.year = year;
        this.author = author;
    }

    public void setCodeNovel(String codeNovel) {
        this.codeNovel = codeNovel;
    }

    public void setNovelTitle(String novelTitle) {
        this.novelTitle = novelTitle;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getCode() {
        return this.codeNovel;
    }

    @Override
    public String getTitle() {
        return this.novelTitle;
    }
}
