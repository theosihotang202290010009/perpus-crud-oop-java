package com.enigma.belajar_crud.util;

import com.enigma.belajar_crud.entity.Book;
import com.enigma.belajar_crud.service.ServiceInterfaceImpl;
import com.enigma.belajar_crud.service.ServiceIntervace;

import java.util.List;
import java.util.Scanner;

public class Utility {
    public static String inputString(String info){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.printf("%s", info);
            String result = sc.nextLine();
            if (result.isEmpty() || result.isBlank()){
                continue;
            }
            return result;
        }
    }

    public static int inputInt(String info){
        Scanner sc =new Scanner(System.in);
        while (true){
            System.out.printf("%s", info);
            try {
                return Integer.parseInt(sc.nextLine());
            }catch (Exception e){
                continue;
            }
        }
    }

    public static String novelCode(Integer year){
        Integer count = 1;
        ServiceIntervace serviceIntervace = new ServiceInterfaceImpl();
        List<Book> getBook = serviceIntervace.viewBook();
        for (int i = 0; i < getBook.size(); i++) {
            if (getBook.get(i).getCode().contains("A")){
                String[] codeA = getBook.get(i).getCode().split("-");
                Integer codeNovel = Integer.parseInt(codeA[2]);
                count = codeNovel + 1;
            }
        }
        return year+"-A-"+count;
    }

    public static String magazineCode(Integer year){
        ServiceIntervace serviceIntervace = new ServiceInterfaceImpl();
        Integer count = 1;
        List<Book> getBook = serviceIntervace.viewBook();
        for (int i = 0; i < getBook.size(); i++) {
            if (getBook.get(i).getCode().contains("B")) {
                String[] codeB = getBook.get(i).getCode().split("-");
                Integer codeMagazine = Integer.parseInt(codeB[2]);
                count = codeMagazine + 1;
            }
        }
        return year+"-B-"+count;
    }
}
