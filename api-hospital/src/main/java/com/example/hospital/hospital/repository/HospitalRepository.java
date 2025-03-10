package com.example.hospital.hospital.repository;

import com.example.hospital.hospital.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    Optional<Hospital> findById(Long idx);
    List<Hospital> findByNameContaining(@Param("name") String name);

    List<Hospital> findByTypeContainingAndNameContainingAndAddressContaining(String type, String specialty, String location);
}
