package com.mber.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/*
Решаем пример
*/

public class Solution3 {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream out = System.out;
        ByteArrayOutputStream bAoS = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(bAoS);
        System.setOut(printStream);
        testString.printSomething();
        String str = bAoS.toString();
        str = math(str);
        System.setOut(out);
        System.out.println(str);
    }

    public static String math(String str) {
        String[] strings = str.split(" ");
        str = str + resultMath(Integer.parseInt(strings[0]),strings[1],Integer.parseInt(strings[2]));
        return new StringBuilder(str).substring(0).replace("\r\n", "");
    }

    public static int resultMath(int a, String operator,int b) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> 0;
        };
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("8 + 6 = ");
        }
    }
}