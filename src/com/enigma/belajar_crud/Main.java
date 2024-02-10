package com.enigma.belajar_crud;

import com.enigma.belajar_crud.service.ServiceInterfaceImpl;
import com.enigma.belajar_crud.service.ServiceIntervace;
import com.enigma.belajar_crud.view.BookView;

public class Main {
    public static void main(String[] args) {
        ServiceIntervace getBook = new ServiceInterfaceImpl();
        BookView view = new BookView(getBook);
        view.runMenu();
    }
}
