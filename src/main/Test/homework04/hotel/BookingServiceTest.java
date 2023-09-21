package homework04.hotel;
/*Вам необходимо написать тест с использованием моков для сервиса бронирования отелей.
Условие: У вас есть класс HotelService с методом public boolean isRoomAvailable(int roomId),
который обычно проверяет, доступен ли номер в отеле.
Вам необходимо проверить правильность работы класса BookingService, который
использует HotelService для бронирования номера, если он доступен.
*/



import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class BookingServiceTest {
    @Test
    void bookingServiceTest() {
        HotelService bookServiceMock = mock(HotelService.class);
        BookingService bookingService = new BookingService(bookServiceMock);


        when(bookingService.bookRoom(10)).thenReturn(true);

        assertTrue(bookServiceMock.isRoomAvailable(10));
    }

    @Test
    void testServiceBooking() {
        HotelService bookServiceMock = mock(HotelService.class);
        BookingService bookingService = new BookingService(bookServiceMock);

        bookingService.bookRoom(10);
        bookingService.bookRoom(10);
        verify(bookServiceMock, times(2)).isRoomAvailable(10);
    }
}