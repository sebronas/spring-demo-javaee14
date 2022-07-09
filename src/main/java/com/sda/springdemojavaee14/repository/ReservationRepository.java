package com.sda.springdemojavaee14.repository;

import com.sda.springdemojavaee14.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // JpaRepository - <first argument is Entity, second is type of priamry key of Entity>


}
