package dao;

import model.Passenger;

import java.sql.ResultSet;

public interface PassengerDao {
    String createPassenger(Passenger passenger);
}
