package com.forogh.salaryPayment.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.logging.Logger;

public class CreditorDal {

    private static final String src = "src/main/resources/creditor.txt";
    private static final Path path = Paths.get(src);
    private static Integer integer = 2000;

    public CreditorDal() throws IOException {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            } else {
                Files.delete(path);
                Files.createFile(path);
            }
        } catch (IOException ex) {
            Logger.getLogger(CreditorDal.class.getName());
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void setInitCreditor() {
        try {
            for (Integer i = 0; i < integer; i++) {
                Random r = new Random();
                Integer am = r.nextInt(20000);
                String fil = i.toString() + " " + am.toString() + "\n";
                System.out.print(fil);
                Files.write(path, fil.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException ex) {
            Logger.getLogger(CreditorDal.class.getName());
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
