package com.mber.javarush.task.task10.task1001;

/*
Задача №1 на преобразование целых типов

Правильно расставь операторы приведения типа, чтобы получился ответ: d > 0.
*/

public class Solution {
    public static void main(String[] args) {
        int a = 0;
        int b = a + 46;
        byte c = (byte) (a * b);
        double f = 1234.15;
        long d = (long) (a + f / c + b);
        System.out.println(d);
    }
}

/*
TEMbI4 23 уровень
15 декабря 2019, 00:13
Разумное объяснение, почему при переводе больших int, long, doble к примитивам типа  byte, short.
К сожалению в статье об этом ни слова не говориться, но что бы понимать глубинную суть, нужно
разбираться в принципах  операций с двоичным кодом на уровне процессора. Итак...
Для преобразования больших чисел из doble  (больше чем 2^64)  в byte например, сначала происходит
преобразование в int - при этом значение устанавливается в Integrer.MAX =2147483647.
И уже после преобразуется в byte путем отбрасывания не помещающихся разрядов.
Число Integrer.MAX = 2147483647 в двоичной системе представляет из себя 31 единицу (1111.....111) в
byte всего 8 разрядов (причем первый занят под обозначения знака 0-положительное, 1 - отрицательное.
т.е. остается 7 для числа). Процессор видит остаток после отбрасывания (11111111) и по первой цифре
понимает, что это отрицательное число. Далее вступает в действие принцип формирования отрицательных
чисел в двоичной системе. Для этого используют дополнительный код (т.е. если прямой код числа 5 это
101, то дополнительный будет - инверсия прямого кода это будет 010 и в конце добавляется 1, т.е.
получится 110). Это делается для удобства сложения положительных и отрицательных чисел на уровне
процессора, для упрощения алгоритма сложения.
Возвращаясь к нашему числу, из числа 1 1111111 - мы путем преобразования к дополнительному коду
получаем 1 0000001 - вот от сюда и наша -1


Александр Backend Developer в ГазпромEXPERT
30 января 2019, 15:58
При деление дробных числе мы получаем бесконечность Infinity
f / c

Если сделать
Long.toBinaryString(d); //111111111111111111111111111111111111111111111111111111111111111

а когда мы запихиваем это в char - берется 8 знаков 1111 1111, остальное отбрасывается это
число -1 в двоичной системе.
*/
