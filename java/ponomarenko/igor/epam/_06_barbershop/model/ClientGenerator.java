package ponomarenko.igor.epam._06_barbershop.model;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Igor on 14.06.2016.
 */
public class ClientGenerator extends Thread {

    private static long counter = 0;
    private BlockingQueue<Client> waitingRoomBQ;

    public ClientGenerator(BlockingQueue<Client> waitingRoomBQ) {
        this.waitingRoomBQ = waitingRoomBQ;
    }

    @Override
    public void run() {
        boolean enteredWaitingRoom = false;
        Client client;

        while (true) {

            client = new Client("Client " + counter++, "");
            enteredWaitingRoom = waitingRoomBQ.offer(client);

            if(enteredWaitingRoom){
                System.out.println(client + " entered waiting room. Total clients in the room: " + waitingRoomBQ.size());
            }else{
                System.out.println("Waiting room is out of capathity. " + client + " went to other barbershop.");
            }

            try {
                Thread.currentThread().sleep((long) (Math.random() * 100 + 30));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
