package com.mber.javarush.task.analyz.task1417;

public class Hryvnia extends Money{
    public Hryvnia(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "UAH";
    }
}