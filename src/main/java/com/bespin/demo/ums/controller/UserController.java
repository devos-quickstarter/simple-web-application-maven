package com.bespin.demo.ums.controller;

import com.bespin.demo.ums.entity.User;
import com.bespin.demo.ums.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    super();
    this.userService = userService;
  }

  @GetMapping("")
  public String landing() {
    return "index";
  }

  @GetMapping("/list")
  public String list(Model model) {
    model.addAttribute("users", userService.fetchUsers());
    return "list";
  }

  @GetMapping("/users/new")
  public String createUserForm(Model model) {
    User user = new User();
    model.addAttribute("user", user);
    return "create";
  }

  @PostMapping("/users")
  public String saveUser(@ModelAttribute("user") User user) {
    User user1 = userService.create(user);
    return "redirect:/list";
  }

  @GetMapping("/users/{id}")
  public String deleteUser(@PathVariable Long id) {
    userService.delete(id);
    return "redirect:/list";
  }
}
