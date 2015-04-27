public class Passenger {
    private String id;

    public Passenger(String id) {
        this.id = id;
    }

    public synchronized boolean getOn(Bus bus) {
        if (bus.getSeats() == 0) {
            System.out.println("The bus is full");
            return false;
        }
        bus.setSeats(bus.getSeats() - 1);
        System.out.println(String.format("%s passenger get on the bus, the seats are %s", id, bus.getSeats()));
        return true;
    }

    public synchronized boolean getOff(Bus bus) {
        if (bus.getSeats() == 20) {
            System.out.println("There is no passenger in the bus");
            return false;
        }
        bus.setSeats(bus.getSeats() + 1);
        System.out.println(String.format("passenger %s get off the bus, the seats are %s", id, bus.getSeats()));
        return true;
    }
}
