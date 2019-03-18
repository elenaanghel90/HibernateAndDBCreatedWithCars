package com.sda.app.utilizatori.db;

import com.sda.app.masini.db.Masina;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Utilizatori")
public class Utilizator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nume")
    private String nume;

    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinTable(
            name = "utilizatori_masini",   //aici pui tabelul de legatura
            joinColumns = {@JoinColumn(name = "id_utilizator")}, //care face legatura cu cealata coloana a enitatii care e owner de coloana. Utilizatorii i-am stabilit ca fiind owner
            inverseJoinColumns = @JoinColumn(name = "id_masina") //care face legatura cu cealata coloana a enitatii care nu e owner de coloana
    )
    private List<Masina> masini;

    public Utilizator(Integer id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public Utilizator() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Masina> getMasini() {
        return masini;
    }

    public void setMasini(List<Masina> masini) {
        this.masini = masini;
    }

    @Override
    public String toString() {
        return "Utilizator{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", masini=" + masini +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utilizator that = (Utilizator) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nume != null ? !nume.equals(that.nume) : that.nume != null) return false;
        return masini != null ? masini.equals(that.masini) : that.masini == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nume != null ? nume.hashCode() : 0);
        result = 31 * result + (masini != null ? masini.hashCode() : 0);
        return result;
    }
}
