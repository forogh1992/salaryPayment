package com.forogh.salaryPayment.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

public class DebtorDal {

    private static final String src = "src/main/resources/debtor.txt";
    private static final Path path = Paths.get(src);


    public DebtorDal() {
        try {
            if (!Files.exists(path)) {
                Files.write(path, "60000000000".getBytes());
            }
        } catch (IOException ex) {
            Logger.getLogger(DebtorDal.class.getName());
            ex.printStackTrace();
        }
    }

    public boolean setDebtorAmount(Integer integer) throws IOException {
        try {
            Files.write(path, Integer.toString(integer).getBytes());
            return true;
        } catch (IOException ex) {
            Logger.getLogger(DebtorDal.class.getName());
            ex.printStackTrace();
            return false;
        }
    }

    public boolean getDebtAmount(Integer integer) {
        try {

            List<String> list = Files.readAllLines(path);
            Files.write(path, Integer.toString(integer).getBytes());

            return true;
        } catch (IOException ex) {
            Logger.getLogger(DebtorDal.class.getName());
            ex.printStackTrace();
            return false;
        }
    }

}
