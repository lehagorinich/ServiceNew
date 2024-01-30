package com.pozdnyakov;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository{
    private Map<String, User> users;

    public InMemoryUserRepository() {
        this.users = new HashMap<>();
    }
    @Override
    public void register(User user) {
        users.put(user.getUsername(),user);
    }

    @Override
    public User findByUsername(String username) {
        return users.get(username);
    }
}
