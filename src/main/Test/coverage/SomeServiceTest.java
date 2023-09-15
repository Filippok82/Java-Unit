package coverage;

import homework03.coverage.SomeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {

    @Test
    void returnsFizz() {
        // assertEquals...
        SomeService someService = new SomeService();
        assertEquals(someService.fizzBuzz(3), "Fizz");
    }

    @Test
    void returnsBuzz() {
        // assertEquals...
        SomeService someService = new SomeService();
        assertEquals(someService.fizzBuzz(5), "Buzz");
    }

    @Test
    void returnsFizzBuzz() {
        // assertEquals...
        SomeService someService = new SomeService();
        assertEquals(someService.fizzBuzz(15), "FizzBuzz");
    }

    @Test
    void returnsNumberBuzz() {
        // assertEquals...
        SomeService someService = new SomeService();
        assertEquals(someService.fizzBuzz(23), "23");
    }
    private SomeService someService;

    @BeforeEach
    void setUp(){someService = new SomeService();
    }
    @Test
    void firstElementSix() {
        assertTrue(someService.firstLast6(new int[]{6, 1, 2, 3}));
    }

    @Test
    void lastElementSix() {
        assertTrue(someService.firstLast6(new int[]{3, 1, 2, 3, 6}));
    }

    @Test
    void lastAndFirstElementNotSix() {
        assertFalse(someService.firstLast6(new int[]{3, 1, 2, 3, 7}));
    }


    @Test
    void luckyABC() {
        assertEquals(someService.luckySum(3, 2, 2), 7);
    }

    @Test
    void luckyBC() {
        assertEquals(someService.luckySum(13, 2, 2), 4);
    }

    @Test
    void luckyAC() {
        assertEquals(someService.luckySum(3, 13, 2), 5);
    }

    @Test
    void luckyAB() {
        assertEquals(someService.luckySum(3, 3, 13), 6);
    }

}