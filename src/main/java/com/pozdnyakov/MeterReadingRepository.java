package com.pozdnyakov;

import java.util.List;

public interface MeterReadingRepository {
    void submitReading(MeterReading reading);
    List<MeterReading> getReadingsByMonth(User user, int year, int month);
    List<MeterReading> getAllReadings();
}
