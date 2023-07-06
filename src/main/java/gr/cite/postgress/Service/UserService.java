package gr.cite.postgress.Service;

import gr.cite.postgress.Entity.User;
import gr.cite.postgress.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public Optional<User> read(Long id) {
        return userRepository.findById(id);
    }

    public List<User> read() {
        return userRepository.findAll();
    }

    public User update(User user, Long id) {
        Optional <User> old_user = read(id);
        if(!old_user.isPresent()){
            return create(user);
        }

        user.setId(old_user.get().getId());
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
