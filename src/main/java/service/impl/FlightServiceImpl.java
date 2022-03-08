package service.impl;

import dao.FlightDao;
import dto.FlightDto;
import model.Flight;
import service.FlightService;
import util.DataParser;
import util.Helper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FlightServiceImpl implements FlightService {
    private final FlightDao flightDao;

    public FlightServiceImpl(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public void showAllFlights() {
        ResultSet resultSet = flightDao.showAllFlights();
        ArrayList<Flight> flights = DataParser.parseFlightResultSet(resultSet);
        System.out.println("Serial           From              Destination");
        System.out.println("-------        ---------          -------------");
        for (int i = 0; i < Helper.mapToFlightDto(flights).size(); i++) {
            System.out.println(Helper.mapToFlightDto(flights).get(i).getSerial_number() + "          " +
                    Helper.mapToFlightDto(flights).get(i).getFrom() + "                 "
                    + Helper.mapToFlightDto(flights).get(i).getDestination());
        }
        System.out.println("----------------------------------------------------");
    }

    @Override
    public void showFlightBySerial(String serial_number) {
        ResultSet resultSet = flightDao.showFlightBySerial(serial_number);
        ArrayList<Flight> flights = DataParser.parseFlightResultSet(resultSet);
        Helper.printFlightsInfo(flights);
        System.out.println("--------------------------------------------------------------------------");
    }

    @Override
    public void showFlightForBooking(String destination, short seats, Date date) {
        ResultSet resultSet = flightDao.getFlightsForBooking(destination, seats, date);
        ArrayList<Flight> flights = DataParser.parseFlightResultSet(resultSet);
        Helper.printFlightsInfo(flights);
        System.out.print("Enter 0 to return main menu or enter serial number for booking : ");
        Scanner scanner = new Scanner(System.in);
        Helper.chooseZeroOrSerial(scanner.nextLine(), Helper.mapToFlightDto(flights));
        System.out.println("--------------------------------------------------------------------------");
    }

}


