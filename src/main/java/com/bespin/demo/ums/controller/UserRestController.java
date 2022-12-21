package com.bespin.demo.ums.controller;

import com.bespin.demo.ums.entity.User;
import com.bespin.demo.ums.service.UserService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UserRestController {
  private final UserService userService;

  public UserRestController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("")
  public ResponseEntity<List<User>> list() {
    return new ResponseEntity<>(userService.fetchUsers(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> fetch(@PathVariable("id")Long id) {
    return new ResponseEntity<>(userService.fetch(id), HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<User> create(@RequestBody User user) {
    return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody User user) {
    return new ResponseEntity<>(userService.update(id, user), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id")Long id) {
    userService.delete(id);
    return new ResponseEntity<>(null, HttpStatus.OK);
  }

}
