package com.forogh.salaryPayment;

import com.forogh.salaryPayment.model.Creditor;
import com.forogh.salaryPayment.model.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;

public class MainPayment {


    final private String ALL_INFO = "src\\main\\AllInfo.txt";
    final private String BALANCE = "src\\main\\Balance.txt";
    final private String TRANSACTIONS = "src\\main\\Transaction.txt";
    private static File allInfo;
    private static File balance;
    private static File transactions;

    private static Scanner sc = new Scanner(System.in);
    private static String debtorID = "";

    public static void main(String[] args) throws IOException {


        MainPayment mainPayment = new MainPayment();
        try {
            mainPayment.initFiles();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }


        System.out.println("Please enter debtor's ID");
        debtorID = sc.nextLine();
        System.out.println("Please enter creditor's ID");
        String creditorID = sc.nextLine();
        System.out.println("Please enter amount");
        long amount = sc.nextLong();
        Creditor from = mainPayment.getPerson(debtorID);
        Creditor to = mainPayment.getPerson(creditorID);
        Transaction transaction = new Transaction(from, to, amount);
        String result = mainPayment.transfer(transaction);
        System.out.println(result);

    }

    String transfer(Transaction transaction) throws IOException {
        long amount = transaction.getAmount();
        if (transaction.getFrom().getBalance() < transaction.getAmount()) {
            return "moojoodi kafi nist";
        } else {
            transaction.getFrom().withdrawal(amount);
            transaction.getTo().deposit(amount);
            updateBalance(transaction.getFrom());
            updateBalance(transaction.getTo());
            writeTransaction(transaction);
            return "success";
        }
    }


    void updateBalance(Creditor person) throws IOException {
        HashMap<String, String> data = readAllBalances();
        data.put(person.getId(), String.valueOf(person.getBalance()));
        FileWriter fileWriter = new FileWriter(balance);
        ArrayList<String> list = new ArrayList<>();
        data.forEach((s, s2) -> {
            list.add(s + " " + s2);
        });

        for (int i = list.size() - 1; i > -1; i--) {
            try {
                fileWriter.write(list.get(i) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fileWriter.flush();
        fileWriter.close();
    }

    HashMap<String, String> readAllBalances() throws FileNotFoundException {
        HashMap<String, String> result = new HashMap<>();
        Scanner scanner = new Scanner(balance);
        String[] data;
        while (scanner.hasNextLine()) {
            data = scanner.nextLine().split(" ");
            result.put(data[0], data[1]);
        }
        return result;
    }

    void writeTransaction(Transaction transaction) throws IOException {
        FileWriter fileWriter = new FileWriter(transactions, true);
        fileWriter.append(transaction.getFrom().getId() +
                " " +
                transaction.getTo().getId() +
                " " +
                transaction.getAmount() +
                "\n");

        fileWriter.flush();
        fileWriter.close();
    }


    void initFiles() throws IOException {
        allInfo = new File(ALL_INFO);
        if (!allInfo.exists())
            allInfo.createNewFile();

        balance = new File(BALANCE);
        if (!balance.exists()) {
            balance.createNewFile();

            Scanner scanner = new Scanner(allInfo);
            FileWriter fileWriter = new FileWriter(balance);

            String[] data;
            while (scanner.hasNextLine()) {
                data = scanner.nextLine().split(" ");
                fileWriter.write(data[1] + " " + data[2] + "\n");
                fileWriter.flush();
            }
            fileWriter.close();
            scanner.close();
        }

        transactions = new File(TRANSACTIONS);
        if (!transactions.exists())
            transactions.createNewFile();


    }

    Creditor getPerson(String ID) throws FileNotFoundException {
        Creditor person;
        long balance;
        balance = Long.parseLong(readAllBalances().get(ID));
        if (ID.equals(debtorID))
            person = new Creditor(ID, balance, "debtor");
        else
            person = new Creditor(ID, balance, "creditor");
        return person;

    }

}

