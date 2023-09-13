

import homework02.Car;
import homework02.Motorcycle;
import homework02.Vehicle;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class VehicleTest {

    Car car = new Car("Volvo","xc90",2018);
    Motorcycle bike = new Motorcycle("BMW", "F800R", 2016);

//    - проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)


    @Test
    void tesObjectInstanceVehicle() {

        assertInstanceOf((Vehicle.class), car);
    }


//    - проверка того, объект Car создается с 4-мя колесами
    @Test
    void testCarCreatedWithFourWheels(){
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

//    - проверка того, объект Motorcycle создается с 2-мя колесами

    @Test
    void testBikeCreatedWithTwoWheels(){
        assertThat(bike.getNumWheels()).isEqualTo(2);
    }

//    - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
    @Test
    void testCarDevelopsSpeedTestDriving(){
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }
//     - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
    @Test
    void testBikeDevelopsSpeedTestDriving(){
        bike.testDrive();
        assertThat(bike.getSpeed()).isEqualTo(75);
    }
    //- проверить, что в режиме парковки (сначала testDrive, потом park,
    // т.е эмуляция движения транспорта) машина останавливается (speed = 0)
    @Test
    void testMotionEmulationCar() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    //- проверить, что в режиме парковки (сначала testDrive, потом park
    // т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)

    @Test
    void testMotionEmulationBike() {
        bike.testDrive();
        bike.park();
        assertThat(bike.getSpeed()).isEqualTo(0);
    }
}


