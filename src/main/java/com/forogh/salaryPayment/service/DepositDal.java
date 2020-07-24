package com.forogh.salaryPayment.service;

import com.forogh.salaryPayment.model.Deposit;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DepositDal {

    private static final String src = "src/main/java/com/forogh/salaryPayment/files/deposit.txt"; //debtor.txt
    private static final Path path = Paths.get(src);
    private static final Logger log = Logger.getLogger(DepositDal.class.getName());



    public DepositDal() {
        try {

            String s = "111 600000000" + "\n";
            Files.write(path, s.getBytes());

        } catch (IOException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Deposit getAmountDebt() {
        Deposit deposit = new Deposit();
        try {
            List<String> lines = Files.readAllLines(path);
            for (int i = lines.size() - 1; i > lines.size() - 2; i--) {
                String[] s = lines.get(i).split(" ");
                deposit.setDepositNumber((s[0]));
                deposit.setAmount(BigDecimal.valueOf(Long.parseLong(s[1])));
                System.out.println(deposit.getDepositNumber() + " " + deposit.getAmount());
            }
        } catch (IOException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        return deposit;
    }

    public void setMinosAmountDebt(Deposit deposit) {
        try {
            String s = deposit.getDepositNumber() + " " + deposit.getAmount() + "\n";
            Files.write(path, s.getBytes());
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();

        }
    }

}
