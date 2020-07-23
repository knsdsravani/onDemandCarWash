package com.onDemandCarWash.addOnManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onDemandCarWash.addOnManagement.exception.AddOnNotFoundException;
import com.onDemandCarWash.addOnManagement.model.AddOns;
import com.onDemandCarWash.addOnManagement.repository.AddOnRepository;

@Service
public class AddOnService {

	@Autowired
	AddOnRepository addOnRepo;

	public AddOns addNewAddOn(AddOns addOn) {
		return addOnRepo.insert(addOn);
	}

	public List<AddOns> getAllAddOns() {
		return addOnRepo.findAll();
	}

	public String updateAddOn(AddOns addOn, String name) {
		Optional<AddOns> savedAddOn = addOnRepo.findById(name);
		if(!savedAddOn.isPresent())
			throw new AddOnNotFoundException("AddOn with the name "+ name + "not exist");
		addOnRepo.save(addOn);
		return "AddOn Updated Successfully!!";
	}

	public AddOns getAddOnByName(String name) {
		Optional<AddOns> addOn = addOnRepo.findById(name);
		if(!addOn.isPresent())
			throw new AddOnNotFoundException("AddOn with the name "+ name + "not exist");
		return addOn.get();
	}

	public List<AddOns> getAddOnByStatus(String status) {
		List<AddOns> addOns = addOnRepo.findBystatus(status);
		if(addOns.isEmpty())
			throw new AddOnNotFoundException("AddOns with the status "+ status + "not exist");
		return addOns;
	}

	public String deleteAddOnByName(String name) {
		Optional<AddOns> addOn = addOnRepo.findById(name);
		if(!addOn.isPresent())
			throw new AddOnNotFoundException("AddOn with the name "+ name + "not exist");
		addOnRepo.deleteById(name);
		return "AddOn removed Successfully!!";
	}
	
}
