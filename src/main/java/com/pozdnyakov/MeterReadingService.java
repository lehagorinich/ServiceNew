package com.pozdnyakov;

import java.util.List;
import java.util.Map;

public class MeterReadingService {
    private InMemoryMeterReadingRepository inMemoryMeterReadingRepository;

    public MeterReadingService(InMemoryMeterReadingRepository inMemoryMeterReadingRepository) {
        this.inMemoryMeterReadingRepository = inMemoryMeterReadingRepository;
    }

    public void submitReading(User user, int year, int month, Map<String, Integer> readings) {
        MeterReading meterReading = new MeterReading(user, year, month, readings);
        inMemoryMeterReadingRepository.submitReading(meterReading);
    }

    public List<MeterReading> getReadingsByMonth(User user, int year, int month) {
        return inMemoryMeterReadingRepository.getReadingsByMonth(user, year, month);
    }

    public List<MeterReading> getAllReadings() {
        return inMemoryMeterReadingRepository.getAllReadings();
    }
}
