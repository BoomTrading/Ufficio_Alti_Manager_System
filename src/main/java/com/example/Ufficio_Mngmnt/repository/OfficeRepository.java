package com.example.Ufficio_Mngmnt.repository;


import com.example.Ufficio_Mngmnt.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeRepository extends JpaRepository<Office, String> {
    // Metodi personalizzati (opzionali)
    Office findByCity(String city);
    
    // New search methods
    List<Office> findByCityContainingIgnoreCase(String city);
    List<Office> findByCountryContainingIgnoreCase(String country);
    List<Office> findByTerritoryContainingIgnoreCase(String territory);
    
    // Combined search query
    @Query("SELECT o FROM Office o WHERE " +
           "(:searchTerm IS NULL OR " +
           "LOWER(o.city) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "LOWER(o.country) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "LOWER(o.territory) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "LOWER(o.addressLine1) LIKE LOWER(CONCAT('%', :searchTerm, '%')))")
    List<Office> searchOffices(@Param("searchTerm") String searchTerm);
}