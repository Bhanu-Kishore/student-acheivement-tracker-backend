package com.student.tracker.controller;

import com.student.tracker.model.User;
import com.student.tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080", "https://student-acheivement-tracker-fronten-swart.vercel.app", "https://*.vercel.app"}, allowCredentials = "true")
public class MainController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User authenticated = userService.login(user.getUsername(), user.getPassword());
        return authenticated != null ? ResponseEntity.ok(authenticated) : ResponseEntity.status(401).build();
    }

    @GetMapping("/section/{sectionCode}")
    public ResponseEntity<List<User>> getUsersBySection(@PathVariable String sectionCode) {
        return ResponseEntity.ok(userService.getUsersBySection(sectionCode));
    }
}