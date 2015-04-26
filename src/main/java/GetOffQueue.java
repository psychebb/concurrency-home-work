import java.util.List;

public class GetOffQueue extends Queue{
    public GetOffQueue(List<Passenger> passengers, Bus bus) {
        super(passengers, bus);
    }

    @Override
    public synchronized void pop(Bus bus) {
        if (passengers.size() > 0 && passengers.get(0).getOff(bus)) {
            passengers.remove(0);
        }
    }

    @Override
    public synchronized void run() {
        while (bus.getSeats() <= 20) {
            pop(bus);
        }
    }

}
