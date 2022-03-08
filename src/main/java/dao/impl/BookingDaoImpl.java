package dao.impl;

import dao.BookingDao;
import model.Booking;
import util.SqlConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookingDaoImpl implements BookingDao {

    Connection connection = SqlConnection.createConnection();
    @Override
    public boolean createBooking(String serial_number, String fin_code) {

        Boolean bool = false;
        try {
            Statement statement = connection.createStatement();
            bool = statement.execute(String.format("Insert Into Booking (fin_code, serial_number) " +
                    "values('%s' , '%s')", fin_code, serial_number));
            return bool;
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }

    @Override
    public ResultSet getBookingBySerialAndFin(String fin_code, String serial_number) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(String.format("Select count(fin_code) from Booking where fin_code = '%s' " +
                    "AND serial_number = '%s'" , fin_code, serial_number));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
