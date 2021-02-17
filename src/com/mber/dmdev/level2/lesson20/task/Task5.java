package com.mber.dmdev.level2.lesson20.task;

import com.mber.dmdev.level2.lesson20.exception.MberException;

/**
 * 5. Бросить одно из существующих в JDK исключений, отловить его и
 * выбросить своё собственное, указав в качестве причины отловленное.
 */
public class Task5 {

    public static void main(String[] args) {
        try {
            catchCustomException();
        } catch (MberException exception) {
            System.out.println("catched in main");
            exception.printStackTrace();
        }
    }

    private static void catchCustomException() {
        try {
            unsafe();
        } catch (RuntimeException exception) {
            System.out.println("catch in catchCustomException method");
            throw new MberException(exception);
        }
    }

    public static void unsafe(){
        throw new RuntimeException("oops");
    }
}
