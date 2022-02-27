package interview.testAirport;

public class Flight {

    private String destination;
    private double price;

    public Flight(String destination, double price) {
        this.destination = destination;
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "desination='" + destination + '\'' +
                ", price=" + price +
                '}';
    }
}
