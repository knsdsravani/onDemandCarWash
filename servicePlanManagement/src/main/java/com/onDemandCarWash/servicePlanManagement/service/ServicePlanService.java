package com.onDemandCarWash.servicePlanManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onDemandCarWash.servicePlanManagement.exception.ServicePlanNotExistException;
import com.onDemandCarWash.servicePlanManagement.model.ServicePlan;
import com.onDemandCarWash.servicePlanManagement.repository.ServicePlanRepository;

@Service
public class ServicePlanService {

	@Autowired
	private ServicePlanRepository servicePlanRepo;

	public ServicePlan addNewServicePlan(ServicePlan plan) {
		return servicePlanRepo.insert(plan);
	}

	public List<ServicePlan> getAllPlans() {
		return servicePlanRepo.findAll();
	}

	public ServicePlan updateStatusOfService(String serviceName, String status) {
		Optional<ServicePlan> savedPlan= servicePlanRepo.findByServiceName(serviceName);
		if(!savedPlan.isPresent())
			throw new ServicePlanNotExistException("There is no "+ serviceName + "service exist");
		ServicePlan servicePlan = savedPlan.get();
		servicePlan.setStatus(status);
		return servicePlan;
	}

	public String updateService(ServicePlan service, String serviceName) {
		Optional<ServicePlan> savedPlan= servicePlanRepo.findById(serviceName);
		if(!savedPlan.isPresent())
			throw new ServicePlanNotExistException("There is no "+ serviceName + "service exist");
		servicePlanRepo.save(service);
		return "Service updated successfully!!";
	}
	
}
