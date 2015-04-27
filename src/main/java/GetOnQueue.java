import java.util.List;

public class GetOnQueue extends Queue {

    public GetOnQueue(List<Passenger> passengers, Bus bus) {
        super(passengers, bus);
    }

    @Override
    public synchronized void pop(Bus bus) {
        if (passengers.get(0).getOn(bus)) {
            passengers.remove(0);
        }
    }

    @Override
    public synchronized void run() {
        while (!bus.readyToGo() && passengers.size() > 0) {
            pop(bus);
        }
    }
}
