package com.forogh.salaryPayment.model;

public class Creditor {

    private Boolean creditor_debtor;
    private Integer depositNumber;
    private Integer amount;

    public Boolean getCreditor_debtor() {
        return creditor_debtor;
    }

    public void setCreditor_debtor(Boolean creditor_debtor) {
        this.creditor_debtor = creditor_debtor;
    }

    public Integer getDepositNumber() {
        return depositNumber;
    }

    public void setDepositNumber(Integer depositNumber) {
        this.depositNumber = depositNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
