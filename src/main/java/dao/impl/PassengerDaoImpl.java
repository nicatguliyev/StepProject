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
    public String createPassenger(Passenger passenger) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(String.format("Insert into Passengers(fin_code, firstname, lastname)\n" +
                            "values('%s' , '%s', '%s')",
                    passenger.getFinCode(), passenger.getFirstname(),
                    passenger.getLastname()));
            return "Passenger is crated";
        } catch (SQLException e) {
            if (e.getMessage().contains("duplicate key value"))
                return "Passenger already exists";
            else
                return e.getMessage();
        }
    }
}
