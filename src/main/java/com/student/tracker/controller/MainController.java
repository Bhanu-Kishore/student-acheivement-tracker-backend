package com.student.tracker.controller;

import com.student.tracker.model.User;
import com.student.tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class MainController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.registerUser(user));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(new ErrorResponse("Registration failed: " + e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User authenticated = userService.login(user.getUsername(), user.getPassword());
        return authenticated != null ? ResponseEntity.ok(authenticated) : ResponseEntity.status(401).body(new ErrorResponse("Invalid credentials"));
    }

    @GetMapping("/section/{sectionCode}")
    public ResponseEntity<List<User>> getUsersBySection(@PathVariable String sectionCode) {
        return ResponseEntity.ok(userService.getUsersBySection(sectionCode));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        try {
            userService.deleteUser(username);
            return ResponseEntity.ok(new ErrorResponse("User deleted successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(new ErrorResponse("Delete failed: " + e.getMessage()));
        }
    }

    public static class ErrorResponse {
        public String message;
        public ErrorResponse(String message) {
            this.message = message;
        }
    }
}
