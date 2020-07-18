package com.forogh.salaryPayment.service;

import com.forogh.salaryPayment.model.Debtor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.logging.Logger;

public class DebtorDal {

    private static final String src = "src/main/resources/debtor.txt";
    private static final Path path = Paths.get(src);


    public DebtorDal() {
        try {
            if (!Files.exists(path)) {
                String s = "101 600000000" + "\n";
                Files.write(path, s.getBytes());
            } else {
                Files.delete(path);
                String s = "101 600000000" + "\n";
                Files.write(path, s.getBytes());
            }
        } catch (IOException ex) {
            Logger.getLogger(DebtorDal.class.getName(), ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Debtor getAmountDebt() {
        Debtor debtor = new Debtor();
        try {
            List<String> lines = Files.readAllLines(path);
            for (int i = lines.size() - 1; i > lines.size() - 2; i--) {
                String[] s = lines.get(i).split(" ");
                debtor.setDepositNumber(Integer.parseInt(s[0]));
                debtor.setAmount(Integer.parseInt(s[1]));
                System.out.println(debtor.getDepositNumber() + " " + debtor.getAmount());
            }
        } catch (IOException ex) {
            Logger.getLogger(DebtorDal.class.getName(), ex.getMessage());
            ex.printStackTrace();
        }
        return debtor;
    }

    public Boolean setMinosAmountDebt(Debtor debtor) {
        try {
            String s = debtor.getDepositNumber() + " " + debtor.getAmount()+"\n";
            Files.write(path, s.getBytes());
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
