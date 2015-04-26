import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiQueue implements Runnable {
    private Queue queue2;
    private Queue queue3;
    private Queue queue1;
    private Queue getOffQueue;
    private Bus bus;

    public MultiQueue() {
        bus = new Bus(5);
        getOffQueue = new GetOffQueue(createPassengers("on queue", 10), bus);
        queue1 = new GetOnQueue(createPassengers("off queue 1", 5), bus);
        queue2 = new GetOnQueue(createPassengers("off queue 2", 5), bus);
        queue3 = new GetOnQueue(createPassengers("off queue 3", 5), bus);
    }

    private List<Passenger> createPassengers(String queueNum, int passengersNum) {
        ArrayList passengers = new ArrayList();
        for (int i = 0; i < passengersNum; i++) {
            passengers.add(new Passenger(String.format("No %s of Queue %s", i, queueNum)));
        }
        return passengers;
    }

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        MultiQueue multiQueue = new MultiQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Queue> queues = new ArrayList<>();
        queues.add(multiQueue.queue1);
        queues.add(multiQueue.queue2);
        queues.add(multiQueue.queue3);
        queues.add(multiQueue.getOffQueue);
        queues.stream().forEach(queue -> exec.execute(queue));
        exec.shutdown();
    }
}
