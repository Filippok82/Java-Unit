package homework04.weather;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/*Предположим, у вас есть класс WeatherService, который имеет метод getCurrentTemperature(),
обращающийся к внешнему API для получения информации о текущей температуре.
Вам нужно протестировать другой класс, WeatherReporter, который использует WeatherService.
Создайте мок-объект для WeatherService с использованием Mockito.
*/

class WeatherReporterTest {
    @Test
    void weatherServiceTest(){
        WeatherService weatherServiceMock = mock(WeatherService.class);

        when(weatherServiceMock.getCurrentTemperature()).thenReturn(24);

        assertThat(weatherServiceMock.getCurrentTemperature()).isEqualTo(24);

    }

    @Test
    void extracted() {
        WeatherService weatherServiceMock = mock(WeatherService.class);
        WeatherReporter weatherReporterMock = new WeatherReporter(weatherServiceMock);

        weatherReporterMock.generateReport();

        verify(weatherServiceMock, times(1)).getCurrentTemperature();
    }

}