package gr.cite.postgress.Controller;

import gr.cite.postgress.Entity.User;;
import gr.cite.postgress.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService user;

    @GetMapping("/")
    public List<User> getUsers() {
        return user.listAll();
    }

    // other controller methods
}
