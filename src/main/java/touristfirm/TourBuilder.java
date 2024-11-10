package touristfirm;

import java.util.regex.Pattern;

public class TourBuilder {
    private String destination;
    private int duration; // in days
    private double price;

    // Обмеження на поля
    private static final int MIN_DURATION = 1;
    private static final int MAX_DURATION = 30;
    private static final double MIN_PRICE = 50.0;
    private static final double MAX_PRICE = 5000.0;
    private static final Pattern DESTINATION_PATTERN = Pattern.compile("^[A-Za-z ]+$");

    // Сеттер для destination (без валідації на цьому етапі)
    public TourBuilder setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    // Сеттер для duration (без валідації на цьому етапі)
    public TourBuilder setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    // Сеттер для price (без валідації на цьому етапі)
    public TourBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    // Метод build() для створення екземпляра Tour з перевіркою всіх значень
    public Tour build() {
        StringBuilder invalidFields = new StringBuilder();

        // Перевірка значень полів
        if (destination == null || !DESTINATION_PATTERN.matcher(destination).matches()) {
            invalidFields.append("destination='").append(destination).append("' (must only contain letters and spaces); ");
        }
        if (duration < MIN_DURATION || duration > MAX_DURATION) {
            invalidFields.append("duration=").append(duration)
                    .append(" (must be between ").append(MIN_DURATION).append(" and ").append(MAX_DURATION).append(" days); ");
        }
        if (price < MIN_PRICE || price > MAX_PRICE) {
            invalidFields.append("price=").append(price)
                    .append(" (must be between ").append(MIN_PRICE).append(" and ").append(MAX_PRICE).append("); ");
        }

        // Перевірка на наявність невалідних значень
        if (invalidFields.length() > 0) {
            throw new IllegalArgumentException("Invalid values for fields: " + invalidFields);
        }

        // Повернення нового об'єкта Tour
        return new Tour(this);
    }

    // Гетери для доступу до полів з Tour
    public String getDestination() {
        return destination;
    }

    public int getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }
}
