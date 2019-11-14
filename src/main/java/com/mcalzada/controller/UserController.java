package com.mcalzada.controller;

import com.mcalzada.controller.not_found.UserNotFoundException;
import com.mcalzada.crud.User;
import com.mcalzada.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * {@link UserController}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */
@RestController
public class UserController
{
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/users", produces = "application/json", consumes = "application/json")
    public List<User> getUsers()
    {
        System.out.println("Getting users");
        return userRepository.findAll();
    }

    @GetMapping(value = "/user/{id}", produces = "application/json", consumes = "application/json")
    public User getUser(@PathVariable Long id)
    {
        System.out.println("Getting users");
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    @PutMapping(value = "/user/{id}", produces = "application/json", consumes = "application/json")
    public User updateUser(@RequestBody User updateUser, @PathVariable Long id)
    {
        System.out.println("Updating user with ID " + id + " Update: " + updateUser.toString());
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(updateUser.getName());
                    user.setRole(updateUser.getRole());
                    return userRepository.save(updateUser);
                })
                .orElseGet(() -> {
                    updateUser.setId(id);
                    return userRepository.save(updateUser);
                });
    }

    @PostMapping(value = "/user", produces = "application/json", consumes = "application/json")
    public User createUser(@RequestBody User user)
    {
        System.out.println("Creating user " + user.toString());
        return userRepository.save(user);
    }

    @DeleteMapping(value = "/user/{id}", produces = "application/json", consumes = "application/json")
    public void deleteUser(@PathVariable Long id)
    {
        System.out.println("Deleting user with id: " + id);
        userRepository.deleteById(id);
    }
}
