package hw;


import homework03.hw.MainHW;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckingNumberTest {
    private MainHW numbers;

    @BeforeEach
    void setUps() {
        numbers = new MainHW();
    }

    @Test
    void evenNumber(){
        assertTrue(numbers.evenOddNumber(8));
    }
    @Test
    void oddNumber(){
        assertFalse(numbers.evenOddNumber(17));
    }
}
