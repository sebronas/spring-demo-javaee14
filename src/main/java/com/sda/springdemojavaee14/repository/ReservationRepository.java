package com.sda.springdemojavaee14.repository;

import com.sda.springdemojavaee14.entity.Reservation;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ReservationRepository {

    public List<Reservation> findAllReservationInRepository(){

        return List.of(
                //1 approach
                /*
                new Reservation(1L,
                        12L,
                        LocalDateTime.now(),
                        LocalDateTime.now().plusHours(2),
                        "Liepins",
                        "+371 4444440",
                        "asd@qwe.com",
                        4,
                        "Latvia, Riga"),
                */

                //2nd approach
                Reservation.builder()
                        .id(1L)
                        .tableNumber(10L)
                        .startBookingTime(LocalDateTime.now())
                        .endBookingTime(LocalDateTime.now().plusHours(2))
                        .surname("Sebris")
                        .phoneNumber("+371 22222222")
                        .email("sebris@kristaps.com")
                        .numberOfPeople(5)
                        .address("Latvia, Ogre")
                        .build()
        );
    }
}
