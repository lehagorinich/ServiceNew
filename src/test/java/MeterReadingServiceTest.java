import com.pozdnyakov.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class MeterReadingServiceTest {
    private InMemoryMeterReadingRepository inMemoryMeterReadingRepository;
    private MeterReadingService meterReadingService;
    private User testUser;

    @BeforeEach
    void setUp() {
        inMemoryMeterReadingRepository = new InMemoryMeterReadingRepository();
        meterReadingService = new MeterReadingService(inMemoryMeterReadingRepository);
        testUser = new User("testUser", "password", false);
    }

    @Test
    void testSubmitReading() {
        Map<String, Integer> readings = new HashMap<>();
        readings.put("electricity", 100);
        readings.put("water", 50);
        meterReadingService.submitReading(testUser, 2022, 1, readings);
        List<MeterReading> readingsByMonth = meterReadingService.getReadingsByMonth(testUser, 2022, 1);
        assertEquals(1, readingsByMonth.size());
    }
}
