package com.bespin.demo.ums.service.impl;

import com.bespin.demo.ums.entity.User;
import com.bespin.demo.ums.service.UserService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
  private static Map<Long, User> userMap = new HashMap<>();
  private static Long index = 9L;

  static {
    User james = new User(1L, "james", "james@demo.com");
    User john = new User(2L, "john", "john.com");
    User robert = new User(3L, "robert", "robert@demo.com");
    User michael = new User(4L, "michael", "michael@demo.com");
    User william = new User(5L, "william", "william@demo.com");
    User david = new User(6L, "david", "david@demo.com");
    User richard = new User(7L, "richard", "richard@demo.com");
    User joseph = new User(8L, "joseph", "joseph@demo.com");
    User thomas = new User(9L, "thomas", "thomas@demo.com");
    userMap.put(james.getId(), james);
    userMap.put(john.getId(), john);
    userMap.put(robert.getId(), robert);
    userMap.put(michael.getId(), michael);
    userMap.put(william.getId(), william);
    userMap.put(david.getId(), david);
    userMap.put(richard.getId(), richard);
    userMap.put(joseph.getId(), joseph);
    userMap.put(thomas.getId(), thomas);
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

  @Override
  public List<User> fetchUsers() {
    LOGGER.info("fetch User List");
    return new ArrayList<>(userMap.values());
  }

  @Override
  public User fetch(Long id) {
    LOGGER.info("fetch User Id : {}", id);
    return userMap.get(id);
  }

  @Override
  public User create(User user) {
    LOGGER.info("create user {}", user);
    index += 1L;
    user.setId(index);
    userMap.put(index, user);
    return user;
  }

  @Override
  public User update(Long id, User user) {
    LOGGER.info("update user id {}", id);
    User foundUser = fetch(id);
    foundUser.setName(user.getName());
    foundUser.setEmail(user.getEmail());
    userMap.put(foundUser.getId(), foundUser);
    return foundUser;
  }

  @Override
  public void delete(Long id) {
    LOGGER.info("delete user.");
    userMap.remove(id);
  }
}
