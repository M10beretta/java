package com.mber.javarush.task.analyz.task2009;

/*
Как сериализовать static?
*/

import java.io.Serializable;

public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;
    }

    public static void main(String[] args) {

    }
}