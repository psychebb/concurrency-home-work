import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiQueue {
    private Queue queue2;
    private Queue queue3;
    private Queue queue1;
    private GetOffQueue getOffQueue;
    private Bus bus;

    public MultiQueue() {
        getOffQueue = new GetOffQueue(createPassengers("Off", 10));
        bus = new Bus(5, getOffQueue);
        queue1 = new GetOnQueue(createPassengers("On 1", 5), bus);
        queue2 = new GetOnQueue(createPassengers("On 2", 5), bus);
        queue3 = new GetOnQueue(createPassengers("On 3", 5), bus);
    }

    private List<Passenger> createPassengers(String queueNum, int passengersNum) {
        ArrayList passengers = new ArrayList();
        for (int i = 0; i < passengersNum; i++) {
            passengers.add(new Passenger(String.format("No %s of Queue %s", i, queueNum)));
        }
        return passengers;
    }

    public static void main(String[] args) {
        MultiQueue multiQueue = new MultiQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Runnable> queues = new ArrayList<>();
        queues.add(multiQueue.queue1);
        queues.add(multiQueue.queue2);
        queues.add(multiQueue.queue3);
        queues.add(multiQueue.bus);
        queues.stream().forEach(queue -> exec.execute(queue));
        exec.shutdown();
    }
}
