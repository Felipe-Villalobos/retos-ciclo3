package com.rentcloud.app.repositories;

import com.rentcloud.app.entities.Client;
import com.rentcloud.app.entities.Reservation;
import com.rentcloud.app.reports.CountClient;
import com.rentcloud.app.repositories.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository crudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) crudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return crudRepository.findById(id);
    }

    public Reservation save(Reservation reservation){
        return crudRepository.save(reservation);
    }

    public void delete(Reservation reservation){
        crudRepository.delete(reservation);
    }


    public List<Reservation> getReservationByStatus(String status){
        return crudRepository.findAllByStatus(status);
    }


    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return crudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }

    public List<CountClient> getTopClients(){
        List<CountClient> clientList = new ArrayList<>();
        List<Object[]> report = crudRepository.countTotalReservationByClient();
        for (Object[] objects : report) {
            clientList.add(new CountClient((Long) objects[1], (Client) objects[0]));
        }
        return clientList;
    }
}
