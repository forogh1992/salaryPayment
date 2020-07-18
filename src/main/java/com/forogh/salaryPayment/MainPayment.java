package com.forogh.salaryPayment;

import com.forogh.salaryPayment.model.Creditor;
import com.forogh.salaryPayment.model.Debtor;
import com.forogh.salaryPayment.model.Transaction;
import com.forogh.salaryPayment.service.CreditorDal;
import com.forogh.salaryPayment.service.DebtorDal;
import com.forogh.salaryPayment.service.TransactionDal;

import java.io.*;
import java.util.List;

public class MainPayment {

    public static void main(String[] args) throws IOException {

        DebtorDal debtorDal = new DebtorDal();
        CreditorDal creditorDal = new CreditorDal();
        creditorDal.setInitCreditor();
        TransactionDal transactionDal = new TransactionDal();

        List<Creditor> list = creditorDal.getAllCreditorAccount();
        for (Creditor c : list) {
            Transaction transaction = new Transaction();
            Debtor debtor = debtorDal.getAmountDebt();
            Integer ex = c.getAmount();
            debtor.setAmount(debtor.getAmount() - ex);
//            debtor.setDepositNumber(debtor.getDepositNumber() + 1);
            debtorDal.setMinosAmountDebt(debtor);
            transaction.setCreditorDepositNumber(c.getDepositNumber());
            transaction.setDebtorDepositNumber(debtor.getDepositNumber());
            transaction.setAmount(c.getAmount());
            transactionDal.saveTransAction(transaction);
        }

    }
}
