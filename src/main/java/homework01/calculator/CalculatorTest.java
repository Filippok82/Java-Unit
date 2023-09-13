package homework01.calculator;

import homework01.calculator.Calculator;

import static org.assertj.core.api.Assertions.*;


public class CalculatorTest {
    public static void main(String[] args) {
        // Проверка базового функционала с целыми числами:
        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе");
        }

        // Случаи с неправильными аргументами
        // аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
        try {
            Calculator.calculation(8, 4, '_');
        } catch (IllegalStateException e) {
            if (!e.getMessage().equals("Unexpected value operator: _")) {
                throw new AssertionError("Ошибка в методе");
            }
        }

        // Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 8 == Calculator.calculation(2, 6, '+');
        assert 0 == Calculator.calculation(2, 2, '-');
        assert 14 == Calculator.calculation(2, 7, '*');
        assert 2 == Calculator.calculation(100, 50, '/');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);

        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
        assertThatThrownBy(() ->
                Calculator.calculation(8, 4, '_')
        ).isInstanceOf(IllegalStateException.class);

        System.out.println(Calculator.calculation(2_147_483_647, 1, '+')); // integer overflow
        System.out.println(Calculator.squareRootExtraction(169));


        //Задание 1. ** В классе Calculator создайте метод calculateDiscount, который принимает сумму
        // покупки и процент скидки и возвращает сумму с учетом скидки. Ваша задача - проверить этот
        // метод с использованием библиотеки AssertJ. Если метод calculateDiscount получает недопустимые
        // аргументы, он должен выбрасывать исключение ArithmeticException. Не забудьте написать тесты
        // для проверки этого поведения.


        System.out.println(Calculator.calculatingDiscount(-2000, -10));
        assertThat(Calculator.calculatingDiscount(2000, 50))
                .isEqualTo(1000); // обычная скидка
        assertThat(Calculator.calculatingDiscount(2000, 100))
                .isEqualTo(0); // обычная скидка
        assertThat(Calculator.calculatingDiscount(2000, 0))
                .isEqualTo(2000); // обычная скидка


        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(2000, 110))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть от 0 до 100%"); // процент скидки больше 100%

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(2000, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть от 0 до 100%"); // процент скидки меньше 0

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(-2000, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Цена не может быть отрицательной"); // процент скидки меньше 0
    }

    }

