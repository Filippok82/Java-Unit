package hw;

import homework03.hw.MainHW;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class NumberIntervalTest {
    private MainHW numbers;

    @BeforeEach
    void setUps() {
        numbers = new MainHW();
    }
    @Test
    void numberIntervalTrue(){
        assertTrue(numbers.numberInInterval(60));
    }
    @Test
    void numberIntervalPositiveStartTrue(){
        assertTrue(numbers.numberInInterval(26));
    }
    @Test
    void numberIntervalPositiveEndTrue(){
        assertTrue(numbers.numberInInterval(99));
    }
    @Test
    void numberIntervalNegativeStartFalse(){
        assertFalse(numbers.numberInInterval(24));


    }
    @Test
    void numberIntervalNegativeEndFalse(){
        assertFalse(numbers.numberInInterval(101));


    }
}
