package touristfirm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TouristFirm {
    private String name;
    private LocalDate registrationDate;
    private List<Tour> tours;

    /**
     * Конструктор з двома параметрами: назва фірми та дата заснування.
     *
     * @param name             назва туристичної фірми
     * @param registrationDate дата заснування туристичної фірми
     */
    public TouristFirm(String name, LocalDate registrationDate) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.tours = new ArrayList<>();
    }

    /**
     * Конструктор з одним параметром: назва фірми.
     *
     * @param name назва туристичної фірми
     */
    public TouristFirm(String name) {
        this(name, LocalDate.now());  // Якщо дата не вказана, то використовуємо поточну дату
    }

    /**
     * Сеттер для дати заснування фірми.
     *
     * @param registrationDate нова дата заснування
     */
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * Додає тур до списку турів туристичної фірми.
     *
     * @param tour тур для додавання
     */
    public void addTour(Tour tour) {
        tours.add(tour);
    }

    @Override
    public String toString() {
        return "TouristFirm{" +
                "name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public String fullInfo() {
        return "TouristFirm{" +
                "name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                ", tours=" + tours +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TouristFirm)) return false;
        TouristFirm that = (TouristFirm) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(registrationDate, that.registrationDate) &&
                Objects.equals(tours, that.tours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, registrationDate, tours);
    }
}
