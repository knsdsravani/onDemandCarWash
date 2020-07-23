package com.onDemandCarWash.washerManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onDemandCarWash.washerManagement.exception.WasherNotFoundException;
import com.onDemandCarWash.washerManagement.model.Washer;
import com.onDemandCarWash.washerManagement.repository.WasherRepository;

@Service
public class WasherService {
	
	@Autowired
	private WasherRepository washerRepo;

	public Washer createNewWasher(Washer washer) {
		return washerRepo.insert(washer);
	}

	public List<Washer> getAllWashers() {
		return washerRepo.findAll();
	}

	public Washer getWasherById(int id){
		Optional<Washer> washer = washerRepo.findById(id);
		if(!washer.isPresent()) 
			throw new WasherNotFoundException("Washer Not found with the ID " + id);
		return washer.get();	
	}

	public List<Washer> getAllWasherByStatus(String status) {
		List<Washer> washers = washerRepo.findByStatus(status);
		if(washers.isEmpty())
			throw new WasherNotFoundException("There is no washer present with status " + status);
		return washers;
	}

	public void deleteWasherById(int id) {
		Optional<Washer> washer = washerRepo.findById(id);
		if(!washer.isPresent()) 
			throw new WasherNotFoundException("Washer Not found with the ID " + id);
		washerRepo.deleteById(id);
	}

	public Washer updateWasher(Washer washer) {
		return washerRepo.save(washer);
	}

	public String deleteAllWashers() {
		washerRepo.deleteAll();
		return "WashersData removed successfully!!!";
	}

}
