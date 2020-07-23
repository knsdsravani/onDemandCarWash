package com.onDemandCarWash.servicePlanManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onDemandCarWash.servicePlanManagement.model.ServicePlan;
import com.onDemandCarWash.servicePlanManagement.service.ServicePlanService;

@RestController
@RequestMapping("/servicePlan")
public class ServicePlanController {

	@Autowired
	private ServicePlanService planService;
	
	@PostMapping("/addNewServicePlan")
	public ServicePlan addNewServicePlan(@RequestBody ServicePlan plan) {
		return planService.addNewServicePlan(plan);
	}
	
	@GetMapping("/getAllPlans")
	public List<ServicePlan> getAllPlans(){
		return planService.getAllPlans();
	}
	
	@PostMapping("/updateStatus/{serviceName}/{status}")
	public ServicePlan updateStatusOfService(@PathVariable String serviceName,@RequestParam String status) {
		return planService.updateStatusOfService(serviceName, status);
	}
	
	@PostMapping("/updateService/{serviceName}")
	public String updateService(@RequestBody ServicePlan service,@PathVariable String serviceName) {
		return planService.updateService(service, serviceName);
	}
}

