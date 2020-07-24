package com.forogh.salaryPayment.service;

import com.forogh.salaryPayment.model.Transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import org.apache.log4j.Logger;


public class TransactionDal {

    private static final String src = "src/main/java/com/forogh/salaryPayment/files/transaction.txt";
    private static final Path path = Paths.get(src);
    private static final Logger log = Logger.getLogger(DepositDal.class.getName());


    public TransactionDal() {
        try {
            if (Files.exists(path)) {
                Files.delete(path);
            }
            Files.createFile(path);
        } catch (IOException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void saveTransAction(Transaction transAction) {
        try {
            String s = transAction.getDebtorDepositNumber() + " " + transAction.getCreditorDepositNumber() + " " + transAction.getAmount()+"\n";
            Files.write(path, s.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
