package com.pozdnyakov;

public  interface UserRepository {
    void register(User user);
    User findByUsername(String username);
}
