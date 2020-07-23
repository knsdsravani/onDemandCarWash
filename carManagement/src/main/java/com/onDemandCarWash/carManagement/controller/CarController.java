package com.onDemandCarWash.carManagement.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.onDemandCarWash.carManagement.model.Car;
import com.onDemandCarWash.carManagement.service.CarService;

@RestController
@RequestMapping("/car")
@CrossOrigin(origins="http://localhost:3000")
public class CarController {

	@Autowired
	private CarService carService;
	
	@PostMapping("/createNewCar")
	public ResponseEntity<Object> createNewCar(@RequestBody Car car) {
		Car savedCar = carService.createNewCar(car);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedCar.getCarNumber()).toUri();
			return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/getAllCars")
	public List<Car> getAllCars() {
		return carService.findAllCars();
	}
	
	@PostMapping("/updateCar")
	public Car updateCarDetails(@RequestBody Car car) {
		return carService.updateCar(car);
	}
	
	@GetMapping("/getCar/{carNo}")
	public Car getCarByNumber(@PathVariable String carNo) {
		return carService.findBycarNumber(carNo);
	}
	
	@DeleteMapping("/removeCar/{carNo}")
	public String removeCarByNumber(@PathVariable String carNo) {
		carService.removeCar(carNo);
		return "Car details removed successfully!!!";
	}
	
	@PostMapping("/uploadImage/{carNo}")
	public String imageUploadByCarNo(@PathVariable String carNo,@RequestParam("file") MultipartFile file) throws IOException {
		carService.uploadImage(carNo, file);	
		return "Car image uploaded successfully!!!";
	}
	
}
