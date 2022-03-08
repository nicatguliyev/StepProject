package service.impl;

import dao.FlightDao;
import dao.PassengerDao;
import dao.impl.PassengerDaoImpl;
import dto.FlightDto;
import dto.PassengerDto;
import model.Flight;
import service.FlightService;
import service.PassengerService;
import util.DataParser;
import util.Helper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FlightServiceImpl implements FlightService {
    private final FlightDao flightDao;
    private final PassengerDao passengerDao = new PassengerDaoImpl();
    private final PassengerService passengerService = new PassengerServiceImpl(passengerDao);

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
        if(Helper.chooseZeroOrSerial(scanner.nextLine(), Helper.mapToFlightDto(flights))){
            for(int i = 0; i < seats; i++){
                System.out.print("Enter fin code and full name (EX: 123456 Nicat Guliyev) : ");
                String fullName = scanner.nextLine();
                String[] passengerData = fullName.split(" ");
                if(passengerData.length < 3){
                    System.out.println("Warning: Enter passenger data right format!");
                }
                else{
                    PassengerDto passengerDto = new PassengerDto(passengerData[1], passengerData[2], passengerData[0]);
                    passengerService.createPassenger(passengerDto);
                }
            }
        }
        System.out.println("--------------------------------------------------------------------------");
    }

}


