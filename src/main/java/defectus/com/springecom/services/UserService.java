package defectus.com.springecom.services;

import defectus.com.springecom.dao.entities.User;
import defectus.com.springecom.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserManager {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Integer IsValidUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email,password).getId();
    }

    @Override
    public void register(User user) {
        userRepository.save(user);
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }
    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

}

