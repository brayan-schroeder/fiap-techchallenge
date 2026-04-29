package com.fiap.techchallenge.controller;

import com.fiap.techchallenge.dto.PasswordRequest;
import com.fiap.techchallenge.entity.User;
import com.fiap.techchallenge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @GetMapping
    public List<User> list(@RequestParam(required = false) String name) {
        if (name != null) return service.search(name);
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return service.update(id, user);
    }

    @PatchMapping("/{id}/password")
    public void password(@PathVariable Long id,
                         @RequestBody PasswordRequest request) {
        service.updatePassword(id, request.getPassword());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}