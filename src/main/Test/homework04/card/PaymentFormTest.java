package homework04.card;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PaymentFormTest {

    /**
     * 4.2. Используя библиотеку Mockito, напишите модульные тесты для проверки функциональности формы оплаты на сайте.
     * * Вместо реальной кредитной карты используйте мок-объект.
     * Создайте класс `CreditCard` с методами `getCardNumber()`, `getCardHolder()`, `getExpiryDate()`, `getCvv()`, `charge(double amount)`.
     * Создайте класс `PaymentForm` с методом `pay(double amount)`.
     * В тестовом классе, создайте мок-объект для класса `CreditCard`.
     * Определите поведение мок-объекта с помощью метода `when()`.
     * Создайте объект класса `PaymentForm`, передайте ему мок-объект в качестве аргумента.
     * Вызовите метод `pay()` и убедитесь, что мок-объект вызывает метод `charge()`
     */

    @Test
    void getCartHolder(){
        CreditCard creditCardMock = mock(CreditCard.class);
        when(creditCardMock.getCardHolder()).thenReturn("Карта");
        assertEquals(creditCardMock.getCardHolder(),"Карта");

    }
    @Test
    void payTest() {
        CreditCard creditCardMock = mock(CreditCard.class);
        PaymentForm paymentFormMock = new PaymentForm(creditCardMock);

        paymentFormMock.pay(25.5);
        paymentFormMock.pay(25.5);
        verify(creditCardMock, times(2)).charge(25.5);
    }


}