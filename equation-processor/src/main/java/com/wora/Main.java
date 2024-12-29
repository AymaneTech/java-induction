package com.wora;

import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print(">>>  ");
            final String source = SCANNER.nextLine();
            if (source == null)
                break;

            final Processor processor = new Processor(source, SCANNER);
            System.out.println(processor.evaluate());

        }
    }
}