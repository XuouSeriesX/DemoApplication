package com.example.demo.controller;

import com.example.demo.model.Package;
import com.example.demo.service.PackageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PackageController {

    @Autowired
    private PackageService packageService;

    @GetMapping("/search")
    public String search(@RequestParam String search, @RequestParam String searchValue, Model model) {
        // Call packageService.searchPackages() method to perform the search operation
        // Pass search and searchValue as parameters
        List<Package> packages = packageService.searchPackages(search, searchValue);

        // Add the search result to the model
        model.addAttribute("packages", packages);

        return "main";
    }

    // Other CRUD methods (Insert, Update, Delete) and the amount sorting using Bubble Sort
}
