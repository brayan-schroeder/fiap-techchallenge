package com.fiap.techchallenge.service;

import com.fiap.techchallenge.dto.LoginRequest;
import com.fiap.techchallenge.entity.User;
import com.fiap.techchallenge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User create(User user) {
        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public List<User> search(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public User update(Long id, User data) {
        User user = findById(id);

        user.setName(data.getName());
        user.setEmail(data.getEmail());
        user.setLogin(data.getLogin());
        user.setRole(data.getRole());
        user.setAddress(data.getAddress());

        return repository.save(user);
    }

    public void updatePassword(Long id, String password) {
        User user = findById(id);

        user.setPassword(password);

        repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public boolean login(LoginRequest request) {
        return repository
                .findByLoginAndPassword(request.getLogin(), request.getPassword())
                .isPresent();
    }
}