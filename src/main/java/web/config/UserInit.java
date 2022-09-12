package web.config;

import org.springframework.stereotype.Component;
import web.model.User;
import web.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class UserInit {
    private UserService userService;

    public UserInit(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        userService.addUser(new User("Anna", "SurAnna"));
        userService.addUser(new User("Tom", "SurTom"));
        userService.addUser(new User("Max", "SurMax"));
        userService.addUser(new User("Inna", "SurInna"));
    }
}
