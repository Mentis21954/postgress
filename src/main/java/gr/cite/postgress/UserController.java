package gr.cite.postgress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String homePage() {
        return "<html><h1>Home Page</h1></html>";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // other controller methods
}
