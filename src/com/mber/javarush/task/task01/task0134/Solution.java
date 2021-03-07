package com.mber.javarush.task.task01.task0134;

/*
Набираем воду в бассейн
*/

public class Solution {
    public static void main(String[] args) {
        // выводим на экран значение - результат вызова метода getVolume со
        // значениями аргументов 25, 5 и 2
        System.out.println(getVolume(25, 5, 2));
    }

    // метод getVolume, который считает объем в литрах для прямоугольного бассейна
    // с заданными размерами в метрах и возвращает это значение в качестве результата
    public static long getVolume(int a, int b, int c) {
        // объем в кубических метрах рассчитывается по формуле a * b * c, а так как
        // в 1 куб. м. 1000 литоров, то нужно еще умножить на 1000 оператор return
        // возращает результат работы метода
        return 1000L * a * b * c;
    }
}
