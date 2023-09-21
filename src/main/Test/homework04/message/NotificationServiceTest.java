package homework04.message;

/*Вам нужно написать тест с использованием моков для сервиса отправки сообщений.
Условие: У вас есть класс MessageService с методом public void sendMessage(String message, String
recipient), который отправляет сообщение получателю.
Вам необходимо проверить правильность работы класса NotificationService, который использует
MessageService для отправки уведомлений.
*/

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class NotificationServiceTest {

    @Test
    void messageServiceTest() {
         MessageService messageSer = new MessageService();
         NotificationService messageService = spy(new NotificationService(messageSer));


        messageService.sendNotification("Сообщение", " администатор");

        verify(messageService).sendNotification("Сообщение", " администатор");
    }
    @Test
    void testServiceMessage(){
        MessageService messageServiceMock = mock(MessageService.class);
        NotificationService messageService = new NotificationService(messageServiceMock);
        messageService.sendNotification("Сообщение", " администатор");

        verify(messageServiceMock, times(1)).sendMessage("Сообщение", " администатор");

    }


}