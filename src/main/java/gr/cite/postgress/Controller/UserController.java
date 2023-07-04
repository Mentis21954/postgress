package gr.cite.postgress.Controller;

import gr.cite.postgress.Entity.User;;
import gr.cite.postgress.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> user = userRepo.findById(id);

        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user/{firstname}/{lastname}/{email}")
    public ResponseEntity<User> createUser(@PathVariable String firstname, @PathVariable String lastname, @PathVariable  String email) {
        User user = new User();
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);

        userRepo.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
