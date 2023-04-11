package com.example.demo.service;

import com.example.demo.model.Package;
import com.example.demo.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    public List<Package> findAllPackages() {
        return packageRepository.findAll();
    }

    public Package findPackageById(String id) {
        return packageRepository.findById(id).orElse(null);
    }

    public Package savePackage(Package newPackage) {
        return packageRepository.save(newPackage);
    }

    public List<Package> searchPackages(String packageName, String version) {
        List<Package> allPackages = packageRepository.findAll();

        return allPackages.stream()
                .filter(pkg -> packageName == null || pkg.getName().toLowerCase().contains(packageName.toLowerCase()))
                .filter(pkg -> version == null || pkg.getVersion().equals(version))
                .collect(Collectors.toList());
    }

    public Package updatePackage(String id, Package updatedPackage) {
        return packageRepository.findById(id)
                .map(packageToUpdate -> {
                    packageToUpdate.setName(updatedPackage.getName());
                    packageToUpdate.setVersion(updatedPackage.getVersion());
                    return packageRepository.save(packageToUpdate);
                })
                .orElse(null);
    }

    public void deletePackage(String id) {
        packageRepository.deleteById(id);
    }
}