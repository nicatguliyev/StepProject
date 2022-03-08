package service.impl;

import dao.BookingDao;
import dto.BookingDto;
import model.Booking;
import service.BookingService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingServiceImpl implements BookingService {
    private final BookingDao bookingDao;

    public BookingServiceImpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    public void createBooking(String fin_code, String serial_number) {
        if(!bookingDao.createBooking(serial_number, fin_code)){
            System.out.println("Booking is created");
        }
    }

    @Override
    public int getBookingBySerialAndFin(String fin_codeDto, String serial_numberDto) {
        int count = 0;
        ResultSet resultSet = bookingDao.getBookingBySerialAndFin(fin_codeDto, serial_numberDto);
        try {
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return count;
    }
}
