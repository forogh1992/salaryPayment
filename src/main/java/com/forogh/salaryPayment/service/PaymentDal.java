package com.forogh.salaryPayment.service;

import com.forogh.salaryPayment.model.Payment;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.log4j.Logger;

public class PaymentDal {

    private static final String src = "src/main/java/com/forogh/salaryPayment/files/payment.txt";
    private static final Path path = Paths.get(src);
    private static Integer integer = 20;
    private static final Logger log = Logger.getLogger(DepositDal.class.getName());

    public PaymentDal() throws IOException {
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


    public void setInitCreditor() {
        try {
            for (Integer i = 0; i < integer; i++) {
                Random r = new Random();
                Integer am = r.nextInt(20000);
                String fil = ("10" + i.toString() + " " + am.toString() + "\n");
                Files.write(path, fil.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public List<Payment> getAllCreditorAccount() {
        List<Payment> list = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(path);
            for (String s1 : lines) {
                String[] s2 = s1.split(" ");
                Payment payment = new Payment();
                payment.setDepositNumber((s2[0]));
                payment.setAmount(BigDecimal.valueOf(Long.parseLong(s2[1])));
                list.add(payment);
            }
        } catch (IOException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        return list;
    }
}
