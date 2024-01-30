import com.pozdnyakov.InMemoryUserRepository;
import com.pozdnyakov.User;
import com.pozdnyakov.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private InMemoryUserRepository inMemoryUserRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        inMemoryUserRepository = new InMemoryUserRepository();
        userService = new UserService(inMemoryUserRepository);
    }

    @Test
    void testRegisterUser() {
        userService.register("testUser", "password");
        User user = inMemoryUserRepository.findByUsername("testUser");
        assertNotNull(user);
        assertEquals("testUser", user.getUsername());
    }

    @Test
    void testLoginWithValidCredentials() {
        userService.register("testUser", "password");
        User user = userService.login("testUser", "password");
        assertNotNull(user);
        assertEquals("testUser", user.getUsername());
    }

    @Test
    void testLoginWithInvalidCredentials() {
        userService.register("testUser", "password");
        User user = userService.login("testUser", "wrongPassword");
        assertNull(user);
    }
}


