package dao.impl;

import dao.FlightDao;
import util.SqlConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

public class FlightDaoImpl implements FlightDao {

    Connection connection = SqlConnection.createConnection();

    @Override
    public ResultSet showAllFlights() {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery("Select * from Flights where " +
                   " date = current_date + INTERVAL '1 DAY'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ResultSet showFlightBySerial(String serial_number) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery("Select * from Flights where " +
                    " date = current_date + INTERVAL '1 DAY' AND serial_number='"+serial_number+"'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ResultSet getFlightsForBooking(String destination, short seats, Date date) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(String.format("Select * from Flights where " +
                    "destination = '%s' AND seats >= %d AND \"date\" = '%s'", destination, seats, date));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
