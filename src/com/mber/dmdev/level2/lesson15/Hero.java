package com.mber.dmdev.level2.lesson15;

public abstract class Hero {

    private String name;
    private int damage;

    public Hero() {
    }

    public Hero(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public abstract void attackEnemy(Enemy enemy);


    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

}

