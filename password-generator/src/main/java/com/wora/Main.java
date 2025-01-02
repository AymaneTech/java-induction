package com.wora;

public class Main {
    public static void main(String[] args) {
        PasswordGenerator generator = new PasswordGenerator();

        System.out.println(generator.generatePassword());
        System.out.println(generator.generatePassword());
        System.out.println(generator.generatePassword());
        System.out.println(generator.generatePassword());

    }
}