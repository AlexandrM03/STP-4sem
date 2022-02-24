package lab5.task2.parking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    private static final int NUMBER_OF_CARS = 30;
    private static final int FIRST_PARKING = 4;
    private static final int SECOND_PARKING = 5;

    public static void main(String[] args) {
        Parking first_parking = new Parking(1, FIRST_PARKING);
        Parking second_parking = new Parking(2, SECOND_PARKING);
        Semaphore first = new Semaphore(first_parking.getSize(), true);
        Semaphore second = new Semaphore(second_parking.getSize(), true);
        ExecutorService service = Executors.newCachedThreadPool();

        for (int number = 1; number <= NUMBER_OF_CARS; ) {
            service.execute(new Car(first_parking, first, number++));
            service.execute(new Car(second_parking, second, number++));
        }

        service.shutdown();
    }
}
