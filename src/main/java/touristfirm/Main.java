package touristfirm;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TouristFirm firm = new TouristFirm("Tourist firm A", LocalDate.of(2020, 5, 15));

        // Приклади створення турів із правильними та неправильними значеннями
        try {
            // Правильне створення туру
            Tour tour1 = new TourBuilder()
                    .setDestination("Italy")
                    .setDuration(7)
                    .setPrice(1200.50)
                    .build();
            firm.addTour(tour1);
            System.out.println("Tour added successfully: " + tour1);

            // Створення туру з некоректним полем `destination`
            Tour tour2 = new TourBuilder()
                    .setDestination("It@ly123")  // Невірний формат
                    .setDuration(5)
                    .setPrice(900.00)
                    .build();
            firm.addTour(tour2);

        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }

        try {
            // Створення туру з некоректним полем `duration`
            Tour tour3 = new TourBuilder()
                    .setDestination("France")
                    .setDuration(31)  // Поза межами [1, 30]
                    .setPrice(800.00)
                    .build();
            firm.addTour(tour3);

        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }

        try {
            // Створення туру з некоректним полем `price`
            Tour tour4 = new TourBuilder()
                    .setDestination("Spain")
                    .setDuration(10)
                    .setPrice(6000.00)  // Поза межами [50.0, 5000.0]
                    .build();
            firm.addTour(tour4);

        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }

        // Перевірка успішно створених турів та інформації про фірму
        System.out.println("Tours in firm: " + firm.fullInfo());
    }
}
