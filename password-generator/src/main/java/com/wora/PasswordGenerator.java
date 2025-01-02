package com.wora;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PasswordGenerator {
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "$#%";
    private static final Random RANDOM = new Random();

    public String generatePassword() {
        final Stream<Character> numbers = generateRandomChars(NUMBERS, 4);
        final Stream<Character> letters = generateRandomChars(UPPERCASE_CHARS, 2);
        final Stream<Character> symbols = generateRandomChars(SYMBOLS, 2);

        final List<Character> password = Stream.concat(
                        Stream.concat(numbers, letters),
                        symbols
                )
                .collect(Collectors.toList());

        Collections.shuffle(password);

        return password.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private Stream<Character> generateRandomChars(final String source, final int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> source.charAt(RANDOM.nextInt(source.length())));
    }
}
