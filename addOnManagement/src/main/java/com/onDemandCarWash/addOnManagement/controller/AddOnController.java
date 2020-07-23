package com.onDemandCarWash.addOnManagement.controller;

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

import com.onDemandCarWash.addOnManagement.model.AddOns;
import com.onDemandCarWash.addOnManagement.service.AddOnService;

@RestController
@RequestMapping("/addOns")
public class AddOnController {

	@Autowired
	private AddOnService addOnService;
	
	@PostMapping("/addNewAddOn")
	public ResponseEntity<Object> addNewAddOn(@RequestBody AddOns addOn){
		AddOns addOnSaved = addOnService.addNewAddOn(addOn);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}").buildAndExpand(addOnSaved.getName()).toUri();
			return ResponseEntity.created(location).build();
	} 
	
	@GetMapping("/getAllAddOns")
	public List<AddOns> getAllAddOns(){
		return addOnService.getAllAddOns();
	}
	
	@PostMapping("/updateAddOn/{name}")
	public String updateAddOn(@RequestBody AddOns addOn,@PathVariable String name) {
		return addOnService.updateAddOn(addOn, name);		
	}
	
	@GetMapping("/getAddOn/{name}")
	public AddOns getAddonByName(@PathVariable String name) {
		return addOnService.getAddOnByName(name);
	}
	
	@GetMapping("/getAddOnByStatus/{status}")
	public List<AddOns> getAddonByStatus(@PathVariable String status) {
		return addOnService.getAddOnByStatus(status);
	}
	
	@DeleteMapping("/deleteAddOn/{name}")
	public String deleteAddOnByName(@PathVariable String name) {
		return addOnService.deleteAddOnByName(name);
	}
			
}
