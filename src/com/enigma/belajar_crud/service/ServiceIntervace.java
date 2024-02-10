package com.enigma.belajar_crud.service;

import com.enigma.belajar_crud.entity.Book;

import java.util.List;

public interface ServiceIntervace {
    void addBook(Book book);
    void updateBook(String code, Book book);
    void deleteBook(String code);
    void searchBook(String search);
    List<Book> viewBook();
}
