package com.rentcloud.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cloud")
public class Cloud implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "brand", length = 45, nullable = false)
    private String brand;

    @Column(name = "year", length = 4, nullable = false)
    private Integer year;

    @Column(name = "description", length = 250, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("clouds")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cloud")
    @JsonIgnoreProperties({"cloud","client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cloud")
    @JsonIgnoreProperties({"cloud","messages"})
    public List<Reservation> reservations;
}
