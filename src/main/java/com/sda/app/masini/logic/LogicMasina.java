package com.sda.app.masini.logic;

import com.sda.app.Bl;
import com.sda.app.masini.db.Masina;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class LogicMasina {
    private Bl blMasina;

    public LogicMasina(Bl blMasina) {
        this.blMasina = blMasina;
    }

    public void adaugaMasina(Masina masina) {
        Session session = blMasina.getSession();
        session.beginTransaction();
        session.save(masina);

        session.getTransaction().commit();
        session.close();
    }

    public List<Masina> listeazaMasini() {
        Session session = blMasina.getSession();
        session.beginTransaction();

        CriteriaQuery<Masina> criteria = session.getCriteriaBuilder().createQuery(Masina.class); //pentru a nu mai scrie un SELECT normal
        criteria.from(Masina.class);

        List<Masina> masini = session.createQuery(criteria).getResultList();
        session.close();
        return masini;
    }
}
