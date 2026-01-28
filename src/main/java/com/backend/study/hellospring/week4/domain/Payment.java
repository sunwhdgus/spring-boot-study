package com.backend.study.hellospring.week4.domain;

public class Payment {
    public String orderId;
    private int amount;

    public Payment() {
    }

    public Payment(String orderId, int amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
