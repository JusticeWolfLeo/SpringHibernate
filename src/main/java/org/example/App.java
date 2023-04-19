package org.example;

import dao.CarDao;
import dao.CarDaoHibernate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Наша первое CRUD приложение с работой Базы данных
 * CRUD
 * Create - создать пользовтаеля
 * Read - считать пользователя
 * Update - обновление
 * Delete - удаление
 */
public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        CarDao carDao = context.getBean(CarDao.class);
        carDao.saveCar("Toyota", "Corolla", "A998", 1998);
        carDao.getAllCars();
        carDao.saveCat("Snow");
        carDao.saveTortoise("Torty");
    }
}
