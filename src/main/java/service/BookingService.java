package service;

import dto.BookingDto;

public interface BookingService {
    void createBooking(String fin_code, String serial_number);
    int getBookingBySerialAndFin(String fin_code, String serial_number);
}
