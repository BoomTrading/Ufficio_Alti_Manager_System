package com.example.Ufficio_Mngmnt.service;


import com.example.Ufficio_Mngmnt.model.Office;
import com.example.Ufficio_Mngmnt.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    // Create
    public Office createOffice(Office office) {
        return officeRepository.save(office);
    }

    // Read (all)
    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    // Read (by ID)
    public Optional<Office> getOfficeById(String officeCode) {
        return officeRepository.findById(officeCode);
    }

    // Update
    public Office updateOffice(String officeCode, Office officeDetails) {
        Office office = officeRepository.findById(officeCode)
                .orElseThrow(() -> new RuntimeException("Office not found with code: " + officeCode));
        office.setCity(officeDetails.getCity());
        office.setPhone(officeDetails.getPhone());
        office.setAddressLine1(officeDetails.getAddressLine1());
        office.setAddressLine2(officeDetails.getAddressLine2());
        office.setState(officeDetails.getState());
        office.setCountry(officeDetails.getCountry());
        office.setPostalCode(officeDetails.getPostalCode());
        office.setTerritory(officeDetails.getTerritory());
        return officeRepository.save(office);
    }

    // Delete
    public void deleteOffice(String officeCode) {
        officeRepository.deleteById(officeCode);
    }
    
    // New search methods
    public List<Office> searchOffices(String searchTerm) {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return getAllOffices();
        }
        return officeRepository.searchOffices(searchTerm.trim());
    }
    
    public List<Office> findByCity(String city) {
        return officeRepository.findByCityContainingIgnoreCase(city);
    }
    
    public List<Office> findByCountry(String country) {
        return officeRepository.findByCountryContainingIgnoreCase(country);
    }
    
    public List<Office> findByTerritory(String territory) {
        return officeRepository.findByTerritoryContainingIgnoreCase(territory);
    }
}