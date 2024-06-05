package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/admin/addVehicle")
    public String addVehicleForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "addVehicle";
    }

    @PostMapping("/admin/addVehicle")
    public String addVehicle(@ModelAttribute Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return "redirect:/admin";
    }

    @GetMapping("/catalog")
    public String viewCatalog(Model model) {
        model.addAttribute("vehicles", vehicleRepository.findAll());
        return "catalog";
    }
}
