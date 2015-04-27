public class Bus implements Runnable{
    private int seats;
    private GetOffQueue offQueue;

    public Bus(int seats, GetOffQueue offQueue) {
        this.seats = seats;
        this.offQueue = offQueue;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean readyToGo() {
        return getSeats() == 20 && offQueue.getPassengers() == 0;
    }

    @Override
    public synchronized void run() {
        while (offQueue.getPassengers() > 0) {
            offQueue.pop(this);
        }
    }
}
