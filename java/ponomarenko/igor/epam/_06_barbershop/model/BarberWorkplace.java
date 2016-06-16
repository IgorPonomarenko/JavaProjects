package ponomarenko.igor.epam._06_barbershop.model;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Igor on 14.06.2016.
 */
public class BarberWorkplace extends Thread{

    public static final long ONE_HAIRCUT_TIME = 300;
    BlockingQueue waitngRoomBQ;

    public BarberWorkplace(BlockingQueue waitngRoomBQ) {
        this.waitngRoomBQ = waitngRoomBQ;
    }

    @Override
    public void run() {
        Client client;
        boolean barberSleeps = false;
        while (true){
            try {
                if(waitngRoomBQ.size() == 0){
                    System.out.println("Waiting room is empty. Barber falls asleep.");
                    barberSleeps = true;
                }

                client = (Client) waitngRoomBQ.take();

                if (barberSleeps){
                    System.out.println("Barber woke up.");
                    barberSleeps = false;
                }

                System.out.println("Doing haircut for " + client);
                Thread.currentThread().sleep(ONE_HAIRCUT_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
