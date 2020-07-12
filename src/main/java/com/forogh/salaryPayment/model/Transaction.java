package com.forogh.salaryPayment.model;


public class Transaction {

    private Integer debtorDepositNumber;
    private Integer creditorDepositNumber;
    private Integer amount;

    public Integer getDebtorDepositNumber() {
        return debtorDepositNumber;
    }

    public void setDebtorDepositNumber(Integer debtorDepositNumber) {
        this.debtorDepositNumber = debtorDepositNumber;
    }

    public Integer getCreditorDepositNumber() {
        return creditorDepositNumber;
    }

    public void setCreditorDepositNumber(Integer creditorDepositNumber) {
        this.creditorDepositNumber = creditorDepositNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
