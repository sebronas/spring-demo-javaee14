package com.sda.springdemojavaee14.service;

import com.sda.springdemojavaee14.entity.Reservation;
import com.sda.springdemojavaee14.repository.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> findAllReservations() {
        log.info("finding all reservations (Service)");

        return reservationRepository.findAll();
    }

    public Reservation findReservationById(Long reservationId) {
        log.info("finding reservation by id: [{}]", reservationId);
        //Optional<Reservation> reservationFromDb = reservationRepository.findById(reservationId);
        // var is just for less typing and replaces all type name - the same as above line;
        // if you use ar provide good name - always try to provide good name
        var reservationFromDb = reservationRepository.findById(reservationId);
        return reservationFromDb.orElse(null);
    }

}
