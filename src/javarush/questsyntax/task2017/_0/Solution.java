package javarush.questsyntax.task2017._0;

import java.io.ObjectInputStream;
import java.io.Serializable;

/*
Десериализация
*/

public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            return (Solution.A) objectStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}

