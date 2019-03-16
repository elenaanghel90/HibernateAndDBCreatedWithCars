package com.sda.app.masini.db;

import com.sda.app.utilizatori.db.Utilizator;

import javax.persistence.*;

@Entity
@Table(name="Masini")
public class Masina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity lasi baza de date sa genereze ea in fucntie de cum stie
    @Column(name="id")
    private Integer id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "model")
    private String model;

    @Column(name = "numar")
    private String numar;

    public Masina(Integer id, String marca, String model, String numar) {
        this.id = id;
        this.marca = marca;
        this.model = model;
        this.numar = numar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumar() {
        return numar;
    }

    public void setNumar(String numar) {
        this.numar = numar;
    }
}
