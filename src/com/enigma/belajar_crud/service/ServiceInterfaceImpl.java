package com.enigma.belajar_crud.service;

import com.enigma.belajar_crud.entity.Book;
import com.enigma.belajar_crud.entity.Magazine;
import com.enigma.belajar_crud.entity.Novel;
import com.enigma.belajar_crud.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class ServiceInterfaceImpl implements ServiceIntervace {

    @Override
    public void addBook(Book book) {
        List<Book> books = viewBook();
        books.add(book);
        FileUtil.saveBook(books);
    }

    @Override
    public void updateBook(String code, Book book) {
        List<Book> books = viewBook();
        Boolean isThatCode = true;
        for (int i = 0; i<books.size(); i++) {
            if (books.get(i).getCode().equals(code)){
                books.set(i,book);
                isThatCode = false;
            }
        }
        if (isThatCode){
            System.out.println("Kode yang anda masukan tidak ada");
        }

        FileUtil.saveBook(books);
    }

    @Override
    public void deleteBook(String code) {
        List<Book> books = viewBook();
        Boolean hasBook = true;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i) instanceof Novel) {
                if (books.get(i).getCode().equals(code)) {
                    books.remove(books.get(i));
                    hasBook = false;
                }
            } else if (books.get(i) instanceof Magazine) {
                if (books.get(i).getCode().equals(code)) {
                    books.remove(books.get(i));
                    hasBook = false;
                }
            }
        }
        if (hasBook) {
            System.out.println("Kode tidak ada dalam daftar");
        }
        FileUtil.saveBook(books);
    }


    @Override
    public void searchBook(String search) {
        List<Book> books = viewBook();
        Integer number = 0;
        Boolean isGetBook = true;
        for (int i = 0; i < books.size(); i++) {
//            if (search.equals(books.get(i).getCode()) || search.equals(books.get(i).getTitle())) {
            Book book = books.get(i);
            if (book.getCode().equals(search) || book.getTitle().equals(search)) {
                if (book instanceof Novel) {
                    number += 1;
                    System.out.println("-".repeat(100));
                    System.out.println(number + ".");
                    System.out.println("Code Novel      : " + book.getCode());
                    System.out.println("Title Novel     : " + book.getTitle());
                    System.out.println("Publisher Novel : " + ((Novel) book).getPublisher());
                    System.out.println("Year Novel      : " + ((Novel) book).getYear());
                    System.out.println("Author Novel    : " + ((Novel) book).getAuthor());
                    isGetBook = false;
                } else if (book instanceof Magazine) {
                    number += 1;
                    System.out.println("-".repeat(100));
                    System.out.println(number + ".");
                    System.out.println("Code Magazine      : " + book.getCode());
                    System.out.println("Title Magazin      : " + book.getTitle());
                    System.out.println("Period Publish     : " + ((Magazine) book).getPublicPeriod());
                    System.out.println("Year Magazine      : " + ((Magazine) book).getYear());
                    isGetBook = false;
                }
            }
        }
        if (isGetBook) {
            System.out.println("Kode atau judul yang anda masukan tidak sesuai");
        }
    }

    @Override
    public List<Book> viewBook() {
        Object object = FileUtil.readObject();

        if (object == null) {
            return new ArrayList<>();
        }
        return (List<Book>) object;
    }
}
