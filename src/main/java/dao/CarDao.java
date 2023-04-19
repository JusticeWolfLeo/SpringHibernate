package dao;

import entity.Car;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CarDao {
    void truncateCarTable();

    void saveCar(String stamp, String model, String state_number, int age);



    List<Car> getAllCars();

    Car getCarById(long id);

    void saveCat(String name);
    void saveTortoise(String name);
}
