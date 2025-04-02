package com.example.Ufficio_Mngmnt.repository;


import com.example.Ufficio_Mngmnt.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office, String> {
    // Metodi personalizzati (opzionali)
    Office findByCity(String city);
}