package com.onDemandCarWash.servicePlanManagement.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onDemandCarWash.servicePlanManagement.model.ServicePlan;

@Repository
public interface ServicePlanRepository extends MongoRepository<ServicePlan, String>{

	Optional<ServicePlan> findByServiceName(String serviceName);

}
