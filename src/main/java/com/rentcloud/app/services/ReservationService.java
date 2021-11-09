package com.rentcloud.app.services;

import com.rentcloud.app.entities.Reservation;
import com.rentcloud.app.reports.CountClient;
import com.rentcloud.app.reports.ReservationStatus;
import com.rentcloud.app.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getAll(){
        return repository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return repository.getReservation(id);
    }

    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation() == null){
            return repository.save(reservation);
        } else {
            Optional<Reservation> isReservation = repository.getReservation(reservation.getIdReservation());
            if (isReservation.isPresent()){
                return reservation;
            } else {
                return repository.save(reservation);
            }
        }
    }

    public Reservation update(Reservation reservation){
        if (reservation.getIdReservation() != null){
            Optional<Reservation> isReservation = getReservation(reservation.getIdReservation());
            if (isReservation.isPresent()){
                if (reservation.getStartDate() != null){
                    isReservation.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null){
                    isReservation.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null){
                    isReservation.get().setStatus(reservation.getStatus());
                }
                if (reservation.getCloud() != null){
                    isReservation.get().setCloud(reservation.getCloud());
                }
                if (reservation.getClient() != null){
                    isReservation.get().setClient(reservation.getClient());
                }
                if (reservation.getScore() != null){
                    isReservation.get().setScore(reservation.getScore());
                }
                return repository.save(isReservation.get());
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public boolean delete(int id){
        return getReservation(id).map(reservation -> {
            repository.delete(reservation);
            return true;
        }).orElse(false);
    }

    public ReservationStatus getReservationStatusReport(){
        List<Reservation> completed = repository.getReservationByStatus("completed");
        List<Reservation> cancelled = repository.getReservationByStatus("cancelled");
        return new ReservationStatus(completed.size(), cancelled.size());
    }

    public List<Reservation> getReservationPeriod(String dateOne,String dateTwo){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateFormat.parse(dateOne);
            Date endDate = dateFormat.parse(dateTwo);
            if (startDate.before(endDate)){
                return repository.getReservationPeriod(startDate, endDate);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<CountClient> getTopClients(){
        return repository.getTopClients();
    }
}
