package com.sda.app.utilizatori.logic;

import com.sda.app.Bl;
import com.sda.app.masini.db.Masina;
import com.sda.app.utilizatori.db.Utilizator;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class LogicUtilizator {
    private Bl bl;

    public LogicUtilizator(Bl bl) {
        this.bl = bl;
    }

    public void adaugaUtilizator(Utilizator utilizator) {
        Session session = bl.getSession();
        session.beginTransaction();
        session.save(utilizator);

        session.getTransaction().commit();
        session.close();
    }

    public List<Utilizator> listeazaUtilizatori() {
        Session session = bl.getSession();
        session.beginTransaction();

        CriteriaQuery<Utilizator> criteria = session.getCriteriaBuilder().createQuery(Utilizator.class); //pentru a nu mai scrie un SELECT normal
        criteria.from(Utilizator.class);

        List<Utilizator> utilizatori = session.createQuery(criteria).getResultList();
        session.close();
        return utilizatori;
    }

    public void inregistreazaMasinaUnuiUtilizator(Integer id_masina, Integer id_utilizator) {
        Session session = bl.getSession();
        session.beginTransaction();

        Masina masina = session.get(Masina.class, id_masina);
        Utilizator utilizator = session.get(Utilizator.class, id_utilizator);

        if (masina != null && utilizator != null) {
            utilizator.getMasini().add(masina);
            session.update(utilizator);
        }
        session.getTransaction().commit();
        session.close();
    }

//    public List<Utilizator> listeazaMasinaUnuiUtilizator(){
//        Session session = bl.getSession();
//        session.beginTransaction();
//
//        List<Utilizator> utilizatori = session.createQuery(criteria).getResultList();
//        session.close();
//        return utilizatori;
//    }

}
