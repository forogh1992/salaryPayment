package com.forogh.salaryPayment;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;

public class MainPayment {

    public static void main(String[] args) throws IOException {

        File debtorFile = new File("src/main/resources/debtor.txt");
        File creditorFile = new File("src/main/resources/creditor.txt");
        File transactionFile = new File("src/main/resources/transaction.txt");
        File updateDebtor = new File("src/main/resources/updateDebtor.txt");
        File updateCreditor = new File("src/main/resources/updateCreditor.txt");


        /* read debtor file and balance*/
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(debtorFile);
        int debBalance = 0;
        String depositNumber = "";
        while (s1.hasNextLine()) {
           String[] x = s1.nextLine().split(" ");
            debBalance = Integer.parseInt(x[2]);
            depositNumber = x[1];
        }

        /* transfer */
        int i = 3;
        Scanner sc = new Scanner(creditorFile);
        ArrayList al = new ArrayList();
        sc.close();

        for (int j = 0; j < i; j++) {
            int p = j + 1;
            System.out.println("Enter Amount for Account 100" + p);
            int transAmount = s.nextInt();
            if (debBalance >= transAmount) {
                al.add(depositNumber + " " + "100" + p + " " + transAmount);
                debBalance -= transAmount;

            } else
                throw new ArithmeticException("Balance is not enough");
        }


        /* Update Files*/
        FileWriter fw = new FileWriter(transactionFile);
        for (int k = 0; k < al.size(); k++) {

            fw.write(al.get(k) + "\n");
        }
        fw.close();


        FileWriter fw2 = new FileWriter(updateDebtor);
        fw2.write("debtor" + " " + depositNumber + " " + debBalance + "\n");
        fw2.close();


        FileWriter fw3 = new FileWriter(updateCreditor);
        for (int l = 0; l < i; l++) {
            String[] x = al.get(l).toString().split(" ");
            int m = l + 1;
            fw3.write("creditor" + " " + "100" + m + " " + x[2] + "\n");
        }
        fw3.close();
    }
}

