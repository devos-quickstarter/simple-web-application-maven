package com.bespin.demo.ums.service;

import com.bespin.demo.ums.entity.User;
import java.util.List;

public interface UserService {

  List<User> fetchUsers();

  User fetch(Long id);

  User create(User user);

  User update(Long id, User user);

  void delete(Long id);
}
