package dao;

import model.Booking;

import java.awt.print.Book;
import java.sql.ResultSet;

public interface BookingDao {
    boolean createBooking(String serial_numberDto, String fin_codeDto);
    ResultSet getBookingBySerialAndFin(String fin_code, String serial_number);
}
