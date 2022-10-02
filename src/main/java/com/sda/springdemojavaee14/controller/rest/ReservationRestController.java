package com.sda.springdemojavaee14.controller.rest;

import com.sda.springdemojavaee14.dto.GenericError;
import com.sda.springdemojavaee14.entity.Reservation;
import com.sda.springdemojavaee14.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class ReservationRestController {

    private final ReservationService reservationService;

    public ReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() {
        log.info("getting all reservations (Controller)");
        /*if (true) {
            throw new NullPointerException("Braking the server??");
        }*/
        return reservationService.findAllReservations();
    }

    @GetMapping("/reservations/{id}")
    // @PathVariable("id") get id value from url and use for reservationId
    // 200 if there's result and response: ResponseEntity<Reservation>;
    // 404 if wrong url was used by client and response: ResponseEntity<GenericError>
    public ResponseEntity<?> getReservationById(@PathVariable("id") Long reservationId) {
        log.info("trying to find reservation by id: [{}]", reservationId);

        //return reservationService.findReservationById(reservationId);
        var responseBody = reservationService.findReservationById(reservationId);
       /*     ResponseEntity.status(HttpStatus.OK)
                    .body(responseBody);*/

        if (responseBody != null) {
            return ResponseEntity.ok(responseBody);
        } else {
            // https://danielmiessler.com/images/url-urn-uri-structure-2022.png

           /* String path = "/api/reservations/"+reservationId;
            try {
                //TODO: Fix server url
                URI uri = new URI("/api/reservations/"+reservationId);
                path = uri.toString();
            } catch (URISyntaxException e) {
                log.warn("Problems with creating URI", e);
            }*/
            String path = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    GenericError.builder()
                            .responseCode(404)
                            .timestamp(LocalDateTime.now())
                            .errorMessage("You provided wrong id: " + reservationId)
                            .path(path)
                            .build()
            );
        }
    }
}
