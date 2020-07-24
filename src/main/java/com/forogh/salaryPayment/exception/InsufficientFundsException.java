package com.forogh.salaryPayment.exception;

import java.math.BigDecimal;

public class InsufficientFundsException extends Exception {


    private final BigDecimal amount;

    public InsufficientFundsException(String message, BigDecimal amount) {

        super(message);
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
