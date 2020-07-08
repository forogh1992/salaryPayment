package com.forogh.salaryPayment;

public class Transaction {


    private Creditor from;
    private Creditor to;
    private long amount;

    public Transaction(Creditor from, Creditor to, long amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public Creditor getFrom() {
        return from;
    }

    public Creditor getTo() {
        return to;
    }

    public long getAmount() {
        return amount;
    }
}
