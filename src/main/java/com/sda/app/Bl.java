package com.sda.app;

import com.sda.app.masini.db.Masina;
import com.sda.app.masini.logic.LogicMasina;
import com.sda.app.ui.Meniu;
import com.sda.app.utilizatori.db.Utilizator;
import com.sda.app.utilizatori.logic.LogicUtilizator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Bl {

    public static StandardServiceRegistry registry;
    public static MetadataSources sources;
    public static Metadata metadata;
    public static SessionFactory sessionFactory;
    LogicUtilizator logicUtilizator;
    LogicMasina logicMasina;

    public SessionFactory getSessionFactory() {

        if (null == sessionFactory) {
            // Create registry
            registry = new StandardServiceRegistryBuilder().configure().build();
            // Create MetadataSources
            sources = new MetadataSources(registry);
            // Create Metadata
            metadata = sources.getMetadataBuilder().build();
            // Create SessionFactory
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        }
        return sessionFactory;
    }

    public Session getSession() {
        return getSessionFactory().openSession();
    }

    public void start() {
        this.logicUtilizator = new LogicUtilizator(this);
        Meniu meniu = new Meniu(this);
        meniu.init(); //ca sa ne afiseze meniul
    }

    public static void main(String[] args) {
        Bl bl = new Bl();
        bl.start();


//        Session session = bl.getSession();
//        session.beginTransaction();
//        Utilizator utilizator = session.get(Utilizator.class, 1);
//        Masina masina = new Masina(null, "Dacia", "2020", "B06ABC");
//        utilizator.getMasini().add(masina);
//        session.saveOrUpdate(utilizator);
//        System.out.println(utilizator);
//        session.getTransaction().commit();
//        session.close();
    }


    public void adaugaUtilizator(Utilizator utilizator) {

        logicUtilizator.adaugaUtilizator(utilizator);
    }

    public List<Utilizator> listeazaUtilizatori() {
        return logicUtilizator.listeazaUtilizatori();
    }

    public void inregistreazaMasinaUnuiUtilizator(Integer id_masina, Integer id_utilizator) {
        logicUtilizator.inregistreazaMasinaUnuiUtilizator(id_masina, id_utilizator);
    }

    public void adaugaMasina(Masina masina) {
        logicMasina.adaugaMasina(masina);
    }

    public List<Masina> listeazaMasini() {
        return logicMasina.listeazaMasini();
    }

    public List<Utilizator> listeazaMasinaUnuiUtilizator() {
        return logicUtilizator.listeazaMasinaUnuiUtilizator();
    }

    public void deinregistreazaMasina(Masina masina) {
        logicMasina.deinregistreazaMasina(masina);
    }
}
