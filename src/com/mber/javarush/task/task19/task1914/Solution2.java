package com.mber.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/*
Решаем пример
*/

public class Solution2 {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldPrintStream = System.out;
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOut));
        testString.printSomething();
        System.setOut(oldPrintStream);

        String theString = myOut.toString().replace("\r\n", ""); //заранее убрали перенос строки
        String[] elements = theString.split(" ");
        int a = Integer.parseInt(elements[0]), b = Integer.parseInt(elements[2]), result = 0;
        switch (elements[1]) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "*" -> result = a * b;
            case "/" -> result = a / b;
        }
        System.out.println(theString + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}
