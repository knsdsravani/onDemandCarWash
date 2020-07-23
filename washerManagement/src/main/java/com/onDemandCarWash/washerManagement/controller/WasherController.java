package com.onDemandCarWash.washerManagement.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.onDemandCarWash.washerManagement.model.Washer;
import com.onDemandCarWash.washerManagement.service.WasherService;


@RestController
@RequestMapping("/washer")
public class WasherController {

	@Autowired
	private WasherService washerService;
	
	@PostMapping("/createWasher")
	public ResponseEntity<Object> addNewWasher(@RequestBody Washer washer){	
		Washer savedWasher = washerService.createNewWasher(washer);
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}").buildAndExpand(savedWasher.getWId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/getAllWashers")
	public List<Washer> getAllWashers() {
		return washerService.getAllWashers();
	}
	
	@GetMapping("/getWasher/{id}")
	public Washer getWasherById(@PathVariable int id) {
		return washerService.getWasherById(id);
	}
	
	@GetMapping("/getAllWashers/{status}")
	public List<Washer> getWasherByStatus(@PathVariable String status) {
		return washerService.getAllWasherByStatus(status);
	}
	
	@DeleteMapping("/remove/{id}")
	public void removeWasherById(@PathVariable int id) {
		washerService.deleteWasherById(id);
	}
	
	@PostMapping("/updateWasher")
	public Washer updateWasher(@RequestBody Washer washer) {
		return washerService.updateWasher(washer);
	}
	
	@DeleteMapping("/deleteAllWashers")
	public String deleteAllWashers() {
		return washerService.deleteAllWashers();
	}
	
}

