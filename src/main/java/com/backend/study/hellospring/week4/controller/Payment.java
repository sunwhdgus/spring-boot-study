package com.backend.study.hellospring.week4.controller;

public class Payment {
    public String id;
    private double amount;

    public Payment(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
