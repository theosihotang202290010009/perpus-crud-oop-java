package com.enigma.belajar_crud.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileUtil {
    private static final Path path = Path.of("Enigpus");

    public static void saveBook(Object object){
        try (OutputStream os = Files.newOutputStream(path)) {
            try(ObjectOutputStream oos = new ObjectOutputStream(os)) {
                oos.writeObject(object);
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Object readObject(){
        if (!Files.exists(path)){
            saveBook(new ArrayList<>());
        }

        try (InputStream is = Files.newInputStream(path)) {
            try (ObjectInputStream ois = new ObjectInputStream(is)) {
                return ois.readObject();
            }catch (IOException | ClassNotFoundException e){
                throw new RuntimeException(e);
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}


