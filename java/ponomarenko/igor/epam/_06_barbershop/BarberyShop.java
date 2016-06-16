package ponomarenko.igor.epam._06_barbershop;

import ponomarenko.igor.epam._06_barbershop.model.BarberWorkplace;
import ponomarenko.igor.epam._06_barbershop.model.Client;
import ponomarenko.igor.epam._06_barbershop.model.ClientGenerator;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Igor on 14.06.2016.
 */
public class BarberyShop {
    private static final int WAITING_ROOM_CAPATHITY = 10;

    public static void main(String[] args) {

        BlockingQueue<Client> waitingRoomBQ = new ArrayBlockingQueue(WAITING_ROOM_CAPATHITY);

        ClientGenerator generator = new ClientGenerator(waitingRoomBQ);
        BarberWorkplace barberWorkplace = new BarberWorkplace(waitingRoomBQ);

        generator.start();
        barberWorkplace.start();

    }
}
