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
//        while ((bus.getSeats() > 0 && bus.getSeats()<=20) || (bus.getSeats() <= 20 && bus.getSeats() > 0)) {
//            pop(bus);
//            Thread.yield();
//        }
    }

    abstract void pop(Bus bus);
}
