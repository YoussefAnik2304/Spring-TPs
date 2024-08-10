package com.Peche.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LieuPeche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String localisation;
    private Double profondeur;

    public LieuPeche() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Double getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(Double profondeur) {
        this.profondeur = profondeur;
    }

    @Override
    public String toString() {
        return "LieuPeche{" +
                "id=" + id +
                ", localisation='" + localisation + '\'' +
                ", profondeur=" + profondeur +
                '}';
    }
}
