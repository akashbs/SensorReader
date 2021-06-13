package com.example.sensorreder.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;


@Component
@Table(name = "CLIENT")
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "client_token", nullable = false, unique = true)
    private String clientToken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getClientToken() {
        return clientToken;
    }

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }
}