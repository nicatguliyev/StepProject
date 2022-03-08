package dao.impl;
import dao.PassengerDao;
import model.Passenger;
import util.SqlConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PassengerDaoImpl implements PassengerDao {
    Connection connection = SqlConnection.createConnection();
    @Override
    public void createPassenger(Passenger passenger) {
        try {
            Statement statement = connection.createStatement();
             statement.executeQuery(String.format("Insert into Passengers(fin_code, firstname, lastname)\n" +
                    "Select '%s', '%s', '%s' \n" +
                    "where not exists (Select fin_code \n" +
                    "from Passengers where fin_code = '%s')",
                    passenger.getFinCode(), passenger.getFirstname(),
                    passenger.getLastname(), passenger.getFinCode()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
