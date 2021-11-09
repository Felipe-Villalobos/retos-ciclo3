package com.rentcloud.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="message")
public class Message implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;

    @Column(name = "messageText", length = 250, nullable = false)
    private String messageText;

    @ManyToOne
    @JoinColumn(name="cloudId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Cloud cloud;

    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;
}

