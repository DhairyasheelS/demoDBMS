package com.example.demoDBMS.EntityComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    // Create or update a user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        System.out.println("Received User: " + user.getEmail());
        System.out.println("Received Name :"+ user.getName());
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    //update a user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        // Check if the user exists
        Optional<User> existingUserOptional = userService.getUserById(id);
        if (existingUserOptional.isEmpty()) {
            return ResponseEntity.notFound().build(); // Return 404 if user not found
        }

        // Update the user fields with new data
        User existingUser = existingUserOptional.get();
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        // Set other fields as needed

        // Save the updated user
        User updatedUser = userService.saveUser(existingUser);
        return ResponseEntity.ok(updatedUser); // Return the updated user
    }


    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get user by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email)
    {
        Optional<User> user = userService.getUserByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
    *   @PathVariable extract data from URL (URL in header )
    * */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
