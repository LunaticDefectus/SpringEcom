package defectus.com.springecom.services;

import defectus.com.springecom.dao.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserManager {
    Integer IsValidUser(String email, String password);
    void register(User new_user);
    public List<User> getAllUsers();
    public Optional<User> getUserById(Integer id);
    public User updateUser(User user);
    public void deleteUser(Integer id);
}
