package com.anagram;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author : Pramod Khalkar
 * description: This file belongs to Anagram-check
 **/
public class ApplicationTest {

    private static final String EXPECTED_ERROR_MESSAGE = "Couldn't able to find result for entered input";
    private final OperationFactory opFactory;

    ApplicationTest() {
        this.opFactory = new OperationFactory(new AnagramChecker(), new WordFileReader());
    }

    @Test
    public void positiveCaseWithFirstInput() {
        List<String> actualOutput = this.opFactory.getResult("tac");
        Assertions.assertEquals(2, actualOutput.size());

    }

    @Test
    public void positiveCaseWithSecondInput() {
        List<String> actualOutput = this.opFactory.getResult("tip");
        Assertions.assertEquals(1, actualOutput.size());
    }

    @Test
    public void positiveCaseWithOrderCheck() {
        List<String> actualOutput = this.opFactory.getResult("tar");
        List<String> expectedOutput = List.of("art", "rat");
        Assertions.assertEquals(expectedOutput.size(), actualOutput.size());
        Assertions.assertLinesMatch(expectedOutput, actualOutput);
    }

    @Test
    public void negativeCaseWithNoAnagramMatch() {
        Throwable actualException = Assertions.assertThrows(RuntimeException.class, () -> {
            this.opFactory.getResult("pra");
        });
        Assertions.assertEquals(EXPECTED_ERROR_MESSAGE, actualException.getMessage());
    }

    @Test
    public void negativeCaseWithEmptyInput() {
        Throwable actualException = Assertions.assertThrows(RuntimeException.class, () -> {
            this.opFactory.getResult("");
        });
        Assertions.assertEquals(EXPECTED_ERROR_MESSAGE, actualException.getMessage());
    }

    @Test
    public void negativeCaseWithSpaceInput() {
        Throwable actualException = Assertions.assertThrows(RuntimeException.class, () -> {
            this.opFactory.getResult(" ");
        });
        Assertions.assertEquals(EXPECTED_ERROR_MESSAGE, actualException.getMessage());
    }

    @Test
    public void negativeCaseWithNullInput() {
        Throwable actualException = Assertions.assertThrows(RuntimeException.class, () -> {
            this.opFactory.getResult(null);
        });
        Assertions.assertEquals(EXPECTED_ERROR_MESSAGE, actualException.getMessage());
    }

    @Test
    public void negativeCaseWithSpecialCharInput() {
        Throwable actualException = Assertions.assertThrows(RuntimeException.class, () -> {
            this.opFactory.getResult("pra%$");
        });
        Assertions.assertEquals(EXPECTED_ERROR_MESSAGE, actualException.getMessage());
    }
}
