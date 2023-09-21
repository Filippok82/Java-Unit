package homework04.http;


import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*Вам нужно написать тест с использованием моков для класса, который выполняет HTTP-запросы.
Условие: У вас есть класс HttpClient с методом public String get(String url), который выполняет
HTTP-запрос и возвращает результат. Вам необходимо проверить правильность работы класса
WebService, который использует HttpClient для получения данных с веб-сайта.*/

class HttpClientTest {
    @Test
    void httpServiceTest() {

        HttpClient httpClient = new HttpClient();
        WebService webService = spy(new WebService(httpClient));


        webService.fetchDataFromWebsite("https://gb.ru/calendar");

        verify(webService).fetchDataFromWebsite("https://gb.ru/calendar");

    }

    @Test
    void testHttpService(){
        HttpClient httpClientMock = mock(HttpClient.class);
        WebService webService= new WebService(httpClientMock);

        webService.fetchDataFromWebsite("https://gb.ru/calendar");

        verify(httpClientMock, times(1)).getUrl("https://gb.ru/calendar");
    }
}