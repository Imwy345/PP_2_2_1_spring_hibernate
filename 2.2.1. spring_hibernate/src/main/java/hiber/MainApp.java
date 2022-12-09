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

      User user1 = new User("Andre", "Vilson", "AV@mail.com");
      User user2 = new User("Vlad", "Reaber", "VD@mail.com");
      User user3 = new User("Roma", "Doolit", "RD@mail.com");

      Car car1 = new Car("Top_Tachka", 777);
      Car car2 = new Car("Norm_Tachka", 7);
      Car car3 = new Car("Neochen_Tachka", 123);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));

      System.out.println("1. Adds:");
      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
      }
      System.out.println("2. Search:");
      System.out.println(userService.getUserByCar("Norm_Tachka", 7));


      context.close();
   }
}
