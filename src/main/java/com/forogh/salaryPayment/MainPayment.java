package com.forogh.salaryPayment;

import com.forogh.salaryPayment.service.CreditorDal;
import com.forogh.salaryPayment.service.DebtorDal;

import java.io.*;

public class MainPayment {

  public static void main(String[] args) throws IOException {

        DebtorDal debtorDal = new DebtorDal();
        CreditorDal creditorDal = new CreditorDal();
        creditorDal.setInitCreditor();

    }
}
