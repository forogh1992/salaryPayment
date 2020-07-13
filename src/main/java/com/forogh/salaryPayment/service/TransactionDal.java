package com.forogh.salaryPayment.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class TransactionDal {

    private static final String src = "src/main/resources/transaction.txt";
    private static final Path path = Paths.get(src);

    public TransactionDal() {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            } else {
                Files.delete(path);
                Files.createFile(path);
            }
        } catch (IOException ex) {
            Logger.getLogger(CreditorDal.class.getName(), ex.getMessage());
            ex.printStackTrace();
        }
    }
}
