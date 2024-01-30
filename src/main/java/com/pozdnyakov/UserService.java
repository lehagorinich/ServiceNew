package com.pozdnyakov;

public class UserService {
    private InMemoryUserRepository inMemoryUserRepository;

    public UserService(InMemoryUserRepository inMemoryUserRepository) {
        this.inMemoryUserRepository=inMemoryUserRepository;
    }

    public void register(String username, String password) {
        User user = new User(username, password, false);
        inMemoryUserRepository.register(user);
    }

    public User login(String username, String password) {
        User user = inMemoryUserRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
