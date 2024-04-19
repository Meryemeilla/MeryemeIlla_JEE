package ma.fsm.jpafsm;

import ma.fsm.jpafsm.entities.Role;
import ma.fsm.jpafsm.entities.User;
import ma.fsm.jpafsm.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaFsmApplication {

    public static void main(String[] args) {

        SpringApplication.run(JpaFsmApplication.class, args);
    }
    @Bean
    CommandLineRunner start(UserService userService) {
        return args -> {
            User u = new User();
            u.setUsername("user1");
            u.setPassword("123456");
            userService.addNewUser(u);

            User u2 = new User();
            u2.setUsername("admin");
            u2.setPassword("123456");
            userService.addNewUser(u2);

            Stream.of("STUDENT", "USER", "ADMIN").forEach(r -> {
                Role role1 = new Role();
                role1.setRoleName(r);
                userService.addNewRole(role1);
            });
            userService.addRoleToUser("user1", "STUDENT");
            userService.addRoleToUser("user1", "USER");
            userService.addRoleToUser("admin", "USER");
            userService.addRoleToUser("admin", "ADMIN");
            Role role1 = new Role();
            role1.setRoleName("STUDENT");
            //  userService.addNewRole(role1);
            try {
                User user = userService.authenticate("user1", "123456");
                System.out.println(user.getUserId());
                System.out.println(user.getUsername());
                user.getRoles().forEach(r -> {
                    System.out.println("Roles =>" + r.toString());
                });

            } catch (Exception e) {
                e.printStackTrace();

            };

        };
    }

}
