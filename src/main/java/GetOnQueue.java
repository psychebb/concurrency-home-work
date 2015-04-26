import java.util.List;

public class GetOnQueue extends Queue {

    public GetOnQueue(List<Passenger> passengers, Bus bus) {
        super(passengers, bus);
    }

    @Override
    public synchronized void pop(Bus bus) {
        if (passengers.size() > 0 && passengers.get(0).getOn(bus)) {
            passengers.remove(0);
        }
    }

    @Override
    public synchronized void run() {
        while (bus.getSeats() > 0 && bus.getSeats() <= 20) {
            pop(bus);
        }
    }
}
