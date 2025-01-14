package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository<Vehicle> extends JpaRepository<Vehicle, Integer> {
}
