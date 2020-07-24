package com.forogh.salaryPayment.model;

import java.math.BigDecimal;

public class Payment {

    private Boolean isDebtor;
    private String depositNumber;
    private BigDecimal amount;


    public Boolean getDebtor() {
        return isDebtor;
    }

    public void setDebtor(Boolean debtor) {
        isDebtor = debtor;
    }

    public String getDepositNumber() {
        return depositNumber;
    }

    public void setDepositNumber(String depositNumber) {
        this.depositNumber = depositNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
