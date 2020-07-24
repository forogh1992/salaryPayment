package com.forogh.salaryPayment;

import com.forogh.salaryPayment.model.Payment;
import com.forogh.salaryPayment.model.Deposit;
import com.forogh.salaryPayment.model.Transaction;
import com.forogh.salaryPayment.service.PaymentDal;
import com.forogh.salaryPayment.service.DepositDal;
import com.forogh.salaryPayment.service.TransactionDal;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;

public class MainPayment {

    public static void main(String[] args) throws IOException {

        DepositDal depositDal = new DepositDal();
        PaymentDal paymentDal = new PaymentDal();
        paymentDal.setInitCreditor();
        TransactionDal transactionDal = new TransactionDal();

        List<Payment> list = paymentDal.getAllCreditorAccount();
        for (Payment c : list) {

            Transaction transaction = new Transaction();
            Deposit deposit = depositDal.getAmountDebt();
            BigDecimal ex = c.getAmount();
            deposit.setAmount(deposit.getAmount().subtract(ex));
            depositDal.setMinosAmountDebt(deposit);

            transaction.setDebtorDepositNumber(deposit.getDepositNumber());
            transaction.setCreditorDepositNumber(c.getDepositNumber());
            transaction.setAmount(c.getAmount());
            transactionDal.saveTransAction(transaction);
        }

    }
}
