package service.impl;

import dao.PassengerDao;
import dto.PassengerDto;
import model.Passenger;
import service.PassengerService;

public class PassengerServiceImpl implements PassengerService {

    private final PassengerDao passengerDao;

    public PassengerServiceImpl(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }

    @Override
    public void createPassenger(PassengerDto passengerDto) {
        Passenger passenger = new Passenger(passengerDto.getFirstname(),
                passengerDto.getLastname(), passengerDto.getFinCode());
        System.out.println(passengerDao.createPassenger(passenger));
    }
}
