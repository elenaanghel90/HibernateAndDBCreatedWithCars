package com.sda.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Bl {

    public static StandardServiceRegistry registry;
    public static MetadataSources sources;
    public static Metadata metadata;
    public static SessionFactory sessionFactory;

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

    public Session getSession(){
        return getSessionFactory().openSession();
    }

    public static void main(String[] args) {
        Bl bl = new Bl();
        Session session = bl.getSession();
        session.close();
    }
}
