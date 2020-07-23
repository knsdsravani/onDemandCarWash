package com.onDemandCarWash.carManagement.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.onDemandCarWash.carManagement.exception.CarNotFoundException;
import com.onDemandCarWash.carManagement.model.Car;
import com.onDemandCarWash.carManagement.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	CarRepository carRepository;

	public List<Car> findAllCars() {
		return carRepository.findAll();
	}

	public Car createNewCar(Car car){
		return carRepository.insert(car);
	}

	public Car updateCar(Car car) {
		return carRepository.save(car);
	}

	public Car findBycarNumber(String carNo) {
		Optional<Car> car = carRepository.findById(carNo);
		if(!car.isPresent())
			throw new CarNotFoundException("Cardetails with the number "+ carNo);
		return car.get();
	}

	public void removeCar(String carNumber) {
		carRepository.deleteById(carNumber);
	}

	public Car uploadImage(String carNo, MultipartFile image) throws IOException {
		Car savedCar = findBycarNumber(carNo);
		savedCar.setImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
		return carRepository.save(savedCar);	
	}

}
