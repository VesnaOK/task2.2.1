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

        Car car1 = new Car("BMW", 5);
        userService.add(new User("Ivan", "Ivanov", "iv@mail", car1));


        Car car2 = new Car("LADA", 1);
        userService.add(new User("Petr", "Petrov", "petr@mail", car2));


        Car car3 = new Car("AUDI", 3);
        userService.add(new User("Tom", "Tomov", "tom@mail", car3));

        System.out.println(userService.getUserWithCar("BMW", 5));
        System.out.println(userService.getUserWithCar("AUDI", 3));
        System.out.println(userService.getUserWithCar("LADA", 1));

        System.out.println(userService.listUsers());
        context.close();
    }
}

