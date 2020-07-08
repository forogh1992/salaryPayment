package com.forogh.salaryPayment;

public class Creditor {



    private String id;
    private long balance;
    private String type;


    public void withdrawal(long amount) {
        setBalance(getBalance() - amount);
    }


    public void deposit(long amount) {
        setBalance(getBalance() + amount);
    }

    public String getId() {
        return id;
    }

    public Creditor setId(String id) {
        this.id = id;
        return this;
    }

    public long getBalance() {
        return balance;
    }

    public Creditor setBalance(long balance) {
        this.balance = balance;
        return this;
    }

    public String getType() {
        return type;
    }

    public Creditor setType(String type) {
        this.type = type;
        return this;
    }

    public Creditor(String id, long balance, String type) {
        this.id = id;
        this.balance = balance;
        this.type = type;
    }

}
