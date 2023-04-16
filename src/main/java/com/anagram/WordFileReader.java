package com.anagram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author : Pramod Khalkar
 * description: This file belongs to Anagram-check
 **/
public class WordFileReader implements Reader {

    private static final String FILE_NAME = "words.txt";

    @Override
    public Stream<String> getStream() {
        String fPath = Objects.requireNonNull(getClass().getClassLoader().getResource(FILE_NAME)).getPath();
        try {
            return Files.lines(Paths.get(fPath));
        } catch (IOException e) {
            System.out.printf("couldn't able to load words.txt, %s", e);
            return Stream.empty();
        }
    }
}
