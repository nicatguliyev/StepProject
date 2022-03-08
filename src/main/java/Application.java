import controller.FlightController;
import dao.FlightDao;
import dao.impl.FlightDaoImpl;
import service.FlightService;
import service.impl.FlightServiceImpl;
import util.MainMenu;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        FlightDao flightDao = new FlightDaoImpl();
        FlightService flightService = new FlightServiceImpl(flightDao);
        FlightController flightController = new FlightController(flightService);
        flightController.showAllFlights();
        MainMenu.showMenu();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Enter the command : ");
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number){
                case 1:
                    flightController.showAllFlights();
                    MainMenu.showMenu();
                    break;
                case 2:
                    flightController.showFlightBySerial();
                    MainMenu.showMenu();
                    break;
                case 3:
                    flightController.showFlightsForBooking();
                    MainMenu.showMenu();
                    break;
                case 4:
                    System.out.println("Cancel Booking");
                    MainMenu.showMenu();
                    break;
                case 5:
                    System.out.println("My Flights");
                    MainMenu.showMenu();
                    break;
                case 6:
                    System.out.println("GO HOME BABY");
                    return;
            }
        }
    }
}
