package dao;

import model.Passenger;

import java.sql.ResultSet;

public interface PassengerDao {
    void createPassenger(Passenger passenger);
}
