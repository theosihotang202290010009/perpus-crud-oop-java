package com.enigma.belajar_crud.entity;

import java.io.Serializable;

public abstract class Book implements Serializable {
    private static final long serialVersionUID =1L;
    public abstract String getCode();
    public abstract String getTitle();
}
