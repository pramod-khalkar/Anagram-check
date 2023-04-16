package com.anagram;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : Pramod Khalkar
 * description: This file belongs to Anagram-check
 **/
public class OperationFactory {

    private Checker checker;
    private Reader reader;

    OperationFactory(Checker checker, Reader reader) {
        this.checker = checker;
        this.reader = reader;
    }

    /**
     * apply checker on reader and get the result
     *
     * @param input
     * @return
     */
    public List<String> getResult(String input) {
        return reader.getStream()
                .filter(w -> !Objects.equals(w, input) && checker.check(w, input))
                .sorted()
                .collect(Collectors.collectingAndThen(Collectors.toList(), this::throwExceptionIfEmpty));
    }

    private List<String> throwExceptionIfEmpty(List<String> result) {
        if (result.size() == 0) {
            throw new RuntimeException("Couldn't able to find result for entered input");
        } else {
            return result;
        }
    }
}
