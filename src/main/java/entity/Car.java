package entity;

import dto.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Cars", schema = "testbase")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String stamp;

    @Column
    private String model;

    @Column
    private String state_number;

    @Column
    private int age;
    @Embedded
    private Driver driver;

    public Car(String stamp, String model, String state_number, int age) {
        this.stamp = stamp;
        this.model = model;
        this.state_number = state_number;
        this.age = age;
    }
}
