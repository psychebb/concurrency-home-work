import java.util.List;

public class GetOffQueue {

    private List<Passenger> passengers;

    public GetOffQueue(List<Passenger> passengers) {
        this.passengers = passengers;
    }


    public synchronized void pop(Bus bus) {
        if (passengers.size() > 0 && passengers.get(0).getOff(bus)) {
            passengers.remove(0);
        }
    }

    public int getPassengers() {
        return passengers.size();
    }
}
