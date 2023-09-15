
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import homework03.coverage.SomeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculationDiscontTest {
    private SomeService calculationDiscont;

    @BeforeEach
    void setUp() {
        calculationDiscont = new SomeService();
    }

    @Test
    void correctSummAndDiscont() {
        assertEquals(calculationDiscont.calculatingDiscount(100, 10), 90);
    }

    @Test
    void summAndZeroDiscont() {
        assertEquals(calculationDiscont.calculatingDiscount(100, 0), 100);
    }

    @Test
    void summAndFullDiscont() {
        assertEquals(calculationDiscont.calculatingDiscount(100, 100), 0);
    }

    @Test
    void summZeroAndDiscont() {
        assertEquals(calculationDiscont.calculatingDiscount(0, 10), 0);
    }

    @Test
    void summAndOutDiscont() {
        assertThatThrownBy(() -> calculationDiscont.calculatingDiscount(2000.0, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    @Test
    void summSubZeroAndDiscont() {
        assertThatThrownBy(() -> calculationDiscont.calculatingDiscount(-1, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");
    }

}
