package touristfirm;

import java.util.Objects;

public class Tour {
    private String destination;
    private int duration; // in days
    private double price;

    // Конструктор, який приймає об'єкт TourBuilder
    public Tour(TourBuilder builder) {
        this.destination = builder.getDestination();
        this.duration = builder.getDuration();
        this.price = builder.getPrice();
    }

    public String getDestination() {
        return destination;
    }

    public int getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "destination='" + destination + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tour)) return false;
        Tour tour = (Tour) o;
        return duration == tour.duration &&
                Double.compare(tour.price, price) == 0 &&
                Objects.equals(destination, tour.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, duration, price);
    }
}
