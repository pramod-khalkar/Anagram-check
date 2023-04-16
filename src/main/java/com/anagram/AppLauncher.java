package com.anagram;

import java.util.List;
import java.util.Scanner;

/**
 * @author : Pramod Khalkar
 * description: This file belongs to Anagram-check
 **/
public class AppLauncher {

    public static void main(String[] args) {
        OperationFactory opFactory = new OperationFactory(new AnagramChecker(), new WordFileReader());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input string:");
        String input = scanner.nextLine();
        List<String> result = opFactory.getResult(input);
        System.out.println(result);
    }
}
