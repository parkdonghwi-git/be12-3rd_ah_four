package com.example.apireservation.reservation;


import com.example.apireservation.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Override
    Optional<Reservation> findById(Long id);
}
