package dao;

import dto.Driver;
import entity.Car;
import entity.Cat;
import entity.Tortoise;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoHibernate implements CarDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void truncateCarTable() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("delete from Car");
    }

    /*public void dropCarTable() {
        Transaction transaction = null;
        try (Session session = Config.sessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("DROP TABLE IF EXISTS cars");
            query.executeUpdate();
            transaction.commit();
            System.out.println("Нам удалось успешно удалить таблицу машин");
        } catch (Exception e) {
            if (transaction != null || transaction.getStatus() == ACTIVE
                    || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
                System.out.println("Транзакция удаления отменена");
            }
        }
    }*/

    @Transactional
    public void saveCar(String stamp, String model, String state_number, int age) {
        sessionFactory.getCurrentSession().save(new Car(stamp, model, state_number, age));
    }


    @Transactional
    public List<Car> getAllCars() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }

    @Transactional
    public Car getCarById(long id) {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car where :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Transactional
    public void saveCat(String name) {
        Cat cat = new Cat("Mewww", "white");
        cat.setType("Cat");
        cat.setName(name);
        sessionFactory.getCurrentSession().save(cat);
    }

    @Transactional
    public void saveTortoise(String name) {
        Tortoise tortoise = new Tortoise("Psssshhhh", "green");
        tortoise.setType("Tortoise");
        tortoise.setName(name);
        sessionFactory.getCurrentSession().save(tortoise);
    }

}


