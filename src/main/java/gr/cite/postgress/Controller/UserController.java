package gr.cite.postgress.Controller;

import gr.cite.postgress.Entity.User;
import gr.cite.postgress.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public List <User> getUsers() {
        return userService.read();
    }

    @GetMapping("/{id}")
    public ResponseEntity <User> getUserById(@PathVariable Long id){
       Optional<User> user = userService.read(id);

       if(!user.isPresent()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.create(user);

        return ResponseEntity.ok(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.update(user, id);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }


}
