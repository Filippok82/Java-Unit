package homework04.database;

/*Вам требуется протестировать класс, который обрабатывает запросы к базе данных.
Условие: У вас есть класс Database с методом public List<String> query(String sql), который выполняет SQLзапрос и возвращает результат.
Вам необходимо проверить правильность работы класса DataProcessor, который использует Database для
выполнения запроса и обработки результатов.
*/

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DataProcessorTest {



    @Test
    void dataServiceTest() {
        Database databaseMock = mock(Database.class);
        DataProcessor dataProcessor= new DataProcessor(databaseMock);

        List<String> fakeData = new ArrayList<>();
        fakeData.add("1");
        fakeData.add("2");
        fakeData.add("3");

        when(databaseMock.query(String.valueOf(fakeData))).thenReturn(fakeData);
        assertThat(dataProcessor.processData(fakeData.toString())).isEqualTo(fakeData);
    }

    @Test
    void testServiceData(){
        Database databaseMock = mock(Database.class);
        DataProcessor dataProcessor= new DataProcessor(databaseMock);
        dataProcessor.processData("1");
        dataProcessor.processData("1");

        verify(databaseMock,times(2)).query("1");


    }
}