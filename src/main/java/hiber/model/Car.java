package hiber.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "series")
    private int series;
    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "car")
    private User user;
    public Car() {
    }

    public Car(int series, String name) {
        this.series = series;
        this.name = name;
    }

    public Car(int series, String name, User user) {
        this.series = series;
        this.name = name;
        this.user = user;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return series == car.series &&
                Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, series);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", series=" + series +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
