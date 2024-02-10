package com.enigma.belajar_crud.view;

import com.enigma.belajar_crud.constant.Period;
import com.enigma.belajar_crud.entity.Book;
import com.enigma.belajar_crud.entity.Magazine;
import com.enigma.belajar_crud.entity.Novel;
import com.enigma.belajar_crud.service.ServiceInterfaceImpl;
import com.enigma.belajar_crud.service.ServiceIntervace;
import com.enigma.belajar_crud.util.Utility;

import java.rmi.NoSuchObjectException;
import java.util.List;

public class BookView {
    private final ServiceIntervace serviceIntervace;

    public BookView(ServiceIntervace serviceIntervace) {
        this.serviceIntervace = serviceIntervace;
    }

    ServiceIntervace service = new ServiceInterfaceImpl();

    public void runMenu() {
        showMenu();
    }

    public void showMenu() {
        while (true) {
            System.out.println("-".repeat(100));
            System.out.println("Main Menu");
            System.out.println("-".repeat(100));
            System.out.println("""
                    1. Novel Menu
                    2. Magazine Menu
                    X. Exit
                    """);
            System.out.println("-".repeat(100));
            String inputMenu = Utility.inputString("Pilih Menu (1/2) : ");
            switch (inputMenu) {
                case "1" -> {
                    novelMenu();
                }
                case "2" -> {
                    magazineMenu();
                }
                case "x", "X" -> {
                    return;
                }
            }
        }
    }


    public void novelMenu() {
        System.out.println("-".repeat(100));
        System.out.println("Novel Menu");
        System.out.println("-".repeat(100));
        System.out.println("""
                1. Add Novel
                2. Update Novel
                3. Delete Novel
                4. Search Novel
                5. View Novel
                X. Exit
                """);
        System.out.println("-".repeat(100));
        String inputNovelMenu = Utility.inputString("Pilih Menu Novel (1-6) : ");
        switch (inputNovelMenu) {
            case "1" -> {
                addNovel();
            }
            case "2" -> {
                updateNovel();
            }
            case "3" -> {
                deleteNovel();
            }
            case "4" -> {
                searchNovel();
            }
            case "5" -> {
                viewNovel();
            }
            case "x", "X" -> {
                return;
            }
        }
    }

    public void addNovel() {
        String title = Utility.inputString("Masukkan Judul Novel         : ");
        String publisher = Utility.inputString("Masukkan Penerbit Novel  : ");
        Integer year = Utility.inputInt("Masukkan Tahun Terbit Novel     : ");
        String author = Utility.inputString("Masukkan Nama Penulis       : ");
        Book book = new Novel(Utility.novelCode(year), title, publisher, year, author);
        service.addBook(book);
    }

    public void updateNovel() {
        List<Book> books = service.viewBook();
        System.out.println("-".repeat(100));
        if (!books.isEmpty()) {
            String updateCode = Utility.inputString("Masukan Kode buku yang akan diubah : ");
                if (updateCode.contains("A")) {
                    String title = Utility.inputString("Masukkan Judul Novel         : ");
                    String publisher = Utility.inputString("Masukkan Penerbit Novel  : ");
                    Integer year = Utility.inputInt("Masukkan Tahun Terbit Novel     : ");
                    String author = Utility.inputString("Masukkan Nama Penulis       : ");
                    Book book = new Novel(updateCode, title, publisher, year, author);
                    service.updateBook(updateCode,book);
                }
        }else {
            System.out.println("Data Kosong, Tidak dapat mengupdate buku");
        }
    }

    public void deleteNovel() {
        List<Book> books = service.viewBook();
        System.out.println("-".repeat(100));
        if (!books.isEmpty()) {
            String deleteBook = Utility.inputString("Masukan Kode Buku yang akan dihapus : ");
            if (deleteBook.contains("A")) {
                Integer validDel;
                    do {
                        System.out.println("Apakah anda yakin ingin menghapus Novel ini ?");
                        validDel = Utility.inputInt("""
                                1. Yakin
                                2. Tidak
                                """);
                    } while (validDel < 1 || validDel > 2);

                    System.out.println("-".repeat(100));
                    switch (validDel) {
                        case 1 -> {
                            serviceIntervace.deleteBook(deleteBook);
                        }
                        case 2 -> {
                            novelMenu();
                        }
                    }

            } else {
                System.out.println("Kode buku yang anda masukan bukan kode Novel");
            }
        } else {
            System.out.println("Tidak ada Buku yang dapat dihapus, Data Kosong");
        }
    }

    public void searchNovel() {
        List<Book> books = service.viewBook();
        System.out.println("-".repeat(100));
        if (!books.isEmpty()) {
            String search = Utility.inputString("Masukan Kode atau Judul Novel yang ingin anda cari : ");
            if (search.contains("A")) {
                service.searchBook(search);
            } else {
                System.out.println("Bukan merupakan Kode Novel");
            }
        } else {
            System.out.println("Data Kosong, Tidak dapat mencari buku");
        }
    }

    public void viewNovel() {
        List<Book> books = service.viewBook();
        if (books != null && !books.isEmpty()) {
            System.out.println("-".repeat(100));
            String format = String.format("%-15s %-30s %-20s %-15s %-20s", "Code", "Title", "Publisher", "Year", "Author");
            System.out.println(format);
            for (Book book : books) {
                if (book instanceof Novel) {
                    System.out.printf("%-15s %-30s %-20s %-15s %-20s\n", book.getCode(), book.getTitle(), ((Novel) book).getPublisher(), ((Novel) book).getYear(), ((Novel) book).getAuthor());
                }
            }
        } else {
            System.out.println("-".repeat(100));
            String format = String.format("%-15s %-30s %-20s %-15s %-20s", "Code", "Title", "Publisher", "Year", "Author");
            System.out.println(format);
            System.out.println("-".repeat(100));
            System.out.println(" ".repeat(40) + "Data Kosong!!".toUpperCase());
        }
        System.out.println("-".repeat(100));
    }

    public void magazineMenu() {
        System.out.println("-".repeat(100));
        System.out.println("Magazine Menu");
        System.out.println("-".repeat(100));
        System.out.println("""
                1. Add Magazine
                2. Update Magazine
                3. Delete Magazine
                4. Search Magazine
                5. View Magazine
                X. Exit
                """);
        String inputMagazineMenu = Utility.inputString("Pilih Menu Magazine (1-6) : ");
        switch (inputMagazineMenu) {
            case "1" -> {
                addMagazine();
            }
            case "2" -> {
                updateMagazine();
            }
            case "3" -> {
                deleteMagazine();
            }
            case "4" -> {
                searchMagazine();
            }
            case "5" -> {
                viewMagazine();
            }
            case "x", "X" -> {
                return;
            }
        }
    }

    public void addMagazine() {
        System.out.println("-".repeat(100));
        String title = Utility.inputString("Masukkan Judul Majalah : ");
        String publisher = Utility.inputString("Pilih periode terbit Majalah (1. Weekly || 2. Monthly)  : ");
        switch (publisher) {
            case "1" -> {
                publisher = String.valueOf(Period.WEEKLY);
            }
            case "2" -> {
                publisher = String.valueOf(Period.MONTHLY);
            }
        }
        Integer year = Utility.inputInt("Masukkan Tahun Terbit Novel : ");
        Book book = new Magazine(Utility.magazineCode(year), title, publisher, year);
        service.addBook(book);
    }

    public void updateMagazine() {
        List<Book> books = service.viewBook();
        System.out.println("-".repeat(100));
        if (!books.isEmpty()) {
            String updateMagazine = Utility.inputString("Masukan Kode Majalah : ");
            if (updateMagazine.contains("B")) {
                String title = Utility.inputString("Masukkan Judul Majalah : ");
                String publisher = Utility.inputString("Pilih periode terbit Majalah (1. Weekly || 2. Monthly)  : ");
                switch (publisher) {
                    case "1" -> {
                        publisher = String.valueOf(Period.WEEKLY);
                    }
                    case "2" -> {
                        publisher = String.valueOf(Period.MONTHLY);
                    }
                }
                Integer year = Utility.inputInt("Masukkan Tahun Terbit Novel : ");
                Book book = new Magazine(updateMagazine, title, publisher, year);
                service.updateBook(updateMagazine,book);
            }else {
                System.out.println("Kode yang anda masukan tidak sesuai");
            }
        }else {
            System.out.println("Data Kosong, data tidak dapat diubah");
        }
    }

    public void deleteMagazine() {
        List<Book> books = service.viewBook();
        System.out.println("-".repeat(100));
        if (!books.isEmpty()) {
            String deleteMagazin = Utility.inputString("Masukan Kode Majalah yang akan dihapus : ");
            if (deleteMagazin.contains("B")) {
                Integer choose;
                do {
                    System.out.println("Yakin akan Menghapus data ?");
                    choose = Utility.inputInt("""
                        1. Yakin
                        2. Tidak
                        """);
                }while (choose < 1 || choose > 2);
                System.out.println("-".repeat(100));
                switch (choose) {
                    case 1 -> {
                        service.deleteBook(deleteMagazin);
                    }
                    case 2 -> {
                        magazineMenu();
                    }
                }

            } else {
                System.out.println("Mohon Maaf Kode yang anda Bukan Kode Majalah");
            }
        } else {
            System.out.println("Data Kosong, tidak dapat menghapus");
        }
    }

    public void searchMagazine() {
        List<Book> books = service.viewBook();
        System.out.println("-".repeat(100));
        if (!books.isEmpty()) {
            String codeTitle = Utility.inputString("Masukan Kode atau Judul Majalah Yang akan di hapus : ");
            if (codeTitle.contains("B")) {
                service.searchBook(codeTitle);
            } else {
                System.out.println("Bukan merupakan Kode Majalah");
            }
        } else {
            System.out.println("Tidak dapat menccari data, DATA KOSONG");
        }
    }

    public void viewMagazine() {
        List<Book> books = service.viewBook();
        if (books != null && !books.isEmpty()) {
            System.out.println("-".repeat(100));
            String format = String.format("%-20s %-35s %-25s %-20s", "Code", "Title", "Period", "Year");
            System.out.println(format);
            for (Book book : books) {
                if (book instanceof Magazine) {
                    System.out.printf("%-20s %-35s %-25s %-20s\n", book.getCode(), book.getTitle(), ((Magazine) book).getPublicPeriod(), ((Magazine) book).getYear());
                }
            }
        } else {
            System.out.println("-".repeat(100));
            String format = String.format("%-20s %-35s %-25s %-20s", "Code", "Title", "Period", "Year");
            System.out.println(format);
            System.out.println("-".repeat(100));
            System.out.println(" ".repeat(40) + "Data Kosong!!".toUpperCase());
        }
    }
}
