package gr.cite.postgress.Controller;

import gr.cite.postgress.DTO.UserDTO;
import gr.cite.postgress.Entity.User;
import gr.cite.postgress.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/users")
    public List <UserDTO> getUsers() {
        return userService.read().stream().map(user -> modelMapper.map(user,UserDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity <UserDTO> getUserById(@PathVariable Long id){
       Optional<User> user = userService.read(id);

       if(!user.isPresent()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       UserDTO userDTO = modelMapper.map(user,UserDTO.class);

       return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping("users/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        userService.create(user);

        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.update(user, id);

        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }


}
