package com.rentcloud.app.controllers;

import com.rentcloud.app.entities.Reservation;
import com.rentcloud.app.reports.CountClient;
import com.rentcloud.app.reports.ReservationStatus;
import com.rentcloud.app.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService service;

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id")int id){
        return service.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return service.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return service.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return service.delete(id);
    }

    @GetMapping("/report-status")
    public ReservationStatus getReservationsStatusReport(){
        return service.getReservationStatusReport();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationReportDate(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return service.getReservationPeriod(dateOne, dateTwo);
    }

    @GetMapping("/report-clients")
    public List<CountClient> getClients(){
        return service.getTopClients();
    }
}
