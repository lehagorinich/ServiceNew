package com.pozdnyakov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryMeterReadingRepository implements MeterReadingRepository {
    private Map<String, MeterReading> meterReadings;

    public InMemoryMeterReadingRepository() {
        this.meterReadings = new HashMap<>();
    }

    @Override
    public void submitReading(MeterReading meterReading) {
        meterReadings.put(meterReading.getUser().getUsername(),meterReading);

    }

    @Override
    public List<MeterReading> getReadingsByMonth(User user, int year, int month) {
        List<MeterReading> readingsByMonth = new ArrayList<>();
        for (MeterReading reading : meterReadings.values()) {
            if (reading.getUser().equals(user) && reading.getYear() == year && reading.getMonth() == month) {
                readingsByMonth.add(reading);
            }
        }
        return readingsByMonth;
    }


    @Override
    public List<MeterReading> getAllReadings() {
        return new ArrayList<>(meterReadings.values());
    }
}



