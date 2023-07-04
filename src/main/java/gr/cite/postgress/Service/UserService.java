package gr.cite.postgress.Service;

import java.util.List;
import gr.cite.postgress.Entity.User;
import gr.cite.postgress.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> listAll() {
        return userRepo.findAll();
    }
}
