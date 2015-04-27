import java.util.List;

public abstract class Queue implements Runnable {
    protected List<Passenger> passengers;
    protected Bus bus;

    public Queue(List<Passenger> passengers, Bus bus) {
        this.bus = bus;
        this.passengers = passengers;
    }

    @Override
    public void run() {
    }

    abstract void pop(Bus bus);
}
