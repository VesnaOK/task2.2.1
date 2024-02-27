package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Ivan", "Ivanov", "iv@mail");
        Car car1 = new Car("BMW", 5);
        car1.setUser(user1);
        userService.add(user1);
        userService.add(car1);

        User user2 = new User("Petr", "Petrov", "petr@mail");
        Car car2 = new Car("LADA", 1);
        car2.setUser(user2);
        userService.add(user2);
        userService.add(car2);

        User user3 = new User("Tom", "Tomov", "tom@mail");
        Car car3 = new Car("AUDI", 3);
        car3.setUser(user3);
        userService.add(user3);
        userService.add(car3);

        System.out.println(userService.getUserWithCar("BMW", 5));
        System.out.println(userService.getUserWithCar("AUDI", 3));
        System.out.println(userService.getUserWithCar("LADA", 1));

        System.out.println(userService.listUsers());
        context.close();
    }
}

