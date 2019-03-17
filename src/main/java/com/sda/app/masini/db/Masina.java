package com.sda.app.masini.db;

import com.sda.app.utilizatori.db.Utilizator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Masini")
public class Masina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //identity lasi baza de date sa genereze ea in fucntie de cum stie
    @Column(name = "id")
    private Integer id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "model")
    private String model;

    @Column(name = "numar")
    private String numar;

    @ManyToMany(mappedBy = "masini")
    private List<Utilizator> utilizatori;

    public Masina(Integer id, String marca, String model, String numar) {
        this.id = id;
        this.marca = marca;
        this.model = model;
        this.numar = numar;
    }

    public Masina() {

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

    @Override
    public String toString() {
        return "Masina{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                ", numar='" + numar + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Masina masina = (Masina) o;

        if (id != null ? !id.equals(masina.id) : masina.id != null) return false;
        if (marca != null ? !marca.equals(masina.marca) : masina.marca != null) return false;
        if (model != null ? !model.equals(masina.model) : masina.model != null) return false;
        return numar != null ? numar.equals(masina.numar) : masina.numar == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (marca != null ? marca.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (numar != null ? numar.hashCode() : 0);
        return result;
    }
}
