package util;

import dao.PassengerDao;
import dto.FlightDto;
import dto.PassengerDto;
import model.Flight;
import model.Passenger;
import service.impl.PassengerServiceImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {

    public static List<FlightDto> mapToFlightDto(ArrayList<Flight> flights) {
        return flights.stream().map(flight -> new FlightDto(flight.getSerial_number(),
                flight.getFrom(),
                flight.getDestination(), flight.getSeats(),
                flight.getDate())).collect(Collectors.toList());
    }

    public static boolean chooseZeroOrSerial(String choice, List<FlightDto> flightDtos) {
        if (choice.equals("0")) {
            return false;
        } else {
            List<FlightDto> flightDtoList = flightDtos.stream().
                    filter(x -> x.getSerial_number().equals(choice)).collect(Collectors.toList());
            if (flightDtoList.size() == 0) {
                System.out.println("Enter valid serial number");
                return false;
            } else {
                return true;
            }
        }
    }
    public static void printFlightsInfo(ArrayList<Flight> flights) {
        System.out.println("Serial           From              Destination         Seats        Date");
        System.out.println("-------        ---------          -------------       -------      -------");
        if (flights.size() == 0) {
            System.out.println("Not Found");
        } else {
            for (int i = 0; i < Helper.mapToFlightDto(flights).size(); i++) {
                System.out.println(Helper.mapToFlightDto(flights).get(i).getSerial_number() + "          " +
                        Helper.mapToFlightDto(flights).get(i).getFrom() + "                 "
                        + Helper.mapToFlightDto(flights).get(i).getDestination() + "            " +
                        + Helper.mapToFlightDto(flights).get(i).getSeats() + "          "
                        + Helper.mapToFlightDto(flights).get(i).getDate());
            }
        }
    }
}
